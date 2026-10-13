package com.csc340.trainers.trainers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class CharacterControllerTest {

    private TrainerService characterService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        characterService = mock(TrainerService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new TrainerController(characterService)).build();
    }

    @Test
    void getAllCharactersReturnsOk() throws Exception {
        when(characterService.getCharacters(null, null)).thenReturn(List.of());

        mockMvc.perform(get("/api/characters"))
                .andExpect(status().isOk());

        verify(characterService).getCharacters(null, null);
    }

    @Test
    void getCharacterByIdReturnsOk() throws Exception {
        when(characterService.getCharacterById(1L)).thenReturn(character(1L));

        mockMvc.perform(get("/api/characters/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.characterId").value(1));
    }

    @Test
    void postCharacterReturnsCreated() throws Exception {
        when(characterService.createCharacter(any(Trainer.class))).thenReturn(character(1L));

        mockMvc.perform(post("/api/characters")
                        .contentType("application/json")
                        .content(characterJson()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.characterId").value(1));
    }

    @Test
    void putCharacterReturnsOk() throws Exception {
        when(characterService.updateCharacter(any(Long.class), any(Trainer.class))).thenReturn(character(1L));

        mockMvc.perform(put("/api/characters/1")
                        .contentType("application/json")
                        .content(characterJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.characterId").value(1));
    }

    @Test
    void deleteCharacterReturnsNoContent() throws Exception {
        mockMvc.perform(delete("/api/characters/1"))
                .andExpect(status().isNoContent());

        verify(characterService).deleteCharacter(1L);
    }

    @Test
    void getCharactersPassesTypeAndNameFilters() throws Exception {
        when(characterService.getCharacters("wizard", "mer")).thenReturn(List.of());

        mockMvc.perform(get("/api/characters").param("type", "wizard").param("name", "mer"))
                .andExpect(status().isOk());

        verify(characterService).getCharacters("wizard", "mer");
    }

    private static Trainer character(Long id) {
        Trainer character = new Trainer();
        character.setCharacterId(id);
        character.setName("Merlin");
        character.setDescription("Wizard");
        character.setType("wizard");
        character.setStrategy("Magic");
        return character;
    }

    private static String characterJson() {
        return """
                {
                  "name": "Merlin",
                  "description": "Wizard",
                  "type": "wizard",
                  "strategy": "Magic"
                }
                """;
    }
}
