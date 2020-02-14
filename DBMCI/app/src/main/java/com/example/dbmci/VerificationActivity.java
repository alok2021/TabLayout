package com.example.dbmci;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class VerificationActivity extends AppCompatActivity implements View.OnClickListener {
    Pinview pin;
    LinearLayout myLayout;
    TextView id_tView_resendOTP;
    private Button id_btn_verify;
    private static final String TAG = "VerificationActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        try {
             pin = (Pinview) findViewById(R.id.pinview);
            id_tView_resendOTP = (TextView) findViewById(R.id.id_tView_resendOTP);

             id_btn_verify = (Button) findViewById(R.id.id_btn_verify);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.app_Background));
            }
             pin.setPinViewEventListener(new Pinview.PinViewEventListener() {
                @Override
                public void onDataEntered(Pinview pinview, boolean fromUser) {
                    //Make api calls here or what not
                    Toast.makeText(VerificationActivity.this, pinview.getValue(), Toast.LENGTH_SHORT).show();
                }
            });
            id_tView_resendOTP.setOnClickListener(this);
            id_btn_verify.setOnClickListener(this);

        }catch (Exception ex){
            Log.i(TAG,ex.getMessage());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_btn_verify :
                if (verifyUserInput()){
                    id_tView_resendOTP.setEnabled(true);
                    Log.i(TAG,"Verification Initiated "+pin.getValue().length()+" "+pin.getValue()+" "+pin.getPinHeight());
                    Toast.makeText(VerificationActivity.this,"Verification Initiated",Toast.LENGTH_SHORT).show();
                }
                break;
            case  R.id.id_tView_resendOTP :
                if (verifyUserInput()){
                    Log.i(TAG,"Verification ReInitiated "+pin.getValue().length()+" "+pin.getValue()+" "+pin.getPinHeight());
                Toast.makeText(VerificationActivity.this,"Verification Resent",Toast.LENGTH_SHORT).show();

            }
        }
    }
    public boolean verifyUserInput(){
        boolean status = true;
         if(pin.getValue().length()!=4){
             status = false;
             Log.i(TAG,pin.getValue().length()+" "+pin.getValue()+" "+pin.getPinHeight());
           Toast.makeText(VerificationActivity.this,"OTP must contain 4 Digits",Toast.LENGTH_SHORT).show();
         }
        return status;
    }
}
