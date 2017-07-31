package com.example.mfahad.customlistview;

import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.ArrayList;

import static android.R.attr.resource;
import static com.example.mfahad.customlistview.R.id.imageView;

public class MainActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText designation;
    private Button insert;
    private ArrayList<Employee> arrayList;
    private ListView listView;
    private CustomAdapter customAdapter;
    public Employee emp;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        firstName = (EditText)findViewById(R.id.fname);
        lastName = (EditText)findViewById(R.id.lname);
        designation =(EditText)findViewById(R.id.designation);
        insert = (Button)findViewById(R.id.insert);
        listView = (ListView)findViewById(R.id.listView);

        arrayList = new ArrayList<Employee>();
        emp = new Employee();
        emp.setFirstName("Asad");
        emp.setDesignation("Manager");
        emp.setLastName("Saad");
        arrayList.add(emp);

        customAdapter = new CustomAdapter(this, R.layout.list_view_item , arrayList);
        listView.setAdapter(customAdapter);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstName.getText().toString().trim().equals("") || lastName.getText().toString().equals("")
                        ||designation.getText().toString().trim().equals("") ){
                    Toast.makeText(MainActivity.this, "Enter the Complete data", Toast.LENGTH_SHORT).show();
                }else{
                    Employee emp = new Employee();
                    emp.setFirstName(firstName.getText().toString());
                    emp.setLastName(lastName.getText().toString());
                    emp.setDesignation(designation.getText().toString());
                    arrayList.add(emp);
                    customAdapter.notifyDataSetChanged();

                    firstName.setText("");
                    lastName.setText("");
                    designation.setText("");
                    Toast.makeText(MainActivity.this, "Data Added", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
