package bancocrudspringboot.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Perfil", uniqueConstraints={@UniqueConstraint(columnNames={"telefone"})})
public class Perfil {
    
    private long id;

    private String nome;
    private String cpf;
    private String email;    
    private String telefone;    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

}