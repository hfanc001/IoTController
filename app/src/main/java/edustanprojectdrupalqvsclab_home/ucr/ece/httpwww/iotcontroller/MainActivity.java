package edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.Database.MyDBHelper;

public class MainActivity extends AppCompatActivity {
    //input controller info
    public static final String SWITCH_NAME = "edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.NAME";
    public static final String SWITCH_LOCATION = "edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.LOCATION";
    public static boolean SWITCH_STATUS;

    public static MyDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO 2
        helper = new MyDBHelper(this);
       // SQLiteDatabase db = helper.getWritableDatabase();
    }

    /** Called when the user taps the send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, AddNewControllerActivity.class);
        startActivity(intent);
    }
}

