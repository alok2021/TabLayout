package registration.devalok.com.tablayoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout id_tabLayout;
    private TextView id_tview1, id_tview2, id_tview3, id_tview4, id_tview5;
    private static final String TAG = "MainActivity";
    private ImageView id_imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            id_tabLayout = (TabLayout) findViewById(R.id.id_tabLayout);
            id_tabLayout.addTab(id_tabLayout.newTab().setText("Company Info"));
            id_tabLayout.addTab(id_tabLayout.newTab().setText("Personal Info"));
            id_tabLayout.addTab(id_tabLayout.newTab().setText("College Info"));
            id_imgView = (ImageView) findViewById(R.id.id_imgView);
            id_tview1 = (TextView) findViewById(R.id.id_tview1);
            id_tview2 = (TextView) findViewById(R.id.id_tview2);
            id_tview3 = (TextView) findViewById(R.id.id_tview3);
            id_tview4 = (TextView) findViewById(R.id.id_tview4);
            id_tview5 = (TextView) findViewById(R.id.id_tview5);
            showDetails(0);
            id_tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            showDetails(tab.getPosition());
                            break;
                        case 1:
                            showDetails(tab.getPosition());
                            break;

                        case 2:
                            showDetails(tab.getPosition());
                            break;
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            showDetails(tab.getPosition());
                            break;
                        case 1:
                            showDetails(tab.getPosition());
                            break;

                        case 2:
                            showDetails(tab.getPosition());
                            break;
                    }
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            showDetails(tab.getPosition());
                            break;
                        case 1:
                            showDetails(tab.getPosition());
                            break;

                        case 2:
                            showDetails(tab.getPosition());
                            break;
                    }
                }
            });
        } catch (Exception ex) {
            Log.e(TAG, "Oncreate : " + ex.getMessage());
        }
    }

    public void showDetails(int tabPosition) {
        if (tabPosition == 0) {
            try {
id_imgView.setBackground(getResources().getDrawable(R.drawable.rippenapp));
                id_tview1.setText("Name : Alok Kumar");
                id_tview2.setText("Comapny Name : RipenApps");
                id_tview3.setText("Director : Mr. Ishan");
                id_tview4.setText("Team : Alok & Co");
                id_tview5.setText("Team Size : 4");
            } catch (Exception ex) {
                Log.e("Exception ", ex.getMessage());
            }
        } else if (tabPosition == 1) {
            try {
                id_imgView.setBackground(getResources().getDrawable(R.drawable.user));
                id_tview1.setText("UserName : devalok@123");
                id_tview2.setText("Father's Name  : Ramesh Kumar");
                id_tview3.setText("Mother's Name : Nilima Devi");
                id_tview4.setText("Address : Greater Noida , UP");
                id_tview5.setText("");
            } catch (Exception ex) {
                Log.e("Exception ", ex.getMessage());
            }
        } else if (tabPosition == 2) {
            try {
                id_imgView.setBackground(getResources().getDrawable(R.drawable.eng_colleges));
                id_tview1.setText("College Name : Iimt College Of Engineering , Greater Noida ");
                id_tview2.setText("Director's Name  : Sanjay Pachauri");
                id_tview3.setText("My Branch  : Information Technology(IT)");
                id_tview4.setText("Branch Strength : 42");
                id_tview5.setText("Departments : IT,CS,EC,CE,ME,Applied Science");
            } catch (Exception ex) {
                Log.e("Exception ", ex.getMessage());
            }
        }
    }
}
