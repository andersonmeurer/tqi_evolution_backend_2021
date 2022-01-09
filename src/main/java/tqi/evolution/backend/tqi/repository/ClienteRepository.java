package tqi.evolution.backend.tqi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tqi.evolution.backend.tqi.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {//CrudRepository

}