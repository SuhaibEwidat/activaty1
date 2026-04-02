package com.example.activaty1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;
    private List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        super(context, 0, studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        }

        Student student = studentList.get(position);

        TextView nameTextView = convertView.findViewById(R.id.textName);
        TextView majorTextView = convertView.findViewById(R.id.textMajor);

        nameTextView.setText(student.getName());
        majorTextView.setText(student.getMajor());

        return convertView;
    }

    public void setFilteredList(List<Student> filteredList) {
        this.studentList = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Student getItem(int position) {
        return studentList.get(position);
    }
}