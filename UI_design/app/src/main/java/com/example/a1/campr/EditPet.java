package com.example.a1.campr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class EditPet extends AppCompatActivity {
    private static final int RESULT_REQUEST = 1;
    private Bitmap profile_pic;
    private Pets pet;
    private TextView name, gender, info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pets);

        pet = getIntent().getParcelableExtra("parcel_data");
        pet = PetsFragment.myPets.get(pet.getPetId());
        ImageView image = findViewById(R.id.imageView);
        image.setImageBitmap(pet.getPetPic());
        name = findViewById(R.id.textView);
        name.setText(pet.getName());
        gender = findViewById(R.id.textView2);
        gender.setText(pet.getGender());
        info = findViewById(R.id.textView3);
        info.setText(pet.getInfo());
        profile_pic = pet.getPetPic();

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, RESULT_REQUEST);
            }
        });

        Button cancel = findViewById(R.id.button_right);
        cancel.setText("Cancel");
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button save = findViewById(R.id.button);
        save.setText("Save");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PetsFragment.input.remove(pet);
                pet.setName(name.getText().toString());
                pet.setGender(gender.getText().toString());
                pet.setInfo(info.getText().toString());
                pet.setPetPic(profile_pic);

                PetsFragment.input.add(pet);
                PetsFragment.myPets.put(pet.getPetId(), pet);
                PetsFragment.recyclerView.getAdapter().notifyDataSetChanged();
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
                        profile_pic = bitmap;
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
