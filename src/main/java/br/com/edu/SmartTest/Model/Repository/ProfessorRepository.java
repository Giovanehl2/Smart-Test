package br.com.edu.SmartTest.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.SmartTest.Model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {

}
