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
public class UserTech{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String fio;

    @Column
    private Integer number;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usertech", cascade = CascadeType.ALL)
    private List<Technics> usertech;
    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return this.fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    

    public List<Technics> getUsertech() {
        return this.usertech;
    }

    public void setUsertech(List<Technics> usertech) {
        this.usertech = usertech;
    }

    public UserTech() {
    }

    public UserTech(String fio, Integer number) {
        this.fio = fio;
        this.number = number;
    }
    
}
