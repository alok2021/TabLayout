package registration.devalok.com.tablayoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button id_btn1, id_btn2, id_btn3,id_btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        id_btn1 = (Button) findViewById(R.id.id_btn1);
        id_btn2 = (Button) findViewById(R.id.id_btn2);
        id_btn3 = (Button) findViewById(R.id.id_btn3);
        id_btn4 = (Button) findViewById(R.id.id_btn4);
        id_btn1.setOnClickListener(this);
        id_btn2.setOnClickListener(this);
        id_btn3.setOnClickListener(this);
        id_btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_btn1:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.id_btn2:
                Intent intent1 = new Intent(getApplicationContext(), TimePickerActivity.class);
                startActivity(intent1);
                break;
            case R.id.id_btn3:
                Intent intent2 = new Intent(getApplicationContext(), DatePickerActivity.class);
                startActivity(intent2);
                break;

            case R.id.id_btn4:
                Intent intent3 = new Intent(getApplicationContext(), HandlerActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
