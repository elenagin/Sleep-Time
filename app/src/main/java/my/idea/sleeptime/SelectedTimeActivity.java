package my.idea.sleeptime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Objects;

public class SelectedTimeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_time);

        String time;
        /*if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                time = null;
            } else {
                time = extras.getString("time");
            }
        } else {
            time = (String) savedInstanceState.getSerializable("time");
        }*/

//        displayTime();
    }

    /*private void displayTime(String time) {
        TextView setWake = findViewById(R.id.timeToSleep);
        String temp = getResources().getString(setWake);
        setWake.setText(temp.concat(time));
    }*/
}