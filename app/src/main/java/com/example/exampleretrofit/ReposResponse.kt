package com.example.exampleretrofit

import com.google.gson.annotations.SerializedName

data class ReposResponse(
    @SerializedName("full_name")
    val nameRepo: String
)
