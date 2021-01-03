package by.papkoulad.orgteh.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Location{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    private String locationname;

    public String getLocationname() {
        return this.locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "location", cascade = CascadeType.ALL)
    private List<Technics> location;

    public List<Technics> getLocation() {
        return this.location;
    }

    public void setLocation(List<Technics> location) {
        this.location = location;
    }

    public Location() {
    }

    public Location(String locationname) {
        this.locationname = locationname;
    }
    
}
