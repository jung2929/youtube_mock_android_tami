package com.example.youtube_clone.src.main.Home.interfaces;


import com.example.youtube_clone.src.main.Home.models.CommunityResponse;
import com.example.youtube_clone.src.main.Home.models.DefaultResponse;
import com.example.youtube_clone.src.main.Home.models.StoryResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MainRetrofitInterface {


    @GET("/videos")
    Call<DefaultResponse> getVideoPathAndQuery(
            @Query("page") final int page
    );

    @GET("/story-videos")
    Call<StoryResponse> getStoryPathAndQuery(
            @Query("page") final int page
    );

    @GET("/community-posts")
    Call<CommunityResponse> getCommunityPathAndQuery(
            @Query("page") final int page
    );

}
