package com.pradeepa.myapplication

import com.pradeepa.myapplication.Api.Article
import com.pradeepa.myapplication.Api.NewsApiJSON
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiRequest {
    @GET("/v2/top-headlines?country=us&category=business&apiKey=79f8b4c7f7d5468c900f1a56bb7b48a9")
    fun getNews():Call<NewsApiJSON>

companion object{
    operator fun invoke():ApiRequest{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)
    }
}

}