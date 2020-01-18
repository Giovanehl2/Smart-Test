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

import br.com.edu.SmartTest.Model.Prova;
import br.com.edu.SmartTest.Model.Repository.ProvaRepository;

@RestController
@RequestMapping({"/Prova"})
public class ProvaController {

	

	  private ProvaRepository repository;

	  ProvaController(ProvaRepository ProvaRepository) {
	      this.repository = ProvaRepository;
	  }
	  
	  @GetMapping(path = {"/{id}"})
	  public ResponseEntity<Prova> findById(@PathVariable long id){
	    return repository.findById(id)
	            .map(x -> ResponseEntity.ok().body(x))
	            .orElse(ResponseEntity.notFound().build());
	  }
	  
	  @PostMapping
	  public void salvar(@RequestBody Prova prova) {
		  
		  
		  repository.save(prova);
	  }
	  	  
	  @PutMapping(value="/{id}")
	  public ResponseEntity<Prova> update(@PathVariable("id") long id, @RequestBody Prova prova){
	    return repository.findById(id)
	        .map(x -> {
	            x.setDescricaoProva(prova.getDescricaoProva());
	            Prova updated = repository.save(x);
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
