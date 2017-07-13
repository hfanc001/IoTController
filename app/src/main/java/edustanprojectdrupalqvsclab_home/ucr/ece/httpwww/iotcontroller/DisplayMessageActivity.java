package edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class DisplayMessageActivity extends AppCompatActivity {

   //private ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String switch_name = intent.getStringExtra(MainActivity.SWITCH_NAME);
        String switch_location = intent.getStringExtra(MainActivity.SWITCH_LOCATION);

        //Capture the layout's TextView and set the string as its text
        TextView view_name = (TextView) findViewById(R.id.display_name);
        view_name.setText(switch_name);
        TextView view_location = (TextView) findViewById(R.id.display_location);
        view_location.setText(switch_location);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.display_status);
        toggle.setChecked(MainActivity.SWITCH_STATUS);

        MainActivity.SWITCH_STATUS = toggle.isChecked();
        /*toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MainActivity.SWITCH_STATUS = isChecked;
            }
        });
*/
    }

    public void onToggleClicked (View view) {
        ToggleButton toggle = (ToggleButton) findViewById(R.id.display_status);
        MainActivity.SWITCH_STATUS = toggle.isChecked();
    }
}
