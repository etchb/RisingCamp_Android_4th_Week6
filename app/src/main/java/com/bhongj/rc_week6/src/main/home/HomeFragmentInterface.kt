package com.bhongj.rc_week6.src.main.home

import com.bhongj.rc_week6.src.main.home.models.SignUpResponse
import com.bhongj.rc_week6.src.main.home.models.UserResponse

interface HomeFragmentInterface {

    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}