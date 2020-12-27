package by.papkoulad.orgteh.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
public class NameTech {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idnametech;

    private String name;
    private String charact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Set<Category> category;

    public Integer getIdnametech() {
        return idnametech;
    }

    public void setIdnametech(Integer idnametech) {
        this.idnametech = idnametech;
    }

    public String getName() {
        return name;
    }

    public String getCharact() {
        return charact;
    }

    public void setCharact(String charact) {
        this.charact = charact;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Set<Category> getCategory() {
        return this.category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }


}
