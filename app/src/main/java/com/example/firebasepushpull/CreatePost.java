package com.example.firebasepushpull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreatePost extends AppCompatActivity {


    EditText post;
    Button save, go;
    FirebaseDatabase Db;
    DatabaseReference DbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        post=findViewById(R.id.editTextTextPersonName);
        save=findViewById(R.id.button);
        go =findViewById(R.id.button2);
        Db = FirebaseDatabase.getInstance();
        DbRef = Db.getReference("Posts");


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!post.getText().toString().isEmpty()){
                   try {
                       String key = DbRef.push().getKey();
                       Post newPost = new Post(key, post.getText().toString());

                       DbRef.child("key").setValue(newPost);

                       Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                       post.setText("");

                   }catch (Exception e){
                       Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                   }
                }
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewPost.class);
                startActivity(intent);
            }
        });

    }
}