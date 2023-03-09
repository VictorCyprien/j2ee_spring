package fr.limayrac.service;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.limayrac.model.Armor;
import fr.limayrac.repository.ArmorRepository;

import java.util.Optional;

@Data
@Service
public class ArmorService{
	@Autowired
	private ArmorRepository ArmorRepository;
	
	public Optional<Armor> getArmor(final Integer id) {
        return ArmorRepository.findById(id);
    }

    public Iterable<Armor> getArmor(String user) {
        return ArmorRepository.findAllByUser(user);
    }

    public void deleteArmor(final Integer id) {
    	ArmorRepository.deleteById(id);
    }

    public Armor saveArmor(Armor armor) {
        return ArmorRepository.save(armor);
    }
}