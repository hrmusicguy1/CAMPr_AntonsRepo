package com.example.a1.campr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class AddNewActivity extends AppCompatActivity {
    private static final int RESULT_REQUEST =1;
    private Bitmap pic;
    private Pets pet;
    private TextView name, gender, info;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pets);

        ImageView image = findViewById(R.id.edit_pet);
        image.setVisibility(View.GONE);
        Button listpet = findViewById(R.id.button);
        listpet.setText("LIST PET");
        name = findViewById(R.id.textView);
        name.setHint("Enter name");
        name.setGravity(Gravity.CENTER_HORIZONTAL);
        name.requestFocus();
        gender = findViewById(R.id.textView2);
        gender.setHint("Enter gender");
        gender.setGravity(Gravity.CENTER_HORIZONTAL);
        info = findViewById(R.id.textView3);
        info.setHint("Enter brief info");


        image = findViewById(R.id.imageView);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, RESULT_REQUEST);
            }
        });

        listpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pet = new Pets(name.getText().toString(), gender.getText().toString(),
                        info.getText().toString(), Long.toString(System.currentTimeMillis()),
                        Integer.toString(LoginActivity.currentUser), pic);
                //LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).listedPets.add(pet);
                PetsFragment.input.add(pet);
                PetsFragment.myPets.put(pet.getPetId(), pet);
                AdopterActivity.adoptionPets.add(pet);
                //PetsFragment.input.add(new Pets(name, gender, info, name+gender+info, pic));
                //PetsFragment.myPets.put(name+gender+info, new Pets(name, gender, info, name+gender+info, pic));
                PetsFragment.recyclerView.getAdapter().notifyDataSetChanged();
                finish();
            }
        });

        Button cancel = findViewById(R.id.button_right);
        cancel.setText("Go back");
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case RESULT_REQUEST:
                    Uri selectedImage = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        pic = bitmap;
                        ImageView imageView = findViewById(R.id.imageView);
                        imageView.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        Log.i("TAG", "Some exception " + e);
                    }
                    break;
            }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}

