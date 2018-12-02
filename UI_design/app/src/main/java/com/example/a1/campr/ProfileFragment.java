package com.example.a1.campr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a1.campr.AdopterActivity;
import com.example.a1.campr.ListerActivity;
import com.example.a1.campr.R;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {
    private TextView mback;
    private EditText name, city, email, contact;
    //private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mback = getActivity().findViewById(R.id.back);
        //view = getActivity().findViewById(R.id.frame);
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

        name = getActivity().findViewById(R.id.profile_edit_name);
        name.setInputType(InputType.TYPE_NULL);
        name.setBackground(null);
        name.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userName);
        city = getActivity().findViewById(R.id.profile_edit_city);
        city.setInputType(InputType.TYPE_NULL);
        city.setBackground(null);
        city.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userCity);
        email = getActivity().findViewById(R.id.profile_edit_email);
        email.setInputType(InputType.TYPE_NULL);
        email.setBackground(null);
        email.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userEmail);
        contact = getActivity().findViewById(R.id.profile_share_info);
        contact.setInputType(InputType.TYPE_NULL);
        contact.setBackground(null);

        contact.setSingleLine(false);
        //contact.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
        //Of particular importance, do not leave out the InputType.TYPE_CLASS_TEXT; it will not work without it!
        //contact.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        //contact.setMaxLines(10);
        contact.setText(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).userContact);

    }
}

