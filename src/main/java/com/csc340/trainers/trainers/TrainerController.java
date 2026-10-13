package com.csc340.trainers.trainers;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/characters")
public class TrainerController {

    private final TrainerService characterService;

    public TrainerController(TrainerService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<Trainer> getCharacters(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String name) {
        return characterService.getCharacters(type, name);
    }

    @GetMapping("/{id}")
    public Trainer getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }

    @PostMapping
    public ResponseEntity<Trainer> createCharacter(@Valid @RequestBody Trainer character) {
        return ResponseEntity.status(HttpStatus.CREATED).body(characterService.createCharacter(character));
    }

    @PutMapping("/{id}")
    public Trainer updateCharacter(@PathVariable Long id, @Valid @RequestBody Trainer character) {
        return characterService.updateCharacter(id, character);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }
}
