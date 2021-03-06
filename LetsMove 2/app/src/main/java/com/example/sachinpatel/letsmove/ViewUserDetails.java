package com.example.sachinpatel.letsmove;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import android.os.Handler;

public class ViewUserDetails extends BaseActivity {

    public static TextView user_details_Name, user_details_Email, user_details_Password, user_details_Mobile;
    public Button edit_user_button, btn_my_posts;
    public static ProgressBar progressBar;
    static String email_session;
    Handler handler = new Handler();
    public static int counter = 0;
    LinearLayout linearLayoutProfile;
    String userRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_details);

        final SharedPreferences preferences_email = getSharedPreferences("login_data", MODE_PRIVATE);
        email_session = preferences_email.getString("login_email", null);
        String user_id = preferences_email.getString("user_id", null);
        userRole = preferences_email.getString("role",null);

        user_details_Name = (TextView) findViewById(R.id.user_details_name);
        user_details_Email = (TextView) findViewById(R.id.user_details_email);
        user_details_Password = (TextView) findViewById(R.id.user_details_password);
        user_details_Mobile = (TextView) findViewById(R.id.user_details_mobile);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_getUserDetail);
        linearLayoutProfile = (LinearLayout)findViewById(R.id.linear_layout_view_user_details);

        //To start the background process for getting user details


        GetUserDetailsBackground getUserDetailsBackground = new GetUserDetailsBackground();
        getUserDetailsBackground.execute();

        edit_user_button = (Button) findViewById(R.id.btn_edit_user_details);
        btn_my_posts = (Button) findViewById(R.id.btn_my_posts);


        ////////////button to view all the posts by the user itself
        btn_my_posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userRole.equals("1")){
                    Intent intent = new Intent(ViewUserDetails.this, MyPostsActivity.class);
                    intent.putExtra("posts", "my_posts");
                    startActivity(intent);
                }
                else {
                    startActivity(new Intent(ViewUserDetails.this, View_my_ratings.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

            }
        });

        edit_user_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewUserDetails.this, edit_user_details.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
    }


    class GetUserDetailsBackground extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... params) {
            DB.get_user_details(ViewUserDetails.email_session);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            ViewUserDetails.user_details_Name.setText(DB.get_user_name);
            ViewUserDetails.user_details_Email.setText(DB.get_user_email);
            //ViewUserDetails.user_details_Password.setText(DB.get_user_password);
            ViewUserDetails.user_details_Mobile.setText(DB.get_user_mobile);
            ViewUserDetails.progressBar.setVisibility(View.INVISIBLE);
            linearLayoutProfile.setVisibility(View.VISIBLE);
            if(userRole.equals("1")){
                btn_my_posts.setVisibility(View.VISIBLE);
            }
            else {
                btn_my_posts.setText("Ratings");
                Drawable Ratelogo = getResources().getDrawable(R.drawable.rateicon);
                btn_my_posts.setCompoundDrawablesWithIntrinsicBounds(Ratelogo, null, null, null);
                btn_my_posts.setPadding(500,0,450,0);
                btn_my_posts.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}



