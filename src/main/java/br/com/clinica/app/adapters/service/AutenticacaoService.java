package br.com.clinica.app.adapters.service;

import br.com.clinica.app.adapters.database.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


 //classe que implementa essa interface geralmente contém uma lógica para validar as credenciais de um cliente que está se autenticando.

@Service
@RequiredArgsConstructor
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario = repository.findByEmail(username);
        if(usuario.isPresent()){
            return usuario.get();
        } else {
            throw new UsernameNotFoundException("Dados invalidos");
        }
    }
}
