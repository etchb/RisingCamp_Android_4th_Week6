package com.bhongj.rc_week6.src.main.search.models

import com.google.gson.annotations.SerializedName

data class ResultSignUp(
    @SerializedName("userId") val userId: Int,
    @SerializedName("jwt") val jwt: String
)