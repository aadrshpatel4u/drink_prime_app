package com.example.android.drinkprime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity implements View.OnClickListener{

    EditText name;
    EditText email;
    EditText number;
    EditText city;
    Button register;
    Button already;

    String _name;
    String _email;
    String _number;
    String _city;
    SharedPreferences myfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name   = (EditText) findViewById(R.id.editText_name);
        email  = (EditText) findViewById(R.id.editText_email);
        number = (EditText) findViewById(R.id.editText_number);
        city   = (EditText) findViewById(R.id.editText_city);

        register = (Button) findViewById(R.id.button_register);
        already  = (Button) findViewById(R.id.button_already);

        register.setOnClickListener(this);
        already.setOnClickListener(this);

        myfile = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_register: {
                // do something for button 1 click
                _name   = name.getText().toString();
                _email  = email.getText().toString();
                _number = number.getText().toString();
                _city   = city.getText().toString();
                if(_name.equals("")){
                    Toast.makeText(getApplicationContext(), "Name is required",Toast.LENGTH_SHORT).show();
                    break;
                }
                if(_email.equals("")){
                    Toast.makeText(getApplicationContext(), "Email is required",Toast.LENGTH_SHORT).show();
                    break;
                }
                if(!isValidEmail(_email)) {
                    Toast.makeText(getApplicationContext(), "Invalid Email Address",Toast.LENGTH_SHORT).show();
                    break;
                }
                if(_number.equals("")){
                    Toast.makeText(getApplicationContext(), "Number is required",Toast.LENGTH_SHORT).show();
                    break;
                }
                if(_number.length()!=10){
                    Toast.makeText(getApplicationContext(), "Invalid Mobile Number",Toast.LENGTH_SHORT).show();
                    break;
                }
                if(_city.equals("")){
                    Toast.makeText(getApplicationContext(), "City name is required",Toast.LENGTH_SHORT).show();
                    break;
                }

                SharedPreferences.Editor editor = myfile.edit();
                editor.putString("name", _name);
                editor.putString("email", _email);
                editor.putString("number", _number);
                editor.putString("city", _city);
                editor.commit();
                Intent goto_login = new Intent(this, Login.class);
                startActivity(goto_login);

                break;
            }
            case R.id.button_already: {
                // do something for button 1 click
                Intent goto_login = new Intent(this, Login.class);
                startActivity(goto_login);
                break;
            }

        }

    }

    public final static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
