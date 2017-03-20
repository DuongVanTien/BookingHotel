package vn.framgia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by tienduongvan on 27/02/2017.
 *
 */
public class Hotel implements Serializable {

    private int id;
    private String name;
    private String address;
    private int starLevel;
    private String description;
    List<Room> rooms = new ArrayList<Room>();;

    public Hotel(){}

    public Hotel(int id) {
        this.id = id;
    }

    public Hotel(int id, String name, String address, int starLevel, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.starLevel = starLevel;
        this.description = description;
    }

    public Hotel(int id, String name, String address, int starLevel, String description, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.starLevel = starLevel;
        this.description = description;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(int starLevel) {
        this.starLevel = starLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
