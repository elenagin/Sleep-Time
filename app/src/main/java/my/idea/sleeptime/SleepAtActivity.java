package my.idea.sleeptime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class SleepAtActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_at);

        String time, am_pm;
        int hour, min;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                time = null;
                hour = 0;
                min = 0;
                am_pm = null;
            } else {
                time = extras.getString("time");
                hour = extras.getInt("hour");
                min = extras.getInt("min");
                am_pm = extras.getString("AM_PM");
            }
        } else {
            time = (String) savedInstanceState.getSerializable("time");
            hour = (int) savedInstanceState.getSerializable("hour");
            min = (int) savedInstanceState.getSerializable("min");
            am_pm = (String) savedInstanceState.getSerializable("AM_PM");
        }
        displayTime(time, hour, min, am_pm);
    }

    private void displayTime(String time, int hour, int min, String am_pm) {
        TextView setWake, setSleep;
        setWake = findViewById(R.id.timeToWake);
        setSleep = findViewById(R.id.timeToSleep);
        setWake.setText(time);
        /*hour -= 5;
        if (hour > 12)
            hour -= 12;
        if (hour < 0)
            hour += 12;
        if (min > 60) {
            min -= 60;
            hour += 1;
        } else if (min < 0) {
            min += 60;
            hour -= 1;
        }*/
        setSleep.setText(NumberFormat.getInstance().format(hour).concat(" ").concat(getString(R.string.twoDots)).concat(" ").concat(new DecimalFormat("00").format(min).concat(" ").concat(am_pm)));
    }
}