package edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

import edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.Database.Controller;

public class DisplayControllerActivity extends AppCompatActivity {

   //private ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_controller);

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String switch_name = intent.getStringExtra(AddNewControllerActivity.SWITCH_NAME);
        String switch_location = intent.getStringExtra(AddNewControllerActivity.SWITCH_LOCATION);

        //Capture the layout's TextView and set the string as its text
        TextView view_name = (TextView) findViewById(R.id.display_name);
        view_name.setText(switch_name);
        TextView view_location = (TextView) findViewById(R.id.display_location);
        view_location.setText(switch_location);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.display_status);
        toggle.setChecked(AddNewControllerActivity.SWITCH_STATUS);

        //List<Controller> list = MainActivity.helper.getAllControllers();
       // Controller test = MainActivity.helper.getController(0);
        int row = AddNewControllerActivity.SWITCH_ROW;
        AddNewControllerActivity.SWITCH_STATUS = toggle.isChecked();

        //Set controller info from Database
        Controller con = MainActivity.helper.getController(row);
        TextView con_name = (TextView) findViewById(R.id.controller_name);
        TextView con_location = (TextView) findViewById(R.id.controller_location);
        ToggleButton con_status = (ToggleButton) findViewById(R.id.controller_status);
        con_name.setText(con.getName());
        con_location.setText(con.getLocation());
        con_status.setChecked(con.getStatus());

    }

    public void onToggleClicked (View view) {
        ToggleButton toggle = (ToggleButton) findViewById(R.id.display_status);
        AddNewControllerActivity.SWITCH_STATUS = toggle.isChecked();
    }
}
