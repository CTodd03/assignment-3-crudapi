package com.csc340.trainers.trainers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Trainer not found with id: " + id));
    }

    public List<Trainer> getTrainersByName(String name) {
        return trainerRepository.findByNameContainingIgnoreCase(name);
    }

    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(Long id, Trainer trainerDetails) {
        Trainer trainer = getTrainerById(id);
        trainer.setName(trainerDetails.getName());
        trainer.setDescription(trainerDetails.getDescription());
        trainer.setType(trainerDetails.getType());
        trainer.setStrategy(trainerDetails.getStrategy());

        return trainerRepository.save(trainer);
    }

    public void deleteTrainer(Long id) {
        trainerRepository.delete(getTrainerById(id));
    }
}
