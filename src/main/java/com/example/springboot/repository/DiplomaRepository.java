package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiplomaRepository extends JpaRepository<Diploma, Long> {

    Optional<Diploma> findByOnChainId(Long onChainId);

    Optional<Diploma> findByStudentAddress(String studentAddress);

    List<Diploma> findAllByStudentAddress(String studentAddress);
}