package com.example.dbmci;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class GetStartedActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner id_sp_countryCode;
    private Button id_btn_next;
    private ArrayAdapter arrayAdapter;
    private EditText id_et_mobileNo;
    private String[] countryCodes = {"+1 ","+91","+93","+94","+95","+96","+97","+98"};
    private static final String TAG = "GetStartedActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.app_Background));
            }
            id_sp_countryCode = (Spinner) findViewById(R.id.id_sp_countryCode);
            id_et_mobileNo = (EditText) findViewById(R.id.id_et_mobileNo);
            id_btn_next = (Button) findViewById(R.id.id_btn_next);
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countryCodes);
            id_sp_countryCode.setAdapter(arrayAdapter);
            id_btn_next.setOnClickListener(this);
        } catch (Exception ex) {
            Log.i(TAG, ex.getMessage());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_btn_next:
                if (validateUserInput()) {
                    try {
                        sendSms(id_et_mobileNo.getText().toString());
                    } catch (Exception ex) {
                        Log.i(TAG,"Send SMS EXCEPTION while Calling ....: "+ex.getMessage());
                    }
//                    Intent intent = new Intent(GetStartedActivity.this, VerificationActivity.class);
//                    startActivity(intent);

                }

        }
    }

    public void sendSms(String mobileNo) {
        try {
            int num = 0;
            while(num < 999) {
                Random random = new Random();
                num = random.nextInt(9999);
                Log.i(TAG,"NUM GENERATED : "+num);
            }
            //Getting intent and PendingIntent instance
            Intent smsIntent = new Intent(getApplicationContext(), VerificationActivity.class);
            PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, smsIntent, 0);
            //Get the SmsManager instance and call the sendTextMessage method to send message
            SmsManager sms = SmsManager.getDefault();

                sms.sendTextMessage(mobileNo, null, "OTP FOR DBMCI : " + num, pi, null);


        }catch (Exception ex){
            Log.i(TAG,"Send SMS EXCEPTION  while Executing....: "+ex.getMessage());
        }
    }

    public boolean validateUserInput() {
        boolean status = true;
        if (id_et_mobileNo.getText().toString().length() != 10) {
            status = false;
            id_et_mobileNo.setError("Mobile No must contain 10 Digits ! ");
        } else if (id_et_mobileNo.getText().toString().contains(" ")) {
            status = false;
            id_et_mobileNo.setError("Mobile Number should not Contain WhiteSpaces");
        }
        return status;
    }
}
