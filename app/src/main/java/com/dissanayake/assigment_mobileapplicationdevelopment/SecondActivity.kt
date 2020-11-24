package com.dissanayake.assigment_mobileapplicationdevelopment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dissanayake.assigment_mobileapplicationdevelopment.post.api.PostApi
import com.dissanayake.assigment_mobileapplicationdevelopment.post.api.PostApiAll
import com.dissanayake.assigment_mobileapplicationdevelopment.post.models.Post
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_second2.*
import retrofit2.*
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
        var retroAll = retrofit.create(PostApiAll::class.java)
        var postCall = retro.posts
        var postAllCall = retroAll.allPosts
        // api class if success then do this, otherwise it was do not
        postCall.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {

                // for noe item
//                var title = response.body()!!.title
//                Log.d("second activity", title)
//                textView2.text = title.toString()

                // for all items

                val allPostData = response.body()
                allPostData.forEach { data ->
                    val context = ""
                    context + = "userId :" + data.userId + "\n"
                    context + = "id :" + data.id+ "\n"
                    context + = "title :" + data.title+ "\n"
                    context + = "body" + data.body+ "\n"
                    textView2.append(context)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }

        })
    }
}