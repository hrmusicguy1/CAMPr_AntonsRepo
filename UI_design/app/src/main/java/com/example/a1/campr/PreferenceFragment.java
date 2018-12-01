package com.example.a1.campr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.a1.campr.AdopterActivity;
import com.example.a1.campr.R;

public class PreferenceFragment extends Fragment {
    private TextView mback;
    private View view;
    Spinner spinner_breed;
    Spinner spinner_species;
    Spinner spinner_age;
    Spinner spinner_color;
    Spinner spinner_size;
    Spinner spinner_adoption_fee;
    ArrayAdapter<CharSequence> adapter_species;
    ArrayAdapter<CharSequence> adapter_breed;
    ArrayAdapter<CharSequence> adapter_age;
    ArrayAdapter<CharSequence> adapter_color;
    ArrayAdapter<CharSequence> adapter_size;
    ArrayAdapter<CharSequence> adapter_adoption_fee;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_preference,container,false);
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        spinner_species = (Spinner) getActivity().findViewById(R.id.spinner_species);
        adapter_species = ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.species,android.R.layout.simple_spinner_item);
        adapter_species.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_species.setAdapter(adapter_species);

        spinner_breed = (Spinner) getActivity().findViewById(R.id.spinner_breed);
        adapter_breed = ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.breeds,android.R.layout.simple_spinner_item);
        adapter_breed.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_breed.setAdapter(adapter_breed);

        spinner_age = (Spinner) getActivity().findViewById(R.id.spinner_age);
        adapter_age = ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.age,android.R.layout.simple_spinner_item);
        adapter_age.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_age.setAdapter(adapter_age);

        spinner_color = (Spinner) getActivity().findViewById(R.id.spinner_color);
        adapter_color = ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.color,android.R.layout.simple_spinner_item);
        adapter_color.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_color.setAdapter(adapter_color);

        spinner_size = (Spinner) getActivity().findViewById(R.id.spinner_size);
        adapter_size = ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.size,android.R.layout.simple_spinner_item);
        adapter_size.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_size.setAdapter(adapter_size);

        spinner_adoption_fee = (Spinner) getActivity().findViewById(R.id.spinner_adoption_fee);
        adapter_adoption_fee = ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.adoption_fee,android.R.layout.simple_spinner_item);
        adapter_adoption_fee.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_adoption_fee.setAdapter(adapter_adoption_fee);

        mback = getActivity().findViewById(R.id.back);
        view = getActivity().findViewById(R.id.frame);
        mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AdopterActivity.class);
                startActivity(intent);
            }
        });
    }
}
