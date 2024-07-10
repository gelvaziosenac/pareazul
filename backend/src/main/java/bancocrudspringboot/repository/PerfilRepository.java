package bancocrudspringboot.repository;

import bancocrudspringboot.model.Perfil;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{
    
    Optional<Perfil> findPerfilByTelefone(String telefone);
}
