package by.papkoulad.orgteh.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subspecies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idsubs;

    private String valuesubs;
    private Integer viewid;

    public Integer getIdsubs() {
        return idsubs;
    }

    public Integer getViewid() {
        return viewid;
    }

    public void setViewid(Integer viewid) {
        this.viewid = viewid;
    }

    public String getValuesubs() {
        return valuesubs;
    }

    public void setValuesubs(String valuesubs) {
        this.valuesubs = valuesubs;
    }

    public void setIdsubs(Integer idsubs) {
        this.idsubs = idsubs;
    }



    public Subspecies() {
    }

    
    
}
