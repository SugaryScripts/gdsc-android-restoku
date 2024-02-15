package com.example.profileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Iterator;

import static com.example.profileapp.Utils.getDrawable;


public class GettingStartedActivity extends BaseActivity {

    ArrayList<String> listImage = new ArrayList<>();
    ArrayList<String> listDescription = new ArrayList<>();

    ImageView iv_greeting;
    TextView tv_desc;
    Button btn_trigger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_getting_started);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initUI() {
        super.initUI();
        iv_greeting = findViewById(R.id.iv_greeting);
        tv_desc = findViewById(R.id.tv_desc);
        btn_trigger = findViewById(R.id.btn_trigger);

        try {
            setGreetings(listImage, listDescription);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    public void initData() {
        super.initData();
        listImage.add("gr_burger_1");
        listImage.add("gr_salad_2");

        listDescription.add("Hi, selamat datang pada aplikasi kami");
        listDescription.add("Selamat menikmati!");
    }

    private void setGreetings(ArrayList<String> listImage, ArrayList<String> listDescription) throws Exception {
        if(listImage.size() != listDescription.size()){
            throw new Exception("Number of images and descriptions doesn't match");
        } else{
            Iterator imageIterator = listImage.iterator();
            Iterator descIterator = listDescription.iterator();

            setImageAndDesc(imageIterator, descIterator);
        }
    }

    private void setImageAndDesc(final Iterator imageIterator, final Iterator descIterator) {
        Glide.with(getApplicationContext())
                .load(Utils.getDrawable(getApplicationContext(), imageIterator.next().toString()))
                .into(iv_greeting);
        tv_desc.setText(descIterator.next().toString());
        btn_trigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageIterator.hasNext()){
                    Glide.with(getApplicationContext())
                            .load(Utils.getDrawable(getApplicationContext(), imageIterator.next().toString()))
                            .into(iv_greeting);
                    tv_desc.setText(descIterator.next().toString());

                    if(!imageIterator.hasNext()){
                        btn_trigger.setText("Bring it On!");
                    }

                } else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
