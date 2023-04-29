package fr.limayrac.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "weapon")
public class Weapon implements Serializable{
	
	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "type", length = 255)
	private String type;

	@Column(name = "user", length = 255)
	private String user;
	
	public Weapon() {
		// TODO Auto-generated constructor stub
	}
	
	public Weapon(String name, String description, String type, String damage_type, int magazine, String user) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.user = user;
	}
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "Name : " + this.name + " | Description : " + this.description + ", | Type : " + this.type;
	}
}
