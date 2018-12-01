package com.example.a1.campr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewPetsActivity extends AppCompatActivity {
    private TextView name, gender, info;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pets);

        Pets pet = getIntent().getParcelableExtra("parcel_data");
        name = findViewById(R.id.textView);
        name.setInputType(InputType.TYPE_NULL);
        name.setBackground(null);
        name.setText(pet.getName());
        gender = findViewById(R.id.textView2);
        gender.setInputType(InputType.TYPE_NULL);
        gender.setBackground(null);
        gender.setText(pet.getGender());
        info = findViewById(R.id.textView3);
        info.setInputType(InputType.TYPE_NULL);
        info.setBackground(null);
        info.setText(pet.getInfo());
        ImageView imageView = findViewById(R.id.imageView);
        pet = PetsFragment.myPets.get(pet.getPetId());
        imageView.setImageBitmap(pet.getPetPic());

        Button goBack = findViewById(R.id.button_right);
        goBack.setText("Go back");
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void deletePet(View view) {
        Pets pet = getIntent().getParcelableExtra("parcel_data");
        //remove pet from lister local list
        PetsFragment.input.remove(pet);
        //remove pet from lister local hashmap
        PetsFragment.myPets.remove(pet.getPetId());
        //remove pet from lister database (todo)
        //LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).listedPets.remove(pet);
        //remove pet from local machine card stack
        AdopterActivity.adoptionPets.remove(pet);
        LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).chosenPets.remove(pet);
        PetsFragment.recyclerView.getAdapter().notifyDataSetChanged();
        finish();
    }

    public void editPet(View view) {
        Pets pet = getIntent().getParcelableExtra("parcel_data");
        Intent intent = new Intent(this, EditPet.class);
        intent.putExtra("parcel_data", pet);
        finish();
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}
