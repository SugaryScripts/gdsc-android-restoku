package com.example.profileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.profileapp.Model.Menu;

import java.util.ArrayList;

public class DetailActivity extends BaseActivity {

    ListView listCart;
    Button btnConfirm;

    ArrayList<Menu> menuList = new ArrayList<>();
    ArrayList<String> titleMenu = new ArrayList<>();
    Menu currentMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_detail);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initData() {
        super.initData();

        menuList = (ArrayList<Menu>) getIntent().getSerializableExtra("menuList");
        currentMenu = (Menu) getIntent().getSerializableExtra("currentMenu");
        titleMenu.add(currentMenu.getTitle());
    }

    @Override
    public void initUI() {
        super.initUI();

        listCart = findViewById(R.id.list_cart);
        btnConfirm = findViewById(R.id.btn_confirm);

        ArrayAdapter adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, titleMenu);
        listCart.setAdapter(adapter);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_other, new OtherListFragment(menuList));
        ft.commit();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
