package com.bhongj.rc_week6.src.main.search

import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.bhongj.rc_week6.R
import com.bhongj.rc_week6.config.BaseFragment
import com.bhongj.rc_week6.databinding.FragmentSearchBinding
import com.bhongj.rc_week6.src.main.search.map.GoogleMapFragment
import com.bhongj.rc_week6.src.main.search.scr.ScrollFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchFragment(val btmNav: BottomNavigationView) :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind, R.layout.fragment_search) {

    private lateinit var callback: OnBackPressedCallback
    val fragmentList = arrayListOf<Fragment>(ScrollFragment(), GoogleMapFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d("TEST STEP", "onCreate")
//        Log.d("TEST pageIdx", pageIdx.toString())
//        Log.d("TEST preRestrntDataSize", preRestrntDataSize.toString())
//
//        if (AdResourseData.size == 0) {
//            AdResourseData.add(R.drawable.ad1)
//            AdResourseData.add(R.drawable.ad2)
//            AdResourseData.add(R.drawable.ad3)
//            AdResourseData.add(R.drawable.ad4)
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TEST STEP", "onViewCreated")

//        if (RestrntDataSize < 0) {
//            getRestaurantSize()
//            getRestaurantDataList()
//        }

        binding.txtRegion.paintFlags = binding.txtRegion.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        childFragmentManager.beginTransaction().replace(R.id.frmlay_search, fragmentList[0])
            .addToBackStack(null)
            .commitAllowingStateLoss()

        binding.btnMap.setOnClickListener {
            childFragmentManager.beginTransaction().add(R.id.frmlay_search, fragmentList[1])
//                .addToBackStack(null)
                .commitAllowingStateLoss()
            btmNav.visibility = View.GONE
        }

        binding.btnRegionSearch.setOnClickListener {
            childFragmentManager.beginTransaction().remove(fragmentList[1])
                .commitAllowingStateLoss()
        }


//        val pagerAdapter = AdSlidePagerAdapter(requireActivity())
//        val mPager = binding.vpAd
//        mPager.adapter = pagerAdapter
//        mPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

//        val mIndicator = binding.vpAdIndi
//        mIndicator.setViewPager(mPager)
//        mIndicator.createIndicators(pagerAdapter.itemCount, 0)

//        mPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
//                if (positionOffsetPixels == 0) {
//                    mPager.currentItem = position
//                }
//            }
//
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                mIndicator.animatePageSelected(position % pagerAdapter.itemCount)
//            }
//        })

//        restrntDataFil = RestrntData.filter { it.SIGNGU_NM == "?????????" }.toMutableList()
//        val adapter = FoodRcvAdapter(restrntDataFil)
//        val foodRcyView = binding.rcvFood
//        foodRcyView.layoutManager = GridLayoutManager(context, 2)
//        foodRcyView.setHasFixedSize(true)
//        foodRcyView.adapter = adapter
//
//        binding.scrSearch.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
//            if (!v.canScrollVertically(1)) {
//                Log.d("TEST scroll", "End of list")
//                getRestaurantDataList()
//            }
//        }

//        foodRcyView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//
//                // ???????????? ?????? ??????????????? ??????
//                if (!foodRcyView.canScrollVertically(1)) {
//                    Log.d("TEST scroll", "End of list")
//                }
//
//                val lastVisibleItemPosition = (recyclerView.layoutManager as GridLayoutManager?)!!.findLastCompletelyVisibleItemPosition() // ????????? ????????? ????????? ???????????? position
//                val itemTotalCount = recyclerView.adapter!!.itemCount - 1 // ???????????? ????????? ???????????? ??? ?????? -1
//                Log.d("TEST scroll itemTotalCount", itemTotalCount.toString())
//                Log.d("TEST scroll lastVisibleItemPosition", lastVisibleItemPosition.toString())
//
//
//                // ???????????? ?????? ??????????????? ??????
//                if (lastVisibleItemPosition == itemTotalCount) {
//                    Log.d("TEST scroll", "End of list")
//                }
//            }
//        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (fragmentList[1] in childFragmentManager.fragments) {
                    Log.d("TEST fragment[1]", "exist")
                    childFragmentManager.beginTransaction()
                        .remove(fragmentList[1])
                        .commitAllowingStateLoss()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

//    private inner class AdSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
//        override fun getItemCount(): Int = AdResourseData.size
//
//        override fun createFragment(position: Int): Fragment {
//            return when (position) {
//                in 0 until this.itemCount -> {
//                    AdSlideFragment(AdResourseData[position])
//                }
//                else -> AdSlideFragment(R.drawable.ad1)
//            }
//        }
//    }

//    @SuppressLint("NotifyDataSetChanged")
//    override fun onGetDataSuccess(response: GyungkiRestrntResponse) {
//        dismissLoadingDialog()
//        val result = response.SafetyRestrntInfo
//        RestrntData.addAll(result[1].row)
//
////        binding.rcvFood.adapter?.notifyDataSetChanged()
////        Log.d("TEST RestrntData.size22", RestrntData.size.toString())
//    }
//
//    override fun onGetDataSizeSuccess(response: GyungkiRestrntResponse) {
//        RestrntDataSize = response.SafetyRestrntInfo[0].head[0].list_total_count
//    }
//
//    override fun onGetDataFailure(message: String) {
//        dismissLoadingDialog()
//        showCustomToast("?????? : $message")
//    }
//
//    fun getRestaurantSize() {
//        SearchService(this).tryGetRestaurantDataSize(getString(R.string.API_KEY), "json")
//    }
//
//    fun getRestaurantDataList() {
//        showLoadingDialog(requireContext())
//        val onceGetDataSize = 1000
//        Thread() {
//            while (true) {
//                Thread.sleep(100)
//                if (RestrntDataSize >= 0) {
//                    break
//                }
//            }
//            if (RestrntDataSize > 0) {
//                if (RestrntDataSize - RestrntData.size >= onceGetDataSize) {
//                    pageIdx++
//                    preRestrntDataSize = RestrntData.size
//                    SearchService(this).tryGetRestaurantData(
//                        getString(R.string.API_KEY),
//                        "json",
//                        pageIdx,
//                        onceGetDataSize
//                    )
//                } else if (RestrntDataSize - RestrntData.size > 0) {
//                    pageIdx++
//                    preRestrntDataSize = RestrntData.size
//                    SearchService(this).tryGetRestaurantData(
//                        getString(R.string.API_KEY),
//                        "json",
//                        pageIdx,
//                        RestrntDataSize - RestrntData.size
//                    )
//                }
//            }
//            while (true) {
//                Thread.sleep(100)
//                if ((RestrntDataSize == 0) or (RestrntData.size > preRestrntDataSize)) {
//                    preRestrntDataSize = RestrntData.size
//                    val handler = Handler(Looper.getMainLooper())
//                    handler.post {
//                        restrntDataFil.addAll(
//                            RestrntData.takeLast(1000).filter { it.SIGNGU_NM == "?????????" }
//                                .toMutableList()
//                        )
//                        binding.rcvFood.adapter?.notifyDataSetChanged()
//                        Log.d("TEST handler", "notifyDataSetChanged")
//                    }
//                    break
//                }
//            }
//            for (len in 1..RestrntData.size / 6) {
//                var idx = 0
//                RestrntData[(len - 1) * 6 + idx].RATE =
//                    (((Math.random() * 30).toInt() + 21).toFloat() / 10f)
//                RestrntData[(len - 1) * 6 + idx++].PIC = R.drawable.food1
//                RestrntData[(len - 1) * 6 + idx].RATE =
//                    (((Math.random() * 30).toInt() + 21).toFloat() / 10f)
//                RestrntData[(len - 1) * 6 + idx++].PIC = R.drawable.food2
//                RestrntData[(len - 1) * 6 + idx].RATE =
//                    (((Math.random() * 30).toInt() + 21).toFloat() / 10f)
//                RestrntData[(len - 1) * 6 + idx++].PIC = R.drawable.food3
//                RestrntData[(len - 1) * 6 + idx].RATE =
//                    (((Math.random() * 30).toInt() + 21).toFloat() / 10f)
//                RestrntData[(len - 1) * 6 + idx++].PIC = R.drawable.food4
//                RestrntData[(len - 1) * 6 + idx].RATE =
//                    (((Math.random() * 30).toInt() + 21).toFloat() / 10f)
//                RestrntData[(len - 1) * 6 + idx++].PIC = R.drawable.food5
//                RestrntData[(len - 1) * 6 + idx].RATE =
//                    (((Math.random() * 30).toInt() + 21).toFloat() / 10f)
//                RestrntData[(len - 1) * 6 + idx++].PIC = R.drawable.food6
//            }
//        }.start()
//    }

//    override fun onPostSignUpSuccess(response: SignUpResponse) {
//        dismissLoadingDialog()
//        binding.homeBtnTryPostHttpMethod.text = response.message
//        response.message?.let { showCustomToast(it) }
//    }
//
//    override fun onPostSignUpFailure(message: String) {
//        dismissLoadingDialog()
//        showCustomToast("?????? : $message")
//    }
}