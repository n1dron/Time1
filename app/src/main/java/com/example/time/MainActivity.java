package com.example.time;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText dateTxt, timeTxt;

    ImageButton dateBtn, timeBtn;

    Button applyBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTxt = findViewById(R.id.date_txt);
        timeTxt = findViewById(R.id.time_txt);
        dateBtn = findViewById(R.id.date_btn);
        timeBtn = findViewById(R.id.time_btn);
        applyBtn = findViewById(R.id.apply_btn);

        // Обработчик нажатия на кнопку выбора даты
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Год, месяц и день, которые будут отображаться по умолчанию
                int selectedYear = 2023;
                int selectedMonth = 10;
                int selectedDay = 21;

                // Обработчик выбора даты
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        // Установка выбранной даты в текстовое поле
                        dateTxt.setText("" + year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, dateSetListener, selectedYear, selectedMonth, selectedDay);

                // Запуск диалогового окна
                datePickerDialog.show();
            }
        });

        // Обработчик нажатия на кнопку выбора времени
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Часы и минуты, которые будут отображаться по умолчанию + тип отображения часов
                boolean is24HView = true;
                int selectedHour = 10;
                int selectedMinute = 20;

                // Обработчик выбора времени
                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Установка выбранного времени в текстовое поле
                        timeTxt.setText(hourOfDay + ":" + minute);
                    }
                };

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, timeSetListener, selectedHour, selectedMinute, is24HView);

                // Запуск диалогового окна
                timePickerDialog.show();
            }
        });
        // Обработчик нажатия на кнопку
        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создание диалогогого окна
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Установка заголовка диалогового окно
                builder.setTitle("Подтверждение записи");

                // Установка текста диалагового окна
                builder.setMessage("Вы подтверждаете вашу запись?");

                // Установка кнопки с "позитивным вариантом ответа" и его действием
                builder.setPositiveButton("Подтвердить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Закрытие диалогового окна
                        dialogInterface.cancel();
                        // Выведение сообщения
                        Toast.makeText(MainActivity.this, "Ваша запись подтверждена", Toast.LENGTH_SHORT).show();
                    }
                });

                // Установка кнопки с отрицательным выбором и его действием
                builder.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Закрытие диалогового окна
                        dialogInterface.dismiss();
                    }
                });

                // Создание и отображение диалогового окна
                builder.create().show();
            }
        });

    }
}
