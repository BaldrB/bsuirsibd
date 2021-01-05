package by.papkoulad.orgteh.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Technics{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String serial;

    @Column
    private Integer inventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nametech_id")
    private NameTech nametech;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usertech_id")
    private UserTech usertech;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    public Technics() {
    }

    public Technics(String serial, Integer inventory, NameTech nametech, Status status, Location location, UserTech usertech) {
        this.serial = serial;
        this.inventory = inventory;
        this.nametech = nametech;
        this.location = location;
        this.status = status;
        this.usertech = usertech;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
    public Integer getInventory() {
        return this.inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
    public NameTech getNametech() {
        return this.nametech;
    }

    public void setNametech(NameTech nametech) {
        this.nametech = nametech;
    }
    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserTech getUsertech() {
        return this.usertech;
    }

    public void setUsertech(UserTech usertech) {
        this.usertech = usertech;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTechnicsNametech() {
        return nametech != null ? (nametech.getNametech() + nametech.getCharact()) : "";
    }

    public String getTechnicsStatus() {
        return status != null ? status.getStatusname() : "";
    }

    public String getTechnicsLocation() {
        return location != null ? location.getLocationname() : "";
    }

    public String getTechnicsUserTech() {
        return usertech != null ? usertech.getFio() : "";
    }

}
