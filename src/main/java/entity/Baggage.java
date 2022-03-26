package entity;

import javax.persistence.*;

@Entity
@Table(name = "baggage")
public class Baggage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

}
