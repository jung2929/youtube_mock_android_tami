package com.example.youtube_clone.src.main.Home;

import com.example.youtube_clone.src.main.Home.interfaces.MainActivityView;
import com.example.youtube_clone.src.main.Home.interfaces.MainRetrofitInterface;
import com.example.youtube_clone.src.main.Home.models.CommunityResponse;
import com.example.youtube_clone.src.main.Home.models.DefaultResponse;
import com.example.youtube_clone.src.main.Home.models.StoryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youtube_clone.src.ApplicationClass.getRetrofit;

class HomeService {
    private  MainActivityView mMainActivityView;

    HomeService(final MainActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }


   void getVideoPathAndQuery(final int pageNum) {
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.getVideoPathAndQuery(pageNum).enqueue(new Callback<DefaultResponse>() {
            @Override //실패
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body(); // 파싱된 값들이 있음
                if (defaultResponse == null) {
                    mMainActivityView.validateFailure(null); //뷰에 실패했다고 나타냄
                    return;
                }
                mMainActivityView.validateSuccess(defaultResponse.getResult(), pageNum); // 데이터 클래스를 넘겨줌
            }

            @Override  //실패
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null); //뷰에 실패했다고 나타냄
            }
        });
    }

    void getCommunityPathAndQuery(final int pageNum) {
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.getCommunityPathAndQuery(pageNum).enqueue(new Callback<CommunityResponse>() {
            @Override //실패
            public void onResponse(Call<CommunityResponse> call, Response<CommunityResponse> response) {
                final CommunityResponse communityResponse = response.body(); // 파싱된 값들이 있음
                if (communityResponse == null) {
                    mMainActivityView.validateFailure(null); //뷰에 실패했다고 나타냄
                    return;
                }
                mMainActivityView.validateSuccess(communityResponse.getResult(), pageNum); // 데이터 클래스를 넘겨줌
            }

            @Override  //실패
            public void onFailure(Call<CommunityResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null); //뷰에 실패했다고 나타냄
            }
        });
    }


    void getStoryPathAndQuery(final int pageNum) {
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.getStoryPathAndQuery(pageNum).enqueue(new Callback<StoryResponse>() {
            @Override //실패
            public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
                final StoryResponse storyResponse = response.body(); // 파싱된 값들이 있음
                if (storyResponse == null) {
                    mMainActivityView.validateFailure(null); //뷰에 실패했다고 나타냄
                    return;
                }
                mMainActivityView.validateSuccess(storyResponse.getResult(), pageNum); // 데이터 클래스를 넘겨줌
            }

            @Override  //실패
            public void onFailure(Call<StoryResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null); //뷰에 실패했다고 나타냄
            }
        });
    }





}
