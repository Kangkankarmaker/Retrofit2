package com.kangkan.example.retrofit.retrofit2.Service;

import com.kangkan.example.retrofit.retrofit2.response.StudentResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface delete {

    @FormUrlEncoded
    @POST("/retrofit_class/delete.php")
    Call<StudentResponse> delete_user(

           @Field("id") String id

    );
}
