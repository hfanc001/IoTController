package edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.Database.Controller;
import edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.Database.MyDBHelper;

import static android.R.id.list;

public class MainActivity extends ListActivity {
    //input controller info
    public static final String SWITCH_NAME = "edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.NAME";
    public static final String SWITCH_LOCATION = "edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.LOCATION";
    public static boolean SWITCH_STATUS;

    public static MyDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new MyDBHelper(this);

        //TODO fix the list view style
        List<Controller> list = helper.getAllControllers();
        ArrayAdapter<Controller> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, list);
        setListAdapter(adapter);
    }

//    /**Called when the user taps any item on the list */
//    public void onClickList (AdapterView(Controller) adapterView, View view, int pos, long l) {
//        //TODO 1. use this method to create a new page after entering a new controller
//        //TODO 2. if able to create, implement the delete function
//        //TODO 3. if the above idea works, work on this function to click and display
//
//        Intent i = new Intent(this, ControllerDisplayActivity.class);
//        i.putExtra("item_id", manager.getItemIdAtIndex(pos));
//        startActivity(i);
//
//    }

    /** Called when the user taps the send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, AddNewControllerActivity.class);
        startActivity(intent);
    }
}

