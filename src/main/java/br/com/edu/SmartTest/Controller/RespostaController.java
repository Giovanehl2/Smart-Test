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

import br.com.edu.SmartTest.Model.Prova;
import br.com.edu.SmartTest.Model.Resposta;
import br.com.edu.SmartTest.Model.Repository.RespostaRepository;

@RestController
@RequestMapping({"/Resposta"})
public class RespostaController {

	
	   @Autowired
	   private static RespostaRepository repository;

//	  RespostaController(RespostaRepository RespostaRepository) {
//	      this.repository = RespostaRepository;
//	  }
	  
	  @GetMapping(path = {"/{id}"})
	  public ResponseEntity<Resposta> findById(@PathVariable long id){
	    return repository.findById(id)
	            .map(x -> ResponseEntity.ok().body(x))
	            .orElse(ResponseEntity.notFound().build());
	  }
	  
	  @PostMapping
	  public void salvar(@RequestBody Resposta resposta) {
		  
		  
		  repository.save(resposta);
	  }
	  	  
	  @PutMapping(value="/{id}")
	  public ResponseEntity<Resposta> update(@PathVariable("id") long id, @RequestBody Resposta resposta){
	    return repository.findById(id)
	        .map(x -> {
	            x.setResposta(resposta.getResposta());
	            Resposta updated = repository.save(x);
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

		public static void  salvarResposta(Resposta resposta) {
			try {
				repository.save(resposta);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
