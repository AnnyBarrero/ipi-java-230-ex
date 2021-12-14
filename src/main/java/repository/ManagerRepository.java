package com.ipiecoles.java.java230.repository;
import com.ipiecoles.java.java230.model.Manager;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ManagerRepository extends JpaRepository<Manager, Long> {
    @EntityGraph(attributePaths = "equipe")
    Manager findWithEquipeBy(Long id);
}