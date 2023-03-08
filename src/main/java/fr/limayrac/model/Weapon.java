package fr.limayrac.model;

import javax.persistence.*;

@Entity
@Table(name = "weapon")
public class Weapon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "type", length = 255)
	private String type;
	
	@Column(name = "damage_type", length = 255)
	private String damage_type;
	
	@Column(name = "magazine", length = 255)
	private int magazine;
	
	@Column(name = "attribut", length = 255)
	private String attribute[];

	@Column(name = "user", length = 255)
	private String user;
	
	public Weapon() {
		// TODO Auto-generated constructor stub
	}
	
	public Weapon(String name, String description, String type, String damage_type, int magazine, String user) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.damage_type = damage_type;
		this.magazine = magazine;
		this.attribute = new String[2];
		this.user = user;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getDamageType() {
		return this.damage_type;
	}
	
	public int getMagazine() {
		return this.magazine;
	}
	
	public String[] getAttribut() {
		return this.attribute;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setDamageType(String damage_type) {
		this.damage_type = damage_type;
	}
	
	public void setMagazine(int magazine) {
		this.magazine = magazine;
	}
	
	public void setAttribut(String attribut1, String attribut2) {
		this.attribute[0] = attribut1;
		this.attribute[1] = attribut2;
	}
	
	@Override
	public String toString() {
		//return "Name : " + this.name + " | Description : " + this.description + ", | Type : " + this.type + " | Damage Type : " + this.damage_type + ", | Magazine : " + this.magazine + ", | Attributs : " + this.attribute[0] + " / " + this.attribute[1];
		return "Name : " + this.name + " | Description : " + this.description + ", | Type : " + this.type;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getUser() {
		return this.user;
	}
}
