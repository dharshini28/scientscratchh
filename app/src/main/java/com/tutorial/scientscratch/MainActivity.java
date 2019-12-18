package com.tutorial.scientscratch;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button firebasebutton;
    private EditText txtname;
    private EditText txtdepartment;
    private EditText txtrollno;
    private EditText txttool;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebasebutton = (Button) findViewById(R.id.b1);
        txtname = (EditText) findViewById(R.id.et1);
        txtdepartment = (EditText) findViewById(R.id.et2);
        txtrollno = (EditText) findViewById(R.id.et3);
        txttool = (EditText) findViewById(R.id.et4);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("User");String name = txtname.getText().toString();

        firebasebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        String name = txtname.getText().toString();
                        String department =txtdepartment.getText().toString();
                        String rollno = txtrollno.getText().toString();
                        String tool = txttool.getText().toString();
                        Users users=new Users(name,department,rollno,tool);
                        mDatabase.setValue(users);
                        Toast.makeText(MainActivity.this,"Data inserted....",Toast.LENGTH_SHORT);
                    }
        });
    }
}


