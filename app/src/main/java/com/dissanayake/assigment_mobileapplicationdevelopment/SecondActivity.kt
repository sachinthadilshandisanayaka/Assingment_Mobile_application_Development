package com.dissanayake.assigment_mobileapplicationdevelopment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dissanayake.assigment_mobileapplicationdevelopment.post.api.PostApi
import com.dissanayake.assigment_mobileapplicationdevelopment.post.models.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

        var retro = retrofit.create(PostApi::class.java)
        var postCall = retro.posts
        // api class if success then do this, otherwise it was do not
        postCall.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                var title = response.body()!!.title
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }

        })
    }
}