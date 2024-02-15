package com.example.profileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.profileapp.Adapter.ListMenuAdapter;
import com.example.profileapp.Dummy.MenuDummy;
import com.example.profileapp.Model.Menu;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    RecyclerView rvMenu;
    ArrayList<Menu> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initUI() {
        rvMenu = findViewById(R.id.rvMenu);

        ListMenuAdapter adapter = new ListMenuAdapter(this, menuList);
        rvMenu.setLayoutManager(new LinearLayoutManager(this));

        rvMenu.setAdapter(adapter);

        super.initUI();
    }

    @Override
    public void initData() {
        menuList = MenuDummy.generateDummyMenu();
        super.initData();
    }
}
