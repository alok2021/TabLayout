package registration.devalok.com.tablayoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class TimePickerActivity extends AppCompatActivity implements View.OnClickListener {
    private TimePicker id_timePicker;
    private Calendar calendar;
    private int hh, mm;
    private TextView id_currentTime;
    private Button id_btn_getCTime;
    private String AMPMValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        calendar = Calendar.getInstance();
        hh = calendar.get(Calendar.HOUR_OF_DAY);
        mm = calendar.get(Calendar.MINUTE);
        id_timePicker = (TimePicker) findViewById(R.id.id_timePicker);
        id_currentTime = (TextView) findViewById(R.id.id_currentTime);
        id_btn_getCTime = (Button) findViewById(R.id.id_btn_getCTime);
        id_btn_getCTime.setOnClickListener(this);
        id_timePicker.setIs24HourView(true);
        id_currentTime.setText(getCurrentTime());
        final TimePicker.OnTimeChangedListener listener = new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                id_currentTime.setText(hourOfDay + " : " + minute);
                hh = hourOfDay;
                mm = minute;
            }
        };


        id_timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                AMPMValue = "AM";
                if (i > 11) {
                    AMPMValue = "PM";
                    i = i - 12;
                }
                hh = i;
                mm =i1;
                // Display the 12 hour format time in TextView
                id_currentTime.setText("" + i + ":" + i1 + " " + AMPMValue);
                Toast.makeText(getApplicationContext(),"Time "+getCurrentTime(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getCurrentTime() {
       // String currentTime = "Current Time: " + id_timePicker.getCurrentHour() + ":" + id_timePicker.getCurrentMinute();
         String currentTime = "Current Time: " + hh + ":" + mm+" "+AMPMValue;
        return currentTime;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_btn_getCTime:
                Toast.makeText(getApplicationContext(), "Current Time : " + hh + " : " + mm + " " + AMPMValue, Toast.LENGTH_SHORT).show();
        break;
        }
    }
}
