package by.papkoulad.orgteh.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserTech {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idusertech;

    private String fio;
    private Integer number;

    public Integer getIdusertech() {
        return this.idusertech;
    }

    public void setIdusertech(Integer idusertech) {
        this.idusertech = idusertech;
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
    
}
