package com.example.activaty1;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;
    private List<Student> allStudents;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchView);

        allStudents = new ArrayList<>();
        allStudents.add(new Student(1, "Ahmad", "Software Engineering"));
        allStudents.add(new Student(2, "Suhaib", "Data science"));
        allStudents.add(new Student(3, "Khaled", "Business"));
        allStudents.add(new Student(4, "Mousa", "Computer science"));
        allStudents.add(new Student(5, "Omar", "Computer Engineering"));

        adapter = new StudentAdapter(this, allStudents);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Student clickedStudent = adapter.getItem(position);
            String message = "name : " + clickedStudent.getName() + "\nmajor: " + clickedStudent.getMajor();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }
    private void filterList(String text) {
        List<Student> filteredList = new ArrayList<>();
        for (int i = 0; i < allStudents.size(); i++) {
            Student student = allStudents.get(i);
            if (student.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(student);
            }
        }
        adapter.setFilteredList(filteredList);
    }
}
