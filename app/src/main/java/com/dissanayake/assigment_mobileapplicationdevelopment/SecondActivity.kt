package com.dissanayake.assigment_mobileapplicationdevelopment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dissanayake.assigment_mobileapplicationdevelopment.adapters.Title_Adapter
import com.dissanayake.assigment_mobileapplicationdevelopment.post.api.PostApi
import com.dissanayake.assigment_mobileapplicationdevelopment.post.api.PostApiAll
import com.dissanayake.assigment_mobileapplicationdevelopment.post.models.Post
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_second2.*
import kotlinx.android.synthetic.main.title_card_view.*
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

//        var retro = retrofit.create(PostApi::class.java)
        var retroAll = retrofit.create(PostApiAll::class.java)
//        var postCall = retro.posts
        var postAllCall: Call<MutableList<Post>>? = retroAll.allPosts
        // api class if success then do this, otherwise it was do not
        postAllCall?.enqueue(object : Callback<MutableList<Post>> {
            override fun onResponse(call: Call<MutableList<Post>>, response: Response<MutableList<Post>>) {
                var posts = response.body()
                val layoutManager = LinearLayoutManager(this@SecondActivity)
                layoutManager.orientation = LinearLayoutManager.VERTICAL
                // attach recycle view to the layout manager
                recycleView.layoutManager = layoutManager

                val adapter = Title_Adapter(this@SecondActivity, posts!!)
                recycleView.adapter = adapter

//                for(post in posts!!) {
//                    var context = ""
//                    context = "Title : " + post.title + "\n"
//                    text_title_id.append(context)
//                }
            }

            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                Log.d("Post Call", t.toString())
            }

        })
    }
}