package com.bhongj.rc_week6.src.main.search

import android.os.Bundle
import android.util.Log
import android.view.View
import com.bhongj.rc_week6.R
import com.bhongj.rc_week6.config.BaseFragment
import com.bhongj.rc_week6.databinding.FragmentSearchBinding
import com.bhongj.rc_week6.src.main.search.restrntModel.GyungkiRestrntResponse
import com.bhongj.rc_week6.src.main.search.restrntModel.RestrntData
import com.bhongj.rc_week6.src.main.search.restrntModel.RestrntDataSize

class SearchFragment :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind, R.layout.fragment_search),
    SearchFragmentInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getRestaurantSize()
        getRestaurantDataList()

        binding.homeButtonTryGetJwt.setOnClickListener {
            Log.d("TEST RestrntDataSize", RestrntDataSize.toString())
            Log.d("TEST RestrntData.size", RestrntData.size.toString())
        }
    }

    override fun onGetDataSuccess(response: GyungkiRestrntResponse) {
        dismissLoadingDialog()
        val result = response.SafetyRestrntInfo
        RestrntData.addAll(result[1].row)
    }

    override fun onGetDataSizeSuccess(response: GyungkiRestrntResponse) {
        RestrntDataSize = response.SafetyRestrntInfo[0].head[0].list_total_count
    }

    override fun onGetDataFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    fun getRestaurantSize() {
        SearchService(this).tryGetRestaurantDataSize(getString(R.string.API_KEY), "json")
    }

    fun getRestaurantDataList() {
        showLoadingDialog(requireContext())
        val dataSizeMin = 1000
        Thread() {
            while (true) {
                Thread.sleep(100)
                Log.d("TEST", "RestrntDataSize = $RestrntDataSize")
                if (RestrntDataSize >= 0) {
                    break
                }
            }
            if (RestrntDataSize > 0) {
                for (pageIdx in 1..(RestrntDataSize / 1000)) {
                    if (pageIdx < dataSizeMin / 1000 + 1) {
                        SearchService(this).tryGetRestaurantData(
                            getString(R.string.API_KEY),
                            "json",
                            pageIdx,
                            1000
                        )
                    } else {
                        break
                    }
                }
//                SearchService(this).tryGetRestaurantData(
//                    getString(R.string.API_KEY), "json", (RestrntDataSize / 1000) + 1,
//                    RestrntDataSize % 1000
//                )
            }
        }.start()
    }

//    override fun onPostSignUpSuccess(response: SignUpResponse) {
//        dismissLoadingDialog()
//        binding.homeBtnTryPostHttpMethod.text = response.message
//        response.message?.let { showCustomToast(it) }
//    }
//
//    override fun onPostSignUpFailure(message: String) {
//        dismissLoadingDialog()
//        showCustomToast("오류 : $message")
//    }
}