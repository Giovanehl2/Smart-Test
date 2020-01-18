package br.com.edu.SmartTest.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.SmartTest.Model.Curso;

public interface CursoRepository extends JpaRepository<Curso,Long>{

}
