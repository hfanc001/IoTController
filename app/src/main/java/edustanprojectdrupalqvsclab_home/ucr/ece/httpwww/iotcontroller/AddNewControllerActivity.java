package edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

import edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.Database.Controller;

//import edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.Database.Controller;

public class AddNewControllerActivity extends AppCompatActivity {
    public static final String SWITCH_NAME = "edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.NAME";
    public static final String SWITCH_LOCATION = "edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.LOCATION";
    public static boolean SWITCH_STATUS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_add_new_controller);
    }

    /**
     * Called when the user taps the send button
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayControllerActivity.class);
        EditText get_name = (EditText) findViewById(R.id.input_name);
        EditText get_location = (EditText) findViewById(R.id.input_location);

        String name = get_name.getText().toString();
        String location = get_location.getText().toString();
        intent.putExtra(SWITCH_NAME, name);
        intent.putExtra(SWITCH_LOCATION, location);
        startActivity(intent);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.input_status);
        SWITCH_STATUS = toggle.isChecked();

        ContentValues values = new ContentValues();
        values.put("cname", name);
        values.put("clocation", location);
        values.put("cstatus", SWITCH_STATUS);

        MainActivity.helper.addController(new Controller(name, location, SWITCH_STATUS, null));
    }
}

