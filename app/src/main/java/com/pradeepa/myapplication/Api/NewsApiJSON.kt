package com.pradeepa.myapplication.Api


import com.google.gson.annotations.SerializedName

data class NewsApiJSON(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)