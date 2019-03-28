package com.kangkan.example.retrofit.retrofit2;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kangkan.example.retrofit.retrofit2.Adapter.StudentAdapter;
import com.kangkan.example.retrofit.retrofit2.Service.StudentService;
import com.kangkan.example.retrofit.retrofit2.Service.delete;
import com.kangkan.example.retrofit.retrofit2.Service.update;
import com.kangkan.example.retrofit.retrofit2.response.StudentResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.kangkan.example.retrofit.retrofit2.MainActivity.BASE_URL;

public class StudentDetails extends AppCompatActivity {
    protected TextView textView;
    EditText editText;
    Button button,btndelete;
    String name;

    public static final String BASE_URL = "https://untearable-trays.000webhostapp.com";
    private update service;

    private delete de_service;
     ImageView imageView;

    String photoString;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        imageView = findViewById(R.id.stu_imageView);
        textView = findViewById(R.id.stu_textView);

        editText=findViewById(R.id.ext_name);
        button=findViewById(R.id.btn_go);
        btndelete=findViewById(R.id.btn_delete);


        final StudentResponse studentResponse = (StudentResponse) getIntent().getSerializableExtra("Student");

        photoString = studentResponse.getEmail();
        Uri photoUri = Uri.parse(BASE_URL+"/image/"+photoString);
        Picasso.get().load(photoUri).into(imageView);

        textView.setText(studentResponse.getName()+"\n"+studentResponse.getAddress()+"\n"+studentResponse.getPhone());
        editText.setText(studentResponse.getName());



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id;
                id=studentResponse.getId();
                name=editText.getText().toString();
                updatedata(id,name);
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id;
                id=studentResponse.getId();
                deletedata(id);
            }
        });
    }


    private void updatedata(String i, String aname) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(update.class);

        Call<StudentResponse> call =service.getAllStudent(i,aname);
        call.enqueue(new Callback<StudentResponse>() {
            @Override
            public void onResponse(Call<StudentResponse> call, Response<StudentResponse> response) {

                    Toast.makeText(StudentDetails.this, "hoisa", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<StudentResponse> call, Throwable t) {
               // Toast.makeText(StudentDetails.this, "No internet connection", Toast.LENGTH_LONG).show();
                Toast.makeText(StudentDetails.this,t.getMessage()+"",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void deletedata(String u_id) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        de_service = retrofit.create(delete.class);
        Call<StudentResponse> call =de_service.delete_user(u_id);
        call.enqueue(new Callback<StudentResponse>() {
            @Override
            public void onResponse(Call<StudentResponse> call, Response<StudentResponse> response) {

                Toast.makeText(StudentDetails.this, "Deleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<StudentResponse> call, Throwable t) {
                Toast.makeText(StudentDetails.this,t.getMessage()+"",Toast.LENGTH_LONG).show();
            }
        });


    }
}
