package fr.limayrac.repository;

import java.util.List;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import fr.limayrac.model.Armor;
import fr.limayrac.model.Weapon;

@Repository
public interface ArmorRepository extends CrudRepository<Armor, Integer> {
	List<Armor> findAllByUser(String user);
}