package com.example.firebasepushpull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewPost extends AppCompatActivity {

    FirebaseDatabase Db;
    DatabaseReference DbRef;
    TextView L1,L2;
    List<Post> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);


        Db = FirebaseDatabase.getInstance();
        DbRef = Db.getReference("Posts");
        L1=findViewById(R.id.postview);
    }

    @Override
    protected void onStart() {
        super.onStart();

        DbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                // StringBuffer stringbuffer = new StringBuffer();
                for(DataSnapshot dataSnapshot1 :snapshot.getChildren()){

                    Post Postdetails = dataSnapshot1.getValue(Post.class);
                    String NewPost = Postdetails.getPost();
                    L1.setText(NewPost);
                }

            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

            }
        });
    }
}