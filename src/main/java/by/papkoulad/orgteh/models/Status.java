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
import lombok.Data;

@Entity
@Data
public class Status{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String statusname;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "status", cascade = CascadeType.ALL)
    private List<Technics> status;

    public String getStatusname() {
        return this.statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Technics> getStatus() {
        return this.status;
    }

    public void setStatus(List<Technics> status) {
        this.status = status;
    }

    public Status() {}

    public Status(String statusname) {
        this.statusname = statusname;
    }

    
}
