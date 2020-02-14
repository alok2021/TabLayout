package com.example.dbmci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner id_college_state, id_sp_collegeName, id_college_year, id_sp_courses;
    private String colleNameList[] = {"College Name", "IIMT", "NIET", "GL BAJAJ", "GALGOTIA"};
    private String collegeStateList[] = {"College State", "Bihar", "Jharkhand", "Up"};
    private String collegeYear[] = {"College Year", "2019", "2018", "2017", "2016"};
    private String courseList[] = {"NEET PG", "NEET MDS", "NEET SS", "MCI SCREENING EXAM", "Ayush"};
    private ArrayAdapter adapter, adapter1, adapter2, adapter3;
    private EditText id_et_name, id_et_emailId, id_et_mobileNo;
    private Button id_btn_next;
    private static final String TAG = "ProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.app_Background));
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }
        id_et_name = (EditText) findViewById(R.id.id_et_name);
        id_et_emailId = (EditText) findViewById(R.id.id_et_emailId);
        id_et_mobileNo = (EditText) findViewById(R.id.id_et_mobileNo);
        id_btn_next = (Button) findViewById(R.id.id_btn_next);
        id_college_state = (Spinner) findViewById(R.id.id_collegeState);
        id_sp_collegeName = (Spinner) findViewById(R.id.id_sp_collegeName);
        id_college_year = (Spinner) findViewById(R.id.id_collegeYear);
        id_sp_courses = (Spinner) findViewById(R.id.id_sp_courses);
        id_btn_next = (Button) findViewById(R.id.id_btn_next);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, collegeStateList);
        adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, colleNameList);
        adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, collegeYear);
        adapter3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, courseList);
        id_college_state.setAdapter(adapter);
        id_sp_collegeName.setAdapter(adapter1);
        id_college_year.setAdapter(adapter2);
        id_sp_courses.setAdapter(adapter3);
        id_btn_next.setOnClickListener(this);
    }

    private boolean verifyUserInput() {
        boolean status = true;
        if (id_et_name.getText().toString().isEmpty()) {
            status = false;
            id_et_name.setError("Name field cannot be Empty ! ");
        } else if (id_et_emailId.getText().toString().isEmpty()) {
            status = false;
            id_et_emailId.setError("Email ID field cannot be Empty ! ");
        } else if (id_et_mobileNo.getText().toString().isEmpty()) {
            status = false;
            id_et_mobileNo.setError("Mobile No. field cannot be Empty ! ");
        } else if (id_et_mobileNo.getText().toString().length() != 10) {
            status = false;
            id_et_mobileNo.setError("Invalid Mobile Number !");
        } else if (id_college_state.getSelectedItem().toString().equalsIgnoreCase("College State")) {
            status = false;
            showToastMessage("Select College State");
        } else if (id_sp_collegeName.getSelectedItem().toString().equalsIgnoreCase("College Name")) {
            status = false;
            showToastMessage("Select College Name");
        } else if (id_college_year.getSelectedItem().toString().equalsIgnoreCase("College Year")) {
            status = false;
            showToastMessage("Select College Year");
        }
        return status;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_btn_next:
                if (verifyUserInput()) {

                }
                break;
        }
    }

    private void showToastMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
