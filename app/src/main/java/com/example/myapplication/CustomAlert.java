package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.example.myapplication.databinding.AlertNameBinding;
import com.example.myapplication.databinding.InputSrokBinding;

import java.util.Date;


public class CustomAlert {
    static OnButtonAlertListener onButtonAlertListener;
    public CustomAlert() {
    }
    public static void alertDialogDate(Context context, LayoutInflater layoutInflater){
        AlertDialog dialog;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        InputSrokBinding binding1 = InputSrokBinding.inflate(layoutInflater, null, false);
        View view = binding1.getRoot();
        builder1.setCancelable(false);
        dialog = builder1.setView(view).show();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        binding1.strelka.setOnClickListener(v -> {
            alertDialogName(context, layoutInflater);
            dialog.cancel();
        });
        binding1.strelkaBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }
    public static void alertDialogName(Context context, LayoutInflater layoutInflater){
        AlertDialog dialog;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        AlertNameBinding binding = AlertNameBinding.inflate(layoutInflater, null, false);
        View view = binding.getRoot();
        builder1.setCancelable(false);
        dialog = builder1.setView(view).show();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        binding.strelka.setOnClickListener(v -> dialog.cancel());
        binding.strelkaBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }
    public  void setOnButtonCloseListener(OnButtonAlertListener onButtonAlertListener){
        this.onButtonAlertListener=onButtonAlertListener;
    }

}
