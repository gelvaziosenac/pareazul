package bancocrudspringboot.repository;

import bancocrudspringboot.model.Cartao;
// import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long>{

    
    // @Query(value = "select * from cartao where nome ilike concat('%', :nome, '%')", nativeQuery = true)
    // List<Cartao> findCartaoByNome(@Param("nome")String nome);
    
    // Optional<Cartao> findCartaoById(long id);

    // List<Cartao> findCartaoByNumero(String numero);

    // List<Cartao> findCartaoByDataExpiracao(String dataexpiracao);

    // List<Cartao> findCartaoByCvv(String cvv);
    
    
}
