package com.geektech.classworkapplicationbottomnavigation.ui.fragments.characters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.classworkapplicationbottomnavigation.databinding.CharacterItemBinding;
import com.geektech.classworkapplicationbottomnavigation.models.Character;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder>{

    private ArrayList<Character> list = new ArrayList<>();
    private onItemClick click;

    public void setListener(onItemClick click){
        this.click = click;
    }

    public void setList(ArrayList<Character> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        this.list.remove(position);
        notifyDataSetChanged();
    }
    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(CharacterItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CharacterItemBinding binding;

        public ViewHolder(@NonNull CharacterItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Character character) {
            binding.characterIv.setImageResource(character.getImage());
            binding.characterTv.setText(character.getName());

            binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    click.onLongClick(getAdapterPosition());
                    return true;
                }
            });
        }
    }

    interface onItemClick{

        void onLongClick(int position);
    }
}
