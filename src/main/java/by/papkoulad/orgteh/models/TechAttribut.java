package by.papkoulad.orgteh.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TechAttribut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer techId;

    private String techName;
    private String techInventory;
    private String techCategory;
    private String techData;
    private String techCharact;
    private String techLocation;

    public TechAttribut() {
    }

    public Integer getTechId() {
        return techId;
    }

    public void setTechId(Integer techId) {
        this.techId = techId;
    }

    public String getTechLocation() {
        return techLocation;
    }

    public void setTechLocation(String techLocation) {
        this.techLocation = techLocation;
    }

    public String getTechCharact() {
        return techCharact;
    }

    public void setTechCharact(String techCharact) {
        this.techCharact = techCharact;
    }

    public String getTechData() {
        return techData;
    }

    public void setTechData(String techData) {
        this.techData = techData;
    }

    public String getTechCategory() {
        return techCategory;
    }

    public void setTechCategory(String techCategory) {
        this.techCategory = techCategory;
    }

    public String getTechInventory() {
        return techInventory;
    }

    public void setTechInventory(String techInventory) {
        this.techInventory = techInventory;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public TechAttribut(Integer techId, String techName, String techInventory, String techCategory, String techData,
            String techCharact, String techLocation) {
        this.techId = techId;
        this.techName = techName;
        this.techInventory = techInventory;
        this.techCategory = techCategory;
        this.techData = techData;
        this.techCharact = techCharact;
        this.techLocation = techLocation;
    }

    public TechAttribut(String techName, String techInventory, String techCategory, String techData, String techCharact,
            String techLocation) {
        this.techName = techName;
        this.techInventory = techInventory;
        this.techCategory = techCategory;
        this.techData = techData;
        this.techCharact = techCharact;
        this.techLocation = techLocation;
    }


    
    
    
}
