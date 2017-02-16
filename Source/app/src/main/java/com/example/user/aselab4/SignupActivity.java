package com.example.user.aselab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void validateForm(View v)
    {
        EditText usernameCtrl = (EditText)findViewById(R.id.text_Username);
        EditText emailCtrl = (EditText) findViewById(R.id.text_Email);
        EditText passwordCtrl = (EditText) findViewById(R.id.text_Password);
        EditText confirmpasswordCtrl = (EditText) findViewById(R.id.text_ConfirmPassword);
        TextView errorText = (TextView)findViewById(R.id.lbl_Error);
        String userName = usernameCtrl.getText().toString();
        String email = emailCtrl.getText().toString();
        String password = passwordCtrl.getText().toString();
        String confirmPassword = confirmpasswordCtrl.getText().toString();

        boolean validationFlag = false;
        //Verify if the fields are not empty.
        if(!userName.isEmpty() && !password.isEmpty() && !email.isEmpty() && !confirmPassword.isEmpty()) {
            if(password.equals(confirmPassword)) {
                validationFlag = true;

            }
            else
            {
                errorText.setVisibility(View.VISIBLE);
                errorText.setText("Both passwords need to be same");
            }
        }
        if(!validationFlag)
        {
            errorText.setVisibility(View.VISIBLE);
        }
        else
        {
            //This code redirects the from login page to the home page.
            Intent redirect = new Intent(this, HomeActivity.class);
            startActivity(redirect);
        }

    }
}
