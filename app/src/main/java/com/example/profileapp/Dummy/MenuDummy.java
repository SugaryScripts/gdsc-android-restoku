package com.example.profileapp.Dummy;

import com.example.profileapp.Model.Menu;

import java.util.ArrayList;

public class MenuDummy {
    public static ArrayList<Menu> generateDummyMenu(){
        ArrayList<Menu> list = new ArrayList<>();
        Menu menu  = new Menu();
        menu.setTitle("Sandwich");
        menu.setDesc("Dua potong roti dengan isian daging dan sayur segar");
        menu.setImage("sandwich");
        menu.setPrice("12.000");
        list.add(menu);

        Menu menu1  = new Menu();
        menu1.setTitle("Lasagna");
        menu1.setDesc("Makanan khas Italia dengan daging cincang pilihan");
        menu1.setImage("lasagna");
        menu1.setPrice("18.000");
        list.add(menu1);

        Menu menu2  = new Menu();
        menu2.setTitle("Chicken Alfredo Pasta");
        menu2.setDesc("Pasta dengan citarasa Italia yang menggoda selera");
        menu2.setImage("chickenalfredopasta");
        menu2.setPrice("23.000");
        list.add(menu2);

        Menu menu3  = new Menu();
        menu3.setTitle("Avocado Toast");
        menu3.setDesc("Roti panggang dengan balutan alpukat serta telur mata sapi");
        menu3.setImage("avocadotoast");
        menu3.setPrice("15.000");
        list.add(menu3);

        Menu menu4  = new Menu();
        menu4.setTitle("American Burger");
        menu4.setDesc("Burger favorit orang Amerika!");
        menu4.setImage("burger");
        menu4.setPrice("40.000");
        list.add(menu4);

        Menu menu5  = new Menu();
        menu5.setTitle("Chicken Noodle");
        menu5.setDesc("Mie Ayam khas dengan kuah rempah-rempah nikmat");
        menu5.setImage("noodle");
        menu5.setPrice("15.000");
        list.add(menu5);

        Menu menu6  = new Menu();
        menu6.setTitle("Fruity Pancake");
        menu6.setDesc("Pancake dengan berbagai macam toping buah-buahan");
        menu6.setImage("pancake");
        menu6.setPrice("25.000");
        list.add(menu6);

        return list;
    }
}
