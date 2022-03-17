package com.bhongj.rc_week6.src.main.search.scr

import com.bhongj.rc_week6.src.main.search.restrntModel.GyungkiRestrntResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

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
