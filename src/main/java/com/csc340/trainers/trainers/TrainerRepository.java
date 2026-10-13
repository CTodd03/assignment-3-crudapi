package com.csc340.trainers.trainers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
	List<Trainer> findByNameContainingIgnoreCase(String name);
}
