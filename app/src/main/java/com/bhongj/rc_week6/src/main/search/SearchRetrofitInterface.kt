package com.bhongj.rc_week6.src.main.search

import com.bhongj.rc_week6.src.main.search.models.PostSignUpRequest
import com.bhongj.rc_week6.src.main.search.models.SignUpResponse
import com.bhongj.rc_week6.src.main.search.models.UserResponse
import com.bhongj.rc_week6.src.main.search.restrntModel.GyungkiRestrntResponse
import retrofit2.Call
import retrofit2.http.*

interface SearchRetrofitInterface {
//    @GET("/users")
//    fun getUsers(): Call<UserResponse>
//
//    @POST("/users")
//    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>

    @GET("/SafetyRestrntInfo")
    fun getRestaurantResponse(
        @Query("Key") Key: String,
        @Query("Type") Type: String,
        @Query("pIndex") pIndex: Int,
        @Query("pSize") pSize: Int,
    ): Call<GyungkiRestrntResponse>
}
