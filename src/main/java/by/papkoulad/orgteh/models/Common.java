package by.papkoulad.orgteh.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Common {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idcommon;

    private String namecommon;
    private Integer invercommon;
    private Integer subsid;
    private String Specificcommon;
    private String Commendscommon;
    private String datacommon;

    public String getNamecommon() {
        return namecommon;
    }

    public String getDatacommon() {
        return datacommon;
    }

    public void setDatacommon(String datacommon) {
        this.datacommon = datacommon;
    }

    public String getCommendscommon() {
        return Commendscommon;
    }

    public void setCommendscommon(String commendscommon) {
        this.Commendscommon = commendscommon;
    }

    public String getSpecificcommon() {
        return Specificcommon;
    }

    public void setSpecificcommon(String specificcommon) {
        this.Specificcommon = specificcommon;
    }

    public Integer getSubsid() {
        return subsid;
    }

    public void setSubsid(Integer subsid) {
        this.subsid = subsid;
    }

    public Integer getInvercommon() {
        return invercommon;
    }

    public void setInvercommon(Integer invercommon) {
        this.invercommon = invercommon;
    }

    public void setNamecommon(String namecommon) {
        this.namecommon = namecommon;
    }

    public Common() {
    }
}
