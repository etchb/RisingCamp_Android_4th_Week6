package com.bhongj.rc_week6.src.main.search

import com.bhongj.rc_week6.src.main.search.models.SignUpResponse
import com.bhongj.rc_week6.src.main.search.models.UserResponse

interface HomeFragmentInterface {

    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}