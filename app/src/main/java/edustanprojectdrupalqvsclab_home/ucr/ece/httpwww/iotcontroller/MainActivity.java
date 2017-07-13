package edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import static android.R.id.toggle;

public class MainActivity extends AppCompatActivity {
    public static final String SWITCH_NAME = "edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.NAME";
    public static final String SWITCH_LOCATION = "edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.LOCATION";
    public static boolean SWITCH_STATUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText get_name = (EditText) findViewById(R.id.input_name);
        EditText get_location = (EditText) findViewById(R.id.input_location);

        String name = get_name.getText().toString();
        String location = get_location.getText().toString();
        intent.putExtra(SWITCH_NAME, name);
        intent.putExtra(SWITCH_LOCATION, location);
        startActivity(intent);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.input_status);
        SWITCH_STATUS = toggle.isChecked();
    }
}

