package com.bhongj.rc_week6.src.main.search

import com.bhongj.rc_week6.src.main.search.restrntModel.GyungkiRestrntResponse

interface SearchFragmentInterface {

    fun onGetDataSuccess(response: GyungkiRestrntResponse)

    fun onGetDataSizeSuccess(response: GyungkiRestrntResponse)

    fun onGetDataFailure(message: String)

//    fun onPostSignUpSuccess(response: SignUpResponse)
//
//    fun onPostSignUpFailure(message: String)
}