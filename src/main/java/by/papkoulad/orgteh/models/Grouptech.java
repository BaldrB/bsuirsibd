package by.papkoulad.orgteh.models;

import java.util.ArrayList;
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
public class Grouptech{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grouptech", cascade=CascadeType.ALL)
    private List<NameTech> nameTech = new ArrayList<NameTech>();

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<NameTech> getNameTech() {
        return this.nameTech;
    }

    public void setNameTech(List<NameTech> nameTech) {
        this.nameTech = nameTech;
    }


    public Grouptech() {
    }

    public Grouptech(String name) {
        this.name = name;
    }
    
}
