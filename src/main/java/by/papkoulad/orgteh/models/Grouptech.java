package by.papkoulad.orgteh.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Grouptech extends AbstractEntity{

    @Column(length = 50)
    String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grouptech", cascade=CascadeType.ALL)
    private List<NameTech> nameTech = new ArrayList<NameTech>();

    @Override
	public String toString() {
		return "Название=" + name;
	}
    
}
