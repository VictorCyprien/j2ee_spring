package fr.limayrac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "armor")
public class Armor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name = "name", length = 255)
	private String name;
	
	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "armor_type", length = 255)
	private String armor_type;
	
	private String mods[];
	private int stats[];
	
	@Column(name = "user", length = 255)
	private String user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArmor_type() {
		return armor_type;
	}

	public void setArmor_type(String armor_type) {
		this.armor_type = armor_type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setMods(String[] mods) {
		this.mods = mods;
	}

	public void setStats(int[] stats) {
		this.stats = stats;
	}

	public Armor() {
		// TODO Auto-generated constructor stub
	}
	
	public Armor(String name, String description, String armor_type, int magazine, String user) {
		this.name = name;
		this.description = description;
		this.armor_type = armor_type;
		this.mods = new String[2];
		this.stats = new int[6];
		this.user = user;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getArmorType() {
		return this.armor_type;
	}
	
	public String[] getMods() {
		return this.mods;
	}
	
	public int[] getStats() {
		return this.stats;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setArmorType(String armor_type) {
		this.armor_type = armor_type;
	}
	
	public void setMods(String mod1, String mod2) {
		this.mods[0] = mod1;
		this.mods[1] = mod2;
	}
	
	public void setStats(int mobilite, int resistance, int recuperation, int discipline, int intelligence, int melee) {
		this.stats[0] = mobilite;
		this.stats[1] = resistance;
		this.stats[2] = recuperation;
		this.stats[3] = discipline;
		this.stats[4] = intelligence;
		this.stats[5] = melee;
	}
	
	@Override
	public String toString() {
		//return "Name : " + this.name + " | Description : " + this.description + " | Armor Type : " + this.armor_type + " | Mods : " + this.mods[0] + " / " + this.mods[1];
		return "Name : " + this.name + " | Description : " + this.description;
	}
	

}
