package com.csc340.trainers.trainers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TrainerService {

    private final TrainerRepository characterRepository;

    public TrainerService(TrainerRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Trainer> getCharacters(String type, String name) {
        if (type != null && !type.isBlank() && name != null && !name.isBlank()) {
            return characterRepository.findByTypeIgnoreCaseAndNameContainingIgnoreCase(type, name);
        }
        if (type != null && !type.isBlank()) {
            return characterRepository.findByTypeIgnoreCase(type);
        }
        if (name != null && !name.isBlank()) {
            return characterRepository.findByNameContainingIgnoreCase(name);
        }
        return characterRepository.findAll();
    }

    public Trainer getCharacterById(Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Character not found with id: " + id));
    }

    public Trainer createCharacter(Trainer character) {
        character.setCharacterId(null);
        return characterRepository.save(character);
    }

    public Trainer updateCharacter(Long id, Trainer characterDetails) {
        Trainer character = getCharacterById(id);
        character.setName(characterDetails.getName());
        character.setDescription(characterDetails.getDescription());
        character.setType(characterDetails.getType());
        character.setStrategy(characterDetails.getStrategy());

        return characterRepository.save(character);
    }

    public void deleteCharacter(Long id) {
        characterRepository.delete(getCharacterById(id));
    }
}
