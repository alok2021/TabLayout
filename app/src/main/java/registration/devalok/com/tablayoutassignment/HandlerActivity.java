package registration.devalok.com.tablayoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class HandlerActivity extends AppCompatActivity {
TextView id_textView;
int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
//
        id_textView = (TextView) findViewById(R.id.id_textView);
        id_textView.setText("");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                id_textView.append(++i+" Hello Using Post Delayed"+"\n");
            }
        },3000);

        new Handler().postAtTime(new Runnable() {
            @Override
            public void run() {
                id_textView.append(++i+" Hello Using PostAtTime\n");
            }
        },3000);

        new Handler().removeCallbacks(new Runnable() {
            @Override
            public void run() {
                id_textView.append(++i+" Hi Welcome Using RemoveCallbacks");
            }
        });


    }
}
