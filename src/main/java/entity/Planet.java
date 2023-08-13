package entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "planet")
@Entity
@Data
public class Planet {
    @Id
    @Column
    private String id;
    @Column
    private String name;
}
