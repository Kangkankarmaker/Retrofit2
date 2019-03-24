package com.kangkan.example.retrofit.retrofit2.Service;

import com.kangkan.example.retrofit.retrofit2.response.StudentResponse;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface update {

    @FormUrlEncoded
    @POST("/retrofit_class/update.php")
    Call<StudentResponse> getAllStudent(

            @Field("id") String a,
            @Field("name") String Name
    );
}




