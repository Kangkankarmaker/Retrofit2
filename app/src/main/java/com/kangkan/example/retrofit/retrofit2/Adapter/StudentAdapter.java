package com.kangkan.example.retrofit.retrofit2.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kangkan.example.retrofit.retrofit2.R;
import com.kangkan.example.retrofit.retrofit2.response.StudentResponse;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<StudentResponse> {

    private Context context;
    private List<StudentResponse> responses;
    public StudentAdapter(@NonNull Context context, List<StudentResponse> responses) {
        super(context, R.layout.student_rows ,responses);
        this.context =context;
        this.responses = responses;
    }

    class ViewHolder{
        TextView stuName,stuPhone;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            convertView = inflater.inflate(R.layout.student_rows, parent, false);

            viewHolder.stuName = convertView.findViewById(R.id.stu_name);
            viewHolder.stuPhone = convertView.findViewById(R.id.stu_phone);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.stuName.setText(responses.get(position).getName());
        viewHolder.stuPhone.setText(String.valueOf(responses.get(position).getPhone()));
        return convertView;

    }
}
