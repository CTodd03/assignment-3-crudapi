package com.csc340.trainers.trainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharacterServiceTest {

    private TrainerRepository characterRepository;
    private TrainerService characterService;

    @BeforeEach
    void setUp() {
        characterRepository = mock(TrainerRepository.class);
        characterService = new TrainerService(characterRepository);
    }

    @Test
    void filtersByTypeCaseInsensitively() {
        when(characterRepository.findByTypeIgnoreCase("wizard")).thenReturn(List.of());

        characterService.getCharacters("wizard", null);

        verify(characterRepository).findByTypeIgnoreCase("wizard");
    }

    @Test
    void searchesNamesPartiallyAndCaseInsensitively() {
        when(characterRepository.findByNameContainingIgnoreCase("mer")).thenReturn(List.of());

        characterService.getCharacters(null, "mer");

        verify(characterRepository).findByNameContainingIgnoreCase("mer");
    }

    @Test
    void updatesCharacterImageUrl() {
        Trainer character = new Trainer();
        character.setImageUrl("/old_image.png");
        when(characterRepository.findById(1L)).thenReturn(Optional.of(character));

        Trainer updates = new Trainer();
        updates.setImageUrl("/brendan_image.png");

        characterService.updateCharacter(1L, updates);

        assertEquals("/brendan_image.png", character.getImageUrl());
        verify(characterRepository).save(character);
    }
}
