package bancocrudspringboot.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "UsuarioSistema", uniqueConstraints={@UniqueConstraint(columnNames={"telefone"})})
public class Usuario {

    private long id;
    private String cidade;
    private String senha;    
    private String telefone;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
}