package com.sjs.edu.try_editname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String username = "신재순";
    String userage = "20";
    String usersex = "여자";
    String userJob = "학생";

    EditText editName, editAge;
    Button btnResult;
    TextView textResult;
    RadioGroup radioGroupSex, radioGroupJob;
    RadioButton radioButtonsexF, radioButtonsexM, radioButtonjobS, radioButtonjobW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText)findViewById(R.id.editTextName);
        editAge = (EditText)findViewById(R.id.editTextAge);
        btnResult = (Button)findViewById(R.id.btnResult);
        textResult = (TextView)findViewById(R.id.textresult);
        radioGroupSex = (RadioGroup)findViewById(R.id.radiogroupsex);
        radioButtonsexF = (RadioButton)findViewById(R.id.radiosexF);
        radioButtonsexM = (RadioButton)findViewById(R.id.radiosexM);
        radioGroupJob = (RadioGroup)findViewById(R.id.radiogroupJob);
        radioButtonjobS = (RadioButton)findViewById(R.id.radiobtnStudent);
        radioButtonjobW = (RadioButton)findViewById(R.id.radiobtnworker);

        editName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    username = editName.getText().toString();
                    return true;
                }
                return false;
            }
        });
        editAge.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    userage = editAge.getText().toString();
                    return true;
                }
                return false;
            }
        });

        radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId){
                   case R.id.radiosexF: usersex = "여자"; break;
                   case R.id.radiosexM: usersex = "남자"; break;
               }
            }
        });

        radioGroupJob.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radiobtnStudent: userJob = "학생"; break;
                    case R.id.radiobtnworker:  userJob = "직장인"; break;
                }
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "이름은 " + username.toString() + ", 나이는 "+ userage.toString() +
                        "세,  성별은 "  + usersex.toString() + " 직업은 " + userJob.toString() + "입니다.";
                textResult.setText(text);
            }
        });


    }
}
