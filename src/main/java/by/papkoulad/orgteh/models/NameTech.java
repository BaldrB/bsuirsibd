package by.papkoulad.orgteh.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class NameTech{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String nametech;
    @Column
    private String charact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grouptech_id")
    private Grouptech grouptech;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "nametech", cascade = CascadeType.ALL)
    private List<Technics> technics;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNametech() {
        return this.nametech;
    }

    public void setNametech(String nametech) {
        this.nametech = nametech;
    }
    public String getCharact() {
        return this.charact;
    }

    public void setCharact(String charact) {
        this.charact = charact;
    }
    public Grouptech getGrouptech() {
        return this.grouptech;
    }

    public void setGrouptech(Grouptech grouptech) {
        this.grouptech = grouptech;
    }

    public List<Technics> getTechnics() {
        return this.technics;
    }

    public void setTechnics(List<Technics> technics) {
        this.technics = technics;
    }

    public NameTech(){
    }

    public NameTech(String nametech, String charact, Grouptech grouptechs){
        this.nametech = nametech;
        this.charact = charact;
        this.grouptech = grouptechs;
    }

    public String getGrouptechName() {
        return grouptech != null ? grouptech.getName() : "";
    }
    
}
