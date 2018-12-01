package com.example.a1.campr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewApplicantActivity extends AppCompatActivity {
    private TextView name, gender, info;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pets);

        ImageView edit = findViewById(R.id.edit_pet);
        edit.setVisibility(View.GONE);

        User user = LoginActivity.myData.dataUsers.get(Integer.parseInt(getIntent().getExtras().getString("user_id")));
        name = findViewById(R.id.textView);
        name.setInputType(InputType.TYPE_NULL);
        name.setBackground(null);
        name.setText(user.userName);
        gender = findViewById(R.id.textView2);
        gender.setInputType(InputType.TYPE_NULL);
        gender.setBackground(null);
        info = findViewById(R.id.textView3);
        info.setInputType(InputType.TYPE_NULL);
        info.setBackground(null);
        info.setText(ApplicantsActivity.pet.applicantId.get(user.userID));

        Button accept = findViewById(R.id.button);
        accept.setText("ACCEPT");
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button decline = findViewById(R.id.button_right);
        decline.setText("Decline");
        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
