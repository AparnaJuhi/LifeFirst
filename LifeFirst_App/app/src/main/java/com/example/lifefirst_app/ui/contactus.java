package com.example.lifefirst_app.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.lifefirst_app.R;

import java.util.regex.Pattern;

public class contactus extends Fragment {

    private ContactusViewModel mViewModel;
    private EditText contact_first_name,contact_last_name,contact_email,contact_contactno;

    private Button contact_submit;
    private AwesomeValidation awesomeValidation;

    public static contactus newInstance() {
        return new contactus();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.contactus_fragment, container, false);
        awesomeValidation = new AwesomeValidation(BASIC);
        contact_first_name = getActivity().findViewById(R.id.contact_firstname);
        contact_last_name = getActivity().findViewById(R.id.contact_lastname);
        contact_email = getActivity().findViewById(R.id.contact_email);
        contact_contactno = getActivity().findViewById(R.id.contact_contactno);
        contact_submit = root.findViewById(R.id.contact_submit);

        /*
        int flag_first_name=0;
        String first_name=contact_first_name.getText().toString();
        for(int i=0;i<first_name.length();i++)
        {
            if((first_name.charAt(i) >= 'a' && first_name.charAt(i) <= 'z') || (first_name.charAt(i) >= 'A' && first_name.charAt(i) <= 'Z'))
            {
                continue;
            }
            else
            {
                flag_first_name=1;
                break;
            }
        }
        if(first_name=="")
        {
            flag_first_name=1;
        }*/
        awesomeValidation.addValidation(getActivity(), R.id.contact_firstname, String.valueOf(Pattern.compile(String.valueOf(Pattern.compile("[a-zA-Z\\s]+")))), R.string.err_name);
        awesomeValidation.addValidation(getActivity(), R.id.contact_lastname, String.valueOf(Pattern.compile(String.valueOf(Pattern.compile("[a-zA-Z\\s]+")))), R.string.err_name);
        awesomeValidation.addValidation(getActivity(), R.id.contact_email, android.util.Patterns.EMAIL_ADDRESS, R.string.err_email);
        awesomeValidation.addValidation(getActivity(), R.id.contact_contactno, RegexTemplate.TELEPHONE, R.string.err_tel);


        contact_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()) {
                   // String contact_no = contact_contactno.getText().toString();
                    //String email = contact_email.getText().toString();
                    //String first_name = contact_first_name.getText().toString();
                    //String last_name = contact_last_name.getText().toString();
                    Toast.makeText(getActivity(), "Sucessfully Submitted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ContactusViewModel.class);

    }
}