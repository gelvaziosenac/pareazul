package bancocrudspringboot.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Credito")
public class Credito {

    private long id;
    private long usuario_id; // Codigo do usuario que vai receber o credito
    
    private String valor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
}