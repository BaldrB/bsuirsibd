package by.papkoulad.orgteh.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Technics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idtechnics;

    private String serial;
    private Integer inventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nametech_id")
    private Set<NameTech> nametech;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Set<Status> status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usertech_id")
    private Set<UserTech> usertech;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Set<Location> location;

    public String getSerial() {
        return serial;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getIdtechnics() {
        return idtechnics;
    }

    public void setIdtechnics(Integer idtechnics) {
        this.idtechnics = idtechnics;
    }
    public Set<Location> getLocation() {
        return this.location;
    }

    public void setLocation(Set<Location> location) {
        this.location = location;
    }
    public Set<UserTech> getUsertech() {
        return this.usertech;
    }

    public void setUsertech(Set<UserTech> usertech) {
        this.usertech = usertech;
    }
    public Set<Status> getStatus() {
        return this.status;
    }

    public void setStatus(Set<Status> status) {
        this.status = status;
    }
    public Set<NameTech> getNametech() {
        return this.nametech;
    }

    public void setNametech(Set<NameTech> nametech) {
        this.nametech = nametech;
    }
}
