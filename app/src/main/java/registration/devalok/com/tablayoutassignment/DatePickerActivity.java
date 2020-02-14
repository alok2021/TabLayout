package registration.devalok.com.tablayoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {
    private DatePicker id_datePicker;
    private Calendar calendar;
    private int dd, mm, yy;
    private TextView id_tv_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        id_datePicker = (DatePicker) findViewById(R.id.id_datePicker);
        id_tv_date = (TextView) findViewById(R.id.id_tv_date);
        calendar = Calendar.getInstance();
        dd = calendar.get(Calendar.DAY_OF_MONTH);
        mm = calendar.get(Calendar.MONTH);
        yy = calendar.get(Calendar.YEAR);
        id_tv_date.setText(getCurrentDate());
        id_datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dd = dayOfMonth;
                mm = monthOfYear+1;
                yy = year;
                id_tv_date.setText(getCurrentDate());
                Toast.makeText(getApplicationContext(),"Date "+getCurrentDate(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getCurrentDate(){
        String cDate = dd+"/"+mm+"/"+yy;
        return  cDate;
    }
}
