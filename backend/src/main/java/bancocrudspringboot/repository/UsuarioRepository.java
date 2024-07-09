package bancocrudspringboot.repository;

import bancocrudspringboot.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Optional<Usuario> findUsuarioByTelefoneAndSenha(String telefone, String senha);
}
