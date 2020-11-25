package com.dissanayake.assigment_mobileapplicationdevelopment.post.api;

import com.dissanayake.assigment_mobileapplicationdevelopment.post.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApiAll {

    @GET("posts")
    Call<List<Post>> getAllPosts();
}
