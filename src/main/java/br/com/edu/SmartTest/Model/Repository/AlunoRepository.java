package br.com.edu.SmartTest.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.SmartTest.Model.Aluno;

public interface AlunoRepository  extends JpaRepository<Aluno,Long> {

}
