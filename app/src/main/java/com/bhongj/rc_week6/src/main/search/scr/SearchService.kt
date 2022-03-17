package com.bhongj.rc_week6.src.main.search.scr

import com.bhongj.rc_week6.config.ApplicationClass
import com.bhongj.rc_week6.src.main.search.restrntModel.GyungkiRestrntResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchService(val searchFragmentInterface: SearchFragmentInterface) {

    fun tryGetRestaurantData(Key: String, Type: String, pIndex: Int, pSize: Int) {
        val searchRetrofitInterface =
            ApplicationClass.sRetrofit.create(SearchRetrofitInterface::class.java)
        searchRetrofitInterface.getRestaurantResponse(Key, Type, pIndex, pSize)
            .enqueue(object : Callback<GyungkiRestrntResponse> {
                override fun onResponse(
                    call: Call<GyungkiRestrntResponse>,
                    response: Response<GyungkiRestrntResponse>
                ) {
                    searchFragmentInterface.onGetDataSuccess(response.body() as GyungkiRestrntResponse)
                }

                override fun onFailure(call: Call<GyungkiRestrntResponse>, t: Throwable) {
                    searchFragmentInterface.onGetDataFailure(t.message ?: "통신 오류")
                }
            })
    }

    fun tryGetRestaurantDataSize(Key: String, Type: String) {
        val searchRetrofitInterface =
            ApplicationClass.sRetrofit.create(SearchRetrofitInterface::class.java)
        searchRetrofitInterface.getRestaurantResponse(Key, Type, 1, 1)
            .enqueue(object : Callback<GyungkiRestrntResponse> {
                override fun onResponse(
                    call: Call<GyungkiRestrntResponse>,
                    response: Response<GyungkiRestrntResponse>
                ) {
                    searchFragmentInterface.onGetDataSizeSuccess(response.body() as GyungkiRestrntResponse)
                }

                override fun onFailure(call: Call<GyungkiRestrntResponse>, t: Throwable) {
                    searchFragmentInterface.onGetDataFailure(t.message ?: "통신 오류")
                }
            })
    }

//    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest){
//        val searchRetrofitInterface = ApplicationClass.sRetrofit.create(SearchRetrofitInterface::class.java)
//        searchRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object : Callback<SignUpResponse>{
//            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
//                searchFragmentInterface.onPostSignUpSuccess(response.body() as SignUpResponse)
//            }
//
//            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
//                searchFragmentInterface.onPostSignUpFailure(t.message ?: "통신 오류")
//            }
//        })
//    }

}
