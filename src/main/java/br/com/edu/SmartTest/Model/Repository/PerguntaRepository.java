package br.com.edu.SmartTest.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.SmartTest.Model.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta,Long> {

}
