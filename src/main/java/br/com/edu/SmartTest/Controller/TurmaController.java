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

import br.com.edu.SmartTest.Model.Turma;
import br.com.edu.SmartTest.Model.Repository.TurmaRepository;

@RestController
@RequestMapping({"/Turma"})
public class TurmaController {

	

	  private TurmaRepository repository;

	  TurmaController(TurmaRepository TurmaRepository) {
	      this.repository = TurmaRepository;
	  }
	  
	  @GetMapping(path = {"/{id}"})
	  public ResponseEntity<Turma> findById(@PathVariable long id){
	    return repository.findById(id)
	            .map(x -> ResponseEntity.ok().body(x))
	            .orElse(ResponseEntity.notFound().build());
	  }
	  
	  @PostMapping
	  public void salvar(@RequestBody Turma turma) {
		  
		  
		  repository.save(turma);
	  }
	  	  
	  @PutMapping(value="/{id}")
	  public ResponseEntity<Turma> update(@PathVariable("id") long id, @RequestBody Turma turma){
	    return repository.findById(id)
	        .map(x -> {
	            x.setNome(turma.getNome());
	            Turma updated = repository.save(x);
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

}
