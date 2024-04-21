package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.myapplication.databinding.AlertNameBinding;
import com.example.myapplication.databinding.InputSrokBinding;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class CustomAlert {

    static OnButtonAlertListener onButtonAlertListener;
    public CustomAlert() {
    }
    public static void alertDialogDate(Context context, LayoutInflater layoutInflater){
        AlertDialog dialog;
        final String[] srok = new String[1];
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        InputSrokBinding binding1 = InputSrokBinding.inflate(layoutInflater, null, false);
        View view = binding1.getRoot();
        builder1.setCancelable(false);
        dialog = builder1.setView(view).show();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        binding1.datePickerActions.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                srok[0] = String.format(Locale.getDefault(), "%02d.%02d.%02d", dayOfMonth, month+1, year%100);
            }
        });

        binding1.strelka.setOnClickListener(v -> {
            alertDialogName(context, layoutInflater, srok[0]);
            dialog.cancel();
        });
        binding1.strelkaBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }
    public static void alertDialogName(Context context, LayoutInflater layoutInflater, String srok){
        AlertDialog dialog;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        AlertNameBinding binding = AlertNameBinding.inflate(layoutInflater, null, false);
        View view = binding.getRoot();
        builder1.setCancelable(false);
        dialog = builder1.setView(view).show();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        binding.strelka.setOnClickListener(v ->{
            if(binding.et.getText().toString().isEmpty()||binding.et.getText().toString()==null){
                Toast.makeText(context, "Введите название продукта", Toast.LENGTH_SHORT).show();
            }
            else {
                Product product = new Product(binding.et.getText().toString(), srok);//добавить продукт в бд, обновить recycler
                dialog.cancel();
            }

        } );
        binding.strelkaBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }

    public static void alertDialogCreateRoom(Context context, LayoutInflater layoutInflater){
        AlertDialog dialog;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        AlertNameBinding binding = AlertNameBinding.inflate(layoutInflater, null, false);
        View view = binding.getRoot();
        builder1.setCancelable(true);
        binding.tv.setText("Введите название комнаты");
        dialog = builder1.setView(view).show();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        binding.strelka.setOnClickListener(v -> {
            String nameRoom = binding.et.getText().toString();
            if(nameRoom.isEmpty()||nameRoom==null){
                Toast.makeText(context, "Введите название комнаты", Toast.LENGTH_SHORT).show();
            }
            else {
                //здесь создание комнаты с названием nameRoom
                onButtonAlertListener.closeAlert();//закрывает фрагмент
                dialog.cancel();
            }

        });
        binding.strelkaBack.setVisibility(View.GONE);
    }
    public static void alertDialogEnterRoom(Context context, LayoutInflater layoutInflater){
        AlertDialog dialog;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        AlertNameBinding binding = AlertNameBinding.inflate(layoutInflater, null, false);
        View view = binding.getRoot();
        builder1.setCancelable(true);
        binding.tv.setText("Введите id комнаты");
        dialog = builder1.setView(view).show();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        binding.strelka.setOnClickListener(v -> {
            String nameRoom = binding.et.getText().toString();
            if(nameRoom.isEmpty()||nameRoom==null){
                Toast.makeText(context, "Введите id комнаты", Toast.LENGTH_SHORT).show();
            }
            else {
                //здесь добавление юзера в  комнату с айди nameRoom и добавление в нее юзера
                //если успешно-
                String roomId= binding.et.getText().toString();

                onButtonAlertListener.closeAlert();//закрывает фрагмент
                dialog.cancel();
            }

        });
        binding.strelkaBack.setVisibility(View.GONE);
    }
    public void setOnCloseFragment(OnButtonAlertListener onButtonAlertListener){
        this.onButtonAlertListener=onButtonAlertListener;
    }

}
