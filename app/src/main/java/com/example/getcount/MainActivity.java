package com.example.getcount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private TextView month,day,year;
    private Button Click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Welcome :D", Toast.LENGTH_SHORT).show();
        month = findViewById(R.id.month);
        day = findViewById(R.id.day);
        year = findViewById(R.id.year);
        textView = findViewById(R.id.textView);
        Click = findViewById(R.id.Click);
        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);
        String[] splitDate = formattedDate.split(",");
        month.setText(splitDate[1]);
        day.setText(splitDate[0]);
        year.setText(splitDate[2]);
        Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    String CurrentDate = formatter.format(date);
                    String FinalDate = "06/02/2021";
                    Date date1;
                    Date date2;
                    SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");
                    date1 = dates.parse(CurrentDate);
                    date2 = dates.parse(FinalDate);
                    long difference = Math.abs(date1.getTime() - date2.getTime());
                    long differenceDates = difference / (24 * 60 * 60 * 1000);
                    String dayDifference = Long.toString(differenceDates);
                    long x = 0;
                    if(differenceDates == x){
                        textView.setText("      Hello, you reached the last date!");
                    }
                    else{
                        textView.setText("            Count of the days is " + dayDifference);
                    }
                }catch(Exception exception){
                    Toast.makeText(MainActivity.this, "Unable to find difference", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}