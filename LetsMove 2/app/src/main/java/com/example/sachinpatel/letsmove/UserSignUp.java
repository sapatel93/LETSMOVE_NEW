package com.example.sachinpatel.letsmove;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UserSignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        //To set image icon on Action Bar Android Activity
        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setIcon(R.drawable.iconactionbar);

        menu.setTitle("   User Registration");

        final EditText firstname = (EditText) findViewById(R.id.editText_firstname);
        final EditText lastname = (EditText) findViewById(R.id.editText_lastname);
        final EditText email = (EditText) findViewById(R.id.editText_email);
        final EditText p1 = (EditText) findViewById(R.id.editText_password);
        final EditText p2 = (EditText) findViewById(R.id.editText_password2);
        final EditText mobile = (EditText) findViewById(R.id.editText_mobile);

        final Button btn_signup = (Button) findViewById(R.id.button_Signup);
        //  LoginManager.getInstance().logOut();

///////////////////////////////////////////////////////////////////sign_up_user/////////////////////////
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String fname = firstname.getText().toString();
                String lname = lastname.getText().toString();
                String eMail = email.getText().toString();
                String pass1 = p1.getText().toString();
                String pass2 = p2.getText().toString();
                String mobile_num = mobile.getText().toString();
                String user_type = "user";
                String name = fname + " " + lname;

                String EMAIL_REGEX =
                        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
                Boolean b = eMail.matches(EMAIL_REGEX);

                if(b == false) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(UserSignUp.this);
                    builder.setTitle("Invalid Email ! Please Insert correct Email");

                    // Set up the buttons
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
                else if(!(pass1.equals(pass2))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(UserSignUp.this);
                    builder.setTitle("Both password does not match ! Please Try Again");

                    // Set up the buttons
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                } else if(!(mobile_num.length() == 10)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(UserSignUp.this);
                    builder.setTitle("Invalid Mobile number ! Please Try Again");

                    // Set up the buttons
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
                    else if(fname.length()==0 || fname.equals("") || fname==null || fname.equals(null) || eMail.equals("") || pass1.equals("") || pass2.equals("") || mobile_num.equals("")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(UserSignUp.this);
                        builder.setTitle("Invalid Data ! Please Insert all details");

                        // Set up the buttons
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.show();

                    } else{
                    try {
                        String s = DB.check_email(eMail);
                        if (s.equals("1")) {
                            btn_signup.setClickable(false);
                            DB.user_signup(eMail, name, pass1, mobile_num, user_type);
                            finish();
                            startActivity(new Intent(UserSignUp.this, UserLogin.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            Toast.makeText(UserSignUp.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(UserSignUp.this);
                            builder.setTitle("Email Id already exist! Try another");

                            // Set up the buttons
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            builder.show();
                        }

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });
    }
}