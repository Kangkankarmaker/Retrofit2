package com.kangkan.example.retrofit.retrofit2.Service;

import com.kangkan.example.retrofit.retrofit2.response.StudentResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StudentService {

    @GET("/retrofit_class/r.php")
    Call<List<StudentResponse>> getAllStudent();
}
