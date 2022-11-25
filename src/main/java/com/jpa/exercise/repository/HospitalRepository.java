package com.jpa.exercise.repository;

import com.jpa.exercise.domain.Hospital;
import com.jpa.exercise.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
