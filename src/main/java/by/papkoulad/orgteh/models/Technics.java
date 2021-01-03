package by.papkoulad.orgteh.models;

import java.util.List;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Technics extends AbstractEntity{

    @Column
    String serial;
    @Column
    Integer inventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nametech_id")
    NameTech nametech;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usertech_id")
    UserTech usertech;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    Location location;

}
