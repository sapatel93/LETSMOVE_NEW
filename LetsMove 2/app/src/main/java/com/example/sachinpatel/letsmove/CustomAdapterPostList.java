package com.example.sachinpatel.letsmove;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapterPostList extends BaseAdapter {


    private Context context;
    UserBean userBean = new UserBean();
    static ArrayList arrayList = new java.util.ArrayList();
    private RelativeLayout my_posts_list;
    private ImageView imageProduct;
    private TextView textviewtitle;
    private TextView textviewservice;
    private TextView show_status;
    static String IMAGE_URL = "http://www.sachinapatel.com/LetsMove/images/";
    static ArrayList<Bitmap> bitmapArray = new ArrayList<Bitmap>();

    public CustomAdapterPostList(Context context, ArrayList arrayList) {
        // TODO Auto-generated constructor stub
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return arrayList.size();
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub


        System.out.println("Position = == " + position);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        System.out.println("Gone in CustomAdapter");


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.customlist, null);
        my_posts_list = (RelativeLayout) convertView.findViewById(R.id.activity_my_posts);
        imageProduct = (ImageView) convertView.findViewById(R.id.imageView_cutom_layout_post);
        textviewtitle = (TextView) convertView.findViewById(R.id.textView_post_title);
        textviewservice = (TextView) convertView.findViewById(R.id.textView_product_type);
        show_status = (TextView) convertView.findViewById(R.id.status_show);
        userBean = (UserBean) arrayList.get(position);
        RelativeLayout relativeLayout_my_post = (RelativeLayout)convertView.findViewById(R.id.relativelayout_my_post);

        System.out.println("Newwww   = = =   " + userBean.getPic_name() + "   " + userBean.getName());
        if (ListOfPost.posts_detail.equals("all_posts")) {
            try {
                imageProduct.setImageBitmap((Bitmap) ImageDownloaderTask.bitmapArrayList.get(position));

                //  imageProduct.setImageResource(R.drawable.product1);
                textviewtitle.setText(userBean.getName());
                textviewservice.setText(userBean.getType());

            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }

        } else {
            try {
                String post_user_id = userBean.getUser_id();

                //System.out.println("lllll == " + ListOfPost.user_id + " // " + post_user_id);
                System.out.println(userBean.getStatus());
                if(userBean.getStatus().equals("0")){
                    //show_status.setVisibility(View.VISIBLE);
                    relativeLayout_my_post.setBackgroundColor(Color.rgb(204, 255, 204));

                    show_status.setCompoundDrawablesWithIntrinsicBounds(R.drawable.submitbtn,0,0,0);
                }

                imageProduct.setImageBitmap((Bitmap) MyPostsActivity.bitmapArrayList.get(position));

                //  imageProduct.setImageResource(R.drawable.product1);
                textviewtitle.setText(userBean.getName());
                textviewservice.setText(userBean.getType());

            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }

        }
        return convertView;
    }
}