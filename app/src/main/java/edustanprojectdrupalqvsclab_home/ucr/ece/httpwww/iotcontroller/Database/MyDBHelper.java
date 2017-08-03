package edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by cindy on 7/13/2017.
 */
public class MyDBHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "controller.db";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create controller table
        String CREATE_CONTROLLER_TABLE =
                "CREATE TABLE controllers ( " +
                        "cid INTEGER PRIMARY KEY NOT NULL, " +
                        "cname STRING, " +
                        "clocation STRING, " +
                        "cstatus BOOLEAN NOT NULL, " +
                        "ctype STRING)";

        // create controller table
        db.execSQL(CREATE_CONTROLLER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older controllers table if existed
        db.execSQL("DROP TABLE IF EXISTS controllers");

        // create fresh controllers table
        this.onCreate(db);
    }
    //---------------------------------------------------------------------

    /**
     * CRUD operations (create "add", read "get", update, delete) controller + get all controllers + delete all controllers
     */

    // Controllers table name
    private static final String TABLE_CONTROLLERS = "controllers";

    // Controllers Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_STATUS = "status";
    private static final String KEY_TYPE = "type";

    private static final String[] COLUMNS = {KEY_ID,KEY_NAME,KEY_LOCATION};

    public void addController(Controller controller){
        Log.d("addController", controller.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, controller.getName()); // get name
        values.put(KEY_LOCATION, controller.getLocation()); // get location
        values.put(KEY_STATUS, controller.getStatus()); //get status
        values.put(KEY_TYPE, controller.getType()); //get type

        // 3. insert
        db.insert(TABLE_CONTROLLERS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public Controller getController(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_CONTROLLERS, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build controller object
        Controller controller = new Controller();
        controller.setId(Integer.parseInt(cursor.getString(0)));
        controller.setName(cursor.getString(1));
        controller.setLocation(cursor.getString(2));

        Log.d("getController("+id+")", controller.toString());

        // 5. return controller
        return controller;
    }

    // Get All Controllers
    public List<Controller> getAllControllers() {
        List<Controller> controllers = new LinkedList<Controller>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_CONTROLLERS;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build controller and add it to list
        Controller controller = null;
        if (cursor.moveToFirst()) {
            do {
                controller = new Controller();
                controller.setId(Integer.parseInt(cursor.getString(0)));
                controller.setName(cursor.getString(1));
                controller.setLocation(cursor.getString(2));

                // Add controller to controllers
                controllers.add(controller);
            } while (cursor.moveToNext());
        }

        Log.d("getAllControllers()", controllers.toString());

        // return controllers
        return controllers;
    }

    // Updating single controller
    public int updateController(Controller controller) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("name", controller.getName()); // get name
        values.put("location", controller.getLocation()); // get location

        // 3. updating row
        int i = db.update(TABLE_CONTROLLERS, //table
                values, // column/value
                KEY_ID+" = ?", // selections
                new String[] { String.valueOf(controller.getId()) }); //selection args

        // 4. close
        db.close();

        return i;

    }

    // Deleting single controller
    public void deleteController(Controller controller) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_CONTROLLERS,
                KEY_ID+" = ?",
                new String[] { String.valueOf(controller.getId()) });

        // 3. close
        db.close();

        Log.d("deleteController", controller.toString());

    }
}