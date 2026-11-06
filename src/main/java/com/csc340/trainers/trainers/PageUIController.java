package com.csc340.trainers.trainers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageUIController {

    private final TrainerService characterService;

    public PageUIController(TrainerService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/")
    public String home(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            Model model) {
        model.addAttribute("characters", characterService.getCharacters(category, name));
        model.addAttribute("name", name);
        model.addAttribute("category", category);
        return "index";
    }

    @GetMapping("/characters/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("character", characterService.getCharacterById(id));
        return "details";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/characters/new")
    public String newCharacter(Model model) {
        model.addAttribute("character", new Trainer());
        return "character-form";
    }

    @PostMapping("/characters")
    public String createCharacter(
            @Valid @ModelAttribute("character") Trainer character,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return "character-form";
        }
        Trainer createdCharacter = characterService.createCharacter(character);
        return "redirect:/characters/" + createdCharacter.getCharacterId();
    }

    @GetMapping("/characters/{id}/edit")
    public String editCharacter(@PathVariable Long id, Model model) {
        model.addAttribute("character", characterService.getCharacterById(id));
        return "character-form";
    }

    @PostMapping("/characters/{id}")
    public String updateCharacter(
            @PathVariable Long id,
            @Valid @ModelAttribute("character") Trainer character,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            characterService.getCharacterById(id);
            character.setCharacterId(id);
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return "character-form";
        }
        characterService.updateCharacter(id, character);
        return "redirect:/characters/" + id;
    }

    @PostMapping("/characters/{id}/delete")
    public String deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return "redirect:/";
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ModelAndView handleNotFound(ResponseStatusException exception) {
        if (exception.getStatusCode().value() != HttpStatus.NOT_FOUND.value()) {
            throw exception;
        }
        ModelAndView view = new ModelAndView("error");
        view.setStatus(HttpStatus.NOT_FOUND);
        return view;
    }
}
