package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="airplane")
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name ="model_name", nullable = false)
    private String modelName;

    @Column(name ="capacity", nullable = false)
    private Integer capacity;

    @ManyToMany(mappedBy = "airplanes")
    private Set<Flight> flights = new HashSet<>();

}
