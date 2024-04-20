package com.example.myapplication;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentRoomBinding;

public class RoomFragment extends Fragment {

    private RoomViewModel mViewModel;
    FragmentRoomBinding binding;

    public static RoomFragment newInstance() {
        return new RoomFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= FragmentRoomBinding.inflate(inflater, null, false);

        View view = binding.getRoot();
        binding.createroom.setOnClickListener(v -> {
            CustomAlert.alertDialogCreateRoom(getContext(), getLayoutInflater());
        });
        binding.enterRoom.setOnClickListener(v -> {
            CustomAlert.alertDialogCreateRoom(getContext(), getLayoutInflater());
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RoomViewModel.class);
        // TODO: Use the ViewModel
    }

}