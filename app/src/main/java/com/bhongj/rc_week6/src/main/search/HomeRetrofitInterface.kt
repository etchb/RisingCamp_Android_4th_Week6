package com.bhongj.rc_week6.src.main.search

import com.bhongj.rc_week6.src.main.search.models.PostSignUpRequest
import com.bhongj.rc_week6.src.main.search.models.SignUpResponse
import com.bhongj.rc_week6.src.main.search.models.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface HomeRetrofitInterface {
    @GET("/users")
    fun getUsers() : Call<UserResponse>

    @POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>
}
