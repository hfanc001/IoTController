package edustanprojectdrupalqvsclab_home.ucr.ece.httpwww.iotcontroller.Database;

/**
 *  Controller Class
 *  Attributes: Name, ID, Location, Status , Type
 * Created by cindy on 7/13/2017.
 */

public class Controller {

    private String name;
    private String location;
    private Boolean status;

    //Constructor
    public Controller() {}

    public Controller(String name, String location, Boolean status) {
        super();
        this.name = name;
        this.location = location;
        this.status = status;
    }

    //Setting
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    //Getter
    
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Controller [name=" + name + ", location=" + location + ", status=" + status + "]";
    }
}