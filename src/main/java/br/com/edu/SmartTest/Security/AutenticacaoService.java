package br.com.edu.SmartTest.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.edu.SmartTest.Model.Usuario;
import br.com.edu.SmartTest.Model.Repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
    @Autowired
	private UsuarioRepository repository;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usr = repository.findBymatricula(username);
		if(usr.isPresent()) {
			return usr.get();
		}
		 throw new UsernameNotFoundException("Dados invalidos!");
	}

}
