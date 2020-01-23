package br.com.edu.SmartTest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.SmartTest.Model.Disciplina;
import br.com.edu.SmartTest.Model.Pergunta;
import br.com.edu.SmartTest.Model.Professor;
import br.com.edu.SmartTest.Model.Prova;
import br.com.edu.SmartTest.Model.Resposta;
import br.com.edu.SmartTest.Model.Turma;
import br.com.edu.SmartTest.Model.Repository.DisciplinaRepository;

@RestController
@RequestMapping({"/Disciplina"})
public class DisciplinaController {

	
	@Autowired
	  private static DisciplinaRepository repository;

//	  DisciplinaController(DisciplinaRepository DisciplinaRepository) {
//	      this.repository = DisciplinaRepository;
//	  }
	  
	  @GetMapping(path = {"/{id}"})
	  public ResponseEntity<Disciplina> findById(@PathVariable long id){
	    return repository.findById(id)
	            .map(x -> ResponseEntity.ok().body(x))
	            .orElse(ResponseEntity.notFound().build());
	  }
	  
	  @PostMapping
	  public void salvar(@RequestBody Disciplina disciplina) {

			
			if (!disciplina.getProvas().isEmpty()) {
				for (Prova prova : disciplina.getProvas()) {
					if (prova != null)
						ProvaController.salvarProva(prova);
				}
			}
			if (!disciplina.getTurmas().isEmpty()) {
				for (Turma turma : disciplina.getTurmas()) {
					if (turma != null)
						TurmaController.salvarTurma(turma);
				}
			}
			if (!disciplina.getPerguntas().isEmpty()) {
				for (Pergunta pergunta : disciplina.getPerguntas()) {
					if (pergunta != null)
						PerguntaController.salvarPergunta(pergunta);
				}
			}
			if (!disciplina.getRespostas().isEmpty()) {
				for (Resposta resposta : disciplina.getRespostas()) {
					if (resposta != null)
						RespostaController.salvarResposta(resposta);
				}
			}
			if (!disciplina.getProfessores().isEmpty()) {
				for (Professor professor : disciplina.getProfessores()) {
					if (professor != null)
						ProfessorController.salvarProfessor(professor);
				}
			}
		  repository.save(disciplina);
	  }
	  	  
	  @PutMapping(value="/{id}")
	  public ResponseEntity<Disciplina> update(@PathVariable("id") long id, @RequestBody Disciplina disciplina){
	    return repository.findById(id)
	        .map(x -> {
	            x.setDescricao(disciplina.getDescricao());
	            x.setNome(disciplina.getNome());
	            Disciplina updated = repository.save(x);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
	  
	  @DeleteMapping(path ={"/{id}"})
	  public ResponseEntity<?> delete(@PathVariable("id") long id) {
	    return repository.findById(id)
	        .map(record -> {
	            repository.deleteById(id);
	            return ResponseEntity.ok().build();
	        }).orElse(ResponseEntity.notFound().build());
	  }

		public static boolean salvarDisciplina(Disciplina disciplina) {
			try {
				repository.save(disciplina);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
}
