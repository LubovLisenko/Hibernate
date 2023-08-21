package entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "ticket")
@Entity
@Data
public class Ticket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id // первинни
    private long id;
   @Column(name = "created_at")
    private String created_at;

@ManyToOne
@JoinColumn(name="client_id")
private Client client;

@ManyToOne
@JoinColumn(name ="from_planet_id")
private Planet from;

@ManyToOne
@JoinColumn(name = "to_planet_id")
private Planet to;
}
