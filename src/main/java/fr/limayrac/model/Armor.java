package fr.limayrac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "armor")
public class Armor implements Serializable{

	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name = "name", length = 255)
	private String name;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "armorType", length = 255)
	private String armorType;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the armorType
	 */
	public String getArmorType() {
		return armorType;
	}

	/**
	 * @param armorType the armorType to set
	 */
	public void setArmorType(String armorType) {
		this.armorType = armorType;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "user", length = 255)
	private String user;

	public Armor() {
		// TODO Auto-generated constructor stub
	}
	
	public Armor(String name, String description, String armorType, int magazine, String user) {
		this.name = name;
		this.description = description;
		this.armorType = armorType;
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Name : " + this.name + " | Description : " + this.description;
	}
	

}
