package com.coagula.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coagula.hrworker.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
