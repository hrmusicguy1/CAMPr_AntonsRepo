package com.example.a1.campr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a1.campr.AdopterActivity;
import com.example.a1.campr.ListerActivity;
import com.example.a1.campr.R;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {
    private TextView mback;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mback = getActivity().findViewById(R.id.back);
        view = getActivity().findViewById(R.id.frame);
        mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity().getClass().getSimpleName().equals("AdopterActivity")) {
                    Intent intent = new Intent(getActivity(), AdopterActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getActivity(), ListerActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}

