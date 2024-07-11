package bancocrudspringboot.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bancocrudspringboot.model.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUsuarioByTelefoneAndSenha(String telefone, String senha);
}
