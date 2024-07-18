package bancocrudspringboot.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Atividade")
public class Atividade {
    
    private long id;
    private long usuario;

    private String tipo; // CARTAO - ESTACIONAMENTO - CREDITO - VEICULO
    // Cartao:
    //      Adicionado - Ocorre ao inserir novo cartao
    //      Excluido - Ocorre ao excluir um cartao

    // Estacionamento:
    //      Iniciado - Ocorre quando é estacionado um veiculo

    // Credito:
    //      Adicionado - Ocorre quando é adicionado um credito
    //      Atualizado - Ocorre quando é utilizado um credito

    // Veiculo:
    //      Adicionado - Ocorre ao inserir novo veiculo
    //      Excluido - Ocorre ao excluir um veiculo

    private long cartao_id;
    private long credito_id;
    private long estacionamento_id;
    private long veiculo_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

}
