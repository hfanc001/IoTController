package edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.Database;

/**
 *  Controller Class
 *  Attributes: Name, ID, Location, Status , Type
 * Created by cindy on 7/13/2017.
 */

public class Controller {

    private int id;
    private String name;
    private String location;
    private Boolean status;
    private String type;

    //Constructor
    public Controller() {}

    public Controller(String name, String location, Boolean status, String type) {
        super();
        this.name = name;
        this.location = location;
        this.status = status;
        this.type = type;
    }

    //Setting
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    //Getter
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", location=" + location + ", status=" + status +
                ", type=" + type + "]";
    }
}