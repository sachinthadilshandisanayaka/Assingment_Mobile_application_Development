package com.dissanayake.assigment_mobileapplicationdevelopment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dissanayake.assigment_mobileapplicationdevelopment.post.api.PostApi
import com.dissanayake.assigment_mobileapplicationdevelopment.post.models.Post
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_second2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)

        // gson is a decoder
        val gson = GsonBuilder()
                .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        var retro = retrofit.create(PostApi::class.java)
        var postCall = retro.posts
        // api class if success then do this, otherwise it was do not
        postCall.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                var title = response.body()!!.title
                Log.d("second activity", title)
                textView2.text = title.toString()
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }

        })
    }
}