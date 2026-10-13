package com.csc340.trainers.trainers;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public List<Trainer> getTrainersByName(String name) {
        return trainerRepository.findByNameContainingIgnoreCase(name);
    }

    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(Long id, Trainer trainerDetails) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));

        trainer.setName(trainerDetails.getName());

        return trainerRepository.save(trainer);
    }

    public void deleteTrainer(Long id) {
        if (!trainerRepository.existsById(id)) {
            throw new RuntimeException("Trainer not found with id: " + id);
        }
        trainerRepository.deleteById(id);
    }
}
