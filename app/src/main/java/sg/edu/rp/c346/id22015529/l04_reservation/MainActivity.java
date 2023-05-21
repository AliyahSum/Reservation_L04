package sg.edu.rp.c346.id22015529.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name ;
    EditText numberMobile ;
    EditText paxNum ;
    DatePicker bookDate ;
    TimePicker bookTime ;
    RadioGroup rgArea ;
    Button btnReserve ;
    Button btnReset ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name.findViewById(R.id.name) ;
        numberMobile.findViewById(R.id.mobile) ;
        paxNum.findViewById(R.id.pax) ;
        bookDate.findViewById(R.id.datePicker) ;
        bookTime.findViewById(R.id.timePicker) ;
        rgArea.findViewById(R.id.selectArea) ;
        btnReserve.findViewById(R.id.reserve) ;
        btnReset.findViewById(R.id.reset) ;

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookDate.updateDate(2023, 6, 1) ;
                bookTime.setHour(19) ;
                bookTime.setMinute(30) ;

                name.setText(null) ;
                numberMobile.setText(null) ;
                paxNum.setText(null) ;
            }
        });

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = "" ;
                String date = "" ;
                String time = "" ;
                String areaChosen = "" ;

                if (name.getText().toString() != "0" && paxNum.getText().toString() != "0") {
                    info = "Name: " + name.getText() + "\nMobile Number: " + numberMobile.getText() + "\nPax: " + paxNum.getText() ;
                    date = "\nDate: " + bookDate.getYear() + "/" + bookDate.getMonth() + "/" + bookDate.getDayOfMonth() ;
                    time = "\nTime: " +  bookTime.getHour() + ":" + bookTime.getMinute() ;
                    if (rgArea.getCheckedRadioButtonId() == R.id.smokeArea) {
                        areaChosen += "Smoking Area selected." ;
                    }
                    else {
                        areaChosen += "Non-Smoking Area selected." ;
                    }
                }

                Toast.makeText(MainActivity.this, info + date + time + "\n" + areaChosen, Toast.LENGTH_SHORT).show() ;
            }
        });
    }
}