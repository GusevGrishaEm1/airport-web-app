package entity;

import javax.persistence.*;

@Entity
@Table(name = "baggage")
public class Baggage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Baggage(String type, Integer weight, Person person) {
        this.type = type;
        this.weight = weight;
        this.person = person;
    }

    public Baggage(Integer id, String type, Integer weight, Person person) {
        this.id = id;
        this.type = type;
        this.weight = weight;
        this.person = person;
    }

    public Baggage() {
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Integer getWeight() {
        return weight;
    }

    public Person getPerson() {
        return person;
    }
}
