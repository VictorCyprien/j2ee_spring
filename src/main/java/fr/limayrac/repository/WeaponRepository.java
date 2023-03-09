package fr.limayrac.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import fr.limayrac.model.Weapon;

@Repository
public interface WeaponRepository extends CrudRepository<Weapon, Integer> {
	List<Weapon> findAllByUser(String user);
}