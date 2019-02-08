package com.example.sahithi.objectparsing;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface GetDataService {
    @GET("v2/5c5d33aa32000036112206b5")
    Call<List<ImageModel>> getAllPhotosList();

}
