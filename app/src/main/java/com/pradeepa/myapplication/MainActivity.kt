package com.pradeepa.myapplication

import android.os.BaseBundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import com.pradeepa.myapplication.Adapater.RecyclerAdapter
import com.pradeepa.myapplication.Api.Article
import com.pradeepa.myapplication.Api.NewsApiJSON
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.util.*

const val BASE_URL="https://newsapi.org"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeAPIRequest();
    }
    //Loader animation
    private fun fadeInBlackScreen(){
        v_blackscreen.animate().apply {
            alpha(0f)
            duration=1000
        }.start()
    }
private fun makeAPIRequest(){
pb_progressbar.visibility=View.VISIBLE
    ApiRequest().getNews().enqueue(object :Callback<NewsApiJSON>{
        override fun onFailure(call: Call<NewsApiJSON>, t: Throwable) {
                Toast.makeText(applicationContext,t.message,Toast.LENGTH_SHORT).show()
        }

        override fun onResponse(call: Call<NewsApiJSON>, response: Response<NewsApiJSON>) {
           val articles=response.body()!!.articles

            rv_recyclerview.layoutManager= LinearLayoutManager(this@MainActivity)
            rv_recyclerview.adapter=RecyclerAdapter(articles)
            pb_progressbar.visibility=View.GONE
            fadeInBlackScreen()

        }
})

}
}
