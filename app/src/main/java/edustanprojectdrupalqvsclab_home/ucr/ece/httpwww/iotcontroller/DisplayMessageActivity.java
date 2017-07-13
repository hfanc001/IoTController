package edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String switch_name = intent.getStringExtra(MainActivity.SWITCH_NAME);
        String switch_location = intent.getStringExtra(MainActivity.SWITCH_LOCATION);

        //Capture the layout's TextvView and set the string as its text
        TextView view_name = (TextView) findViewById(R.id.display_name);
        view_name.setText(switch_name);
        TextView view_location = (TextView) findViewById(R.id.display_location);
        view_location.setText(switch_location);
    }
}
