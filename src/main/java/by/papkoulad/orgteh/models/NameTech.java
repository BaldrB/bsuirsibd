package by.papkoulad.orgteh.models;

import java.util.List;
import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@Data
public class NameTech extends AbstractEntity{

    @Column
    Integer idnametech;
    @Column
    String name;
    @Column
    String charact;

    @ManyToOne
    @JoinColumn(name = "grouptech_id")
    Grouptech grouptech;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "nametech", cascade = CascadeType.ALL)
    private List<Technics> technics;

}
