package my.idea.sleeptime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TimePicker;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sleepAt(View view) {
        Bundle extras = new Bundle();
        Intent sleepAtActivity = new Intent(this, SleepAtActivity.class);
        TimePicker wakeTimePicker;
        String AM_PM;
        int hour, minute;
        wakeTimePicker = findViewById(R.id.clock1);
        hour = wakeTimePicker.getCurrentHour();
        minute = wakeTimePicker.getCurrentMinute();
        if (hour <= 12)
            AM_PM = "AM";
        else
            AM_PM = "PM";
        if (hour != 12)
            hour -= 12;
        extras.putString("time", getTime(1));
        extras.putString("AM_PM", AM_PM);
        extras.putInt("hour", hour);
        extras.putInt("min", minute);
        sleepAtActivity.putExtras(extras);
        startActivity(sleepAtActivity);
    }

    public void selectedTime(View view) {
        Intent selectedTimeActivity = new Intent(this, SelectedTimeActivity.class);
        selectedTimeActivity.putExtra("time", getTime(2));
        startActivity(selectedTimeActivity);
    }

    private String getTime(int view) {
        TimePicker wakeTimePicker;
        int hour, minute;
        if (view == 1)
            wakeTimePicker = findViewById(R.id.clock1);
        else
            wakeTimePicker = findViewById(R.id.clock2);
        hour = wakeTimePicker.getCurrentHour();
        minute = wakeTimePicker.getCurrentMinute();
        switch (hour) {
            case 0:
                return NumberFormat.getInstance().format(12).concat(" ").concat(getString(R.string.twoDots)).concat(" ").concat(new DecimalFormat("00").format(minute)).concat(" AM");
            case 12:
                return NumberFormat.getInstance().format(12).concat(" ").concat(getString(R.string.twoDots)).concat(" ").concat(new DecimalFormat("00").format(minute)).concat(" PM");
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                return NumberFormat.getInstance().format(hour - 12).concat(" ").concat(getString(R.string.twoDots)).concat(" ").concat(new DecimalFormat("00").format(minute)).concat(" PM");
            default:
                return NumberFormat.getInstance().format(hour).concat(" ").concat(getString(R.string.twoDots)).concat(" ").concat(new DecimalFormat("00").format(minute)).concat(" AM");
        }
        /*if ((hour < 12)&&(hour>0))
            return NumberFormat.getInstance().format(hour).concat(" ").concat(getString(R.string.twoDots)).concat(" ").concat(new DecimalFormat("00").format(minute)).concat(" AM");
        else if (hour > 12)
            return NumberFormat.getInstance().format(hour - 12).concat(" ").concat(getString(R.string.twoDots)).concat(" ").concat(new DecimalFormat("00").format(minute)).concat(" PM");
        else if (hour == 2)
            return NumberFormat.getInstance().format(hour).concat(" ").concat(getString(R.string.twoDots)).concat(" ").concat(new DecimalFormat("00").format(minute)).concat(" PM");
    */
    }
}