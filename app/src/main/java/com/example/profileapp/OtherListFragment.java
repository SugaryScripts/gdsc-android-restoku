package com.example.profileapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.profileapp.Adapter.OtherListMenuAdapter;
import com.example.profileapp.Model.Menu;

import java.util.ArrayList;

public class OtherListFragment extends Fragment {

    RecyclerView rvOtherMenu;
    ArrayList<Menu> menuArrayList;

    public OtherListFragment(ArrayList<Menu> menuArrayList) {
        this.menuArrayList = menuArrayList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_other_list, container, false);
        rvOtherMenu = view.findViewById(R.id.rvOtherMenu);

        OtherListMenuAdapter otherListMenuAdapter = new OtherListMenuAdapter(getContext(),menuArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvOtherMenu.setAdapter(otherListMenuAdapter);
        rvOtherMenu.setLayoutManager(linearLayoutManager);


        return view;
    }
}
