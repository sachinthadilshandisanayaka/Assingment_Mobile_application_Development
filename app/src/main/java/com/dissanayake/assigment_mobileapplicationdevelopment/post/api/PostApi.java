package com.dissanayake.assigment_mobileapplicationdevelopment.post.api;

import com.dissanayake.assigment_mobileapplicationdevelopment.post.models.Post;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {

    @GET("/posts/1")
    Call<Post> getPosts();
}
