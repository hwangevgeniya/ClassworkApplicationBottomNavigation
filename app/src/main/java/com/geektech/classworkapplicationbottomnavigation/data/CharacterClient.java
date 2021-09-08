package com.geektech.classworkapplicationbottomnavigation.data;

import com.geektech.classworkapplicationbottomnavigation.R;
import com.geektech.classworkapplicationbottomnavigation.models.Character;

import java.util.ArrayList;

public class CharacterClient {
    private ArrayList<Character> list = new ArrayList<>();

    public ArrayList<Character> getList() {
        list.add(new Character("RS", R.drawable.ic_vampire2));
        list.add(new Character("RS", R.drawable.ic_vampire2));
        list.add(new Character("RS", R.drawable.ic_vampire2));
        list.add(new Character("RS", R.drawable.ic_vampire2));
        list.add(new Character("RS", R.drawable.ic_vampire2));
        list.add(new Character("RS", R.drawable.ic_vampire2));
        list.add(new Character("RS", R.drawable.ic_vampire2));
        list.add(new Character("RS", R.drawable.ic_vampire2));
        list.add(new Character("RS", R.drawable.ic_vampire2));
        list.add(new Character("SR", R.drawable.ic_vampire2));

        return list;
    }
}
