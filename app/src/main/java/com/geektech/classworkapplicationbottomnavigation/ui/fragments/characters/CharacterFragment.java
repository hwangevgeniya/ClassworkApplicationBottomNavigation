package com.geektech.classworkapplicationbottomnavigation.ui.fragments.characters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.classworkapplicationbottomnavigation.R;
import com.geektech.classworkapplicationbottomnavigation.data.CharacterClient;
import com.geektech.classworkapplicationbottomnavigation.databinding.CharacterItemBinding;
import com.geektech.classworkapplicationbottomnavigation.databinding.FragmentCharacterBinding;


public class CharacterFragment extends Fragment implements CharacterAdapter.onItemClick {

    private @NonNull FragmentCharacterBinding binding;
    private CharacterAdapter adapter = new CharacterAdapter();
    private CharacterClient client = new CharacterClient();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentCharacterBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecycler();

    }

    private void initRecycler() {
        adapter.setList(client.getList());
        adapter.setListener(this);
        binding.characterRv.setAdapter(adapter);
    }

    public void onLongClick(int position){
        //adapter.removeItem(position);

        AlertDialog.Builder alert = new AlertDialog.Builder(requireActivity());
        alert.setTitle("Attention!!!")
                .setMessage("Delete Item?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.removeItem(position);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }
}