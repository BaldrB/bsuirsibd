package by.papkoulad.orgteh.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idlocation;

    private String location;

    public Integer getIdlocation() {
        return this.idlocation;
    }

    public void setIdlocation(Integer idlocation) {
        this.idlocation = idlocation;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
}
