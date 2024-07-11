package bancocrudspringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Usuarios", uniqueConstraints = { @UniqueConstraint(columnNames = { "telefone" }) })
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