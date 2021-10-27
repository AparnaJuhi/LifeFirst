package com.example.lifefirst_app.ui;
import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;
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

import com.example.lifefirst_app.R;

import java.util.regex.Pattern;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
public class joinus extends Fragment {

    private JoinusViewModel mViewModel;
    private EditText joinus_first_name,joinus_last_name,joinus_email,joinus_contactno;
    private Button join_submit;
    private AwesomeValidation awesomeValidation;
    public static joinus newInstance() {
        return new joinus();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.joinus_fragment, container, false);

        awesomeValidation = new AwesomeValidation(BASIC);
        joinus_first_name = root.findViewById(R.id.joinus_firstname);
        joinus_last_name = root.findViewById(R.id.joinus_lastname);
        joinus_email = root.findViewById(R.id.joinus_email);
        joinus_contactno = root.findViewById(R.id.joinus_contactno);
        join_submit = root.findViewById(R.id.joinus_submit);


        awesomeValidation.addValidation(getActivity(), R.id.joinus_firstname, String.valueOf(Pattern.compile(String.valueOf(Pattern.compile("[a-zA-Z\\s]+")))), R.string.err_name);
        awesomeValidation.addValidation(getActivity(), R.id.joinus_lastname, String.valueOf(Pattern.compile(String.valueOf(Pattern.compile("[a-zA-Z\\s]+")))), R.string.err_name);
        awesomeValidation.addValidation(getActivity(), R.id.joinus_email, android.util.Patterns.EMAIL_ADDRESS, R.string.err_email);
        awesomeValidation.addValidation(getActivity(), R.id.joinus_contactno, RegexTemplate.TELEPHONE, R.string.err_tel);



        join_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()) {
                    String contact1 = joinus_contactno.getText().toString();
                    String email1 = joinus_email.getText().toString();
                    String last_name = joinus_last_name.getText().toString();
                    String first_name = joinus_first_name.getText().toString();
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
        mViewModel = new ViewModelProvider(this).get(JoinusViewModel.class);
        // TODO: Use the ViewModel
    }

}