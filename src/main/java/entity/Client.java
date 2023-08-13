package entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "client")
@Entity
@Data
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id // первинний ключ
    private long id;
    @Column
    private String name;

}
