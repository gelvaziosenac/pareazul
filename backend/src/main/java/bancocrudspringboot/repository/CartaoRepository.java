package bancocrudspringboot.repository;

import bancocrudspringboot.model.Cartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long>{
    List<Cartao> findCartaoByUsuario(Long usuario_id);

    // List<Cartao> find          Cartao By Usuario(Long usuario);
    //              SELECT * FROM cartao where usuario = 1  --parametro_usuario
}
