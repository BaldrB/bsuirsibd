package by.papkoulad.orgteh.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Viewg {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idviewg;

    private String viewg;

    private Integer viewg_id;

    public String getViewg() {
        return viewg;
    }

    public void setViewg(String viewg) {
        this.viewg = viewg;
    }

    public Viewg() {
    }

    public Viewg(String viewg, Integer viewg_id) {
        this.viewg = viewg;
        this.viewg_id = viewg_id;
    }



    public Integer getViewg_id() {
        return viewg_id;
    }

    public void setViewg_id(Integer viweg_id) {
        this.viewg_id = viweg_id;
    }

    public Integer getIdviewg() {
        return idviewg;
    }

    public void setIdviewg(Integer idviewg) {
        this.idviewg = idviewg;
    }
}