package com.csc340.trainers.trainers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

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
}
