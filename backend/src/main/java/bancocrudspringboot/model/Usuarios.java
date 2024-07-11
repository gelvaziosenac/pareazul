package bancocrudspringboot.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Usuarios", uniqueConstraints={@UniqueConstraint(columnNames={"telefone"})})
public class Usuarios {

    private long id;
    private String senha;
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