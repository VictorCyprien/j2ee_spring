package fr.limayrac.service;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.limayrac.model.Weapon;
import fr.limayrac.repository.WeaponRepository;

import java.util.Optional;

@Data
@Service
public class WeaponService{
	@Autowired
	private WeaponRepository weaponRepository;
	
	public Optional<Weapon> getWeapon(final Integer id) {
        return weaponRepository.findById(id);
    }

    public Iterable<Weapon> getWeapon(String user) {
        return weaponRepository.findAllByUser(user);
    }

    public void deleteWeapon(final Integer id) {
    	weaponRepository.deleteById(id);
    }

    public Weapon saveWeapon(Weapon weapon) {
        return weaponRepository.save(weapon);
    }
}