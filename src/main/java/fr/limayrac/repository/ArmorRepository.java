package fr.limayrac.repository;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import fr.limayrac.model.Armor;

@Repository
public interface ArmorRepository extends CrudRepository<Armor, Integer> {
	
}