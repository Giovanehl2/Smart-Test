package br.com.edu.SmartTest.Controller;

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
import br.com.edu.SmartTest.Model.Professor;
import br.com.edu.SmartTest.Model.Repository.ProfessorRepository;

@RestController
@RequestMapping({"/Professor"})
public class ProfessorController {

	
	  private static ProfessorRepository repository;

	  ProfessorController(ProfessorRepository ProfessorRepository) {
	      repository = ProfessorRepository;
	  }
	  
	  @GetMapping(path = {"/{id}"})
	  public ResponseEntity<Professor> findById(@PathVariable long id){
	    return repository.findById(id)
	            .map(x -> ResponseEntity.ok().body(x))
	            .orElse(ResponseEntity.notFound().build());
	  }
	  
	  @PostMapping
	  public void salvar(@RequestBody Professor professor) {
		  
			if (!professor.getDisciplinas().isEmpty()) {
				for (Disciplina disciplina : professor.getDisciplinas()) {
					if (disciplina != null)
						DisciplinaController.salvarDisciplina(disciplina);
				}
			}
		  repository.save(professor);
	  }
	  	  
	  @PutMapping(value="/{id}")
	  public ResponseEntity<Professor> update(@PathVariable("id") long id, @RequestBody Professor professor){
	    return repository.findById(id)
	        .map(x -> {
	            x.setNome(professor.getNome());
	            x.setDisciplinas(professor.getDisciplinas());
	            Professor updated = repository.save(x);
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
	  
		public static void  salvarProfessor(Professor professor) {
			try {
				repository.save(professor);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

}
