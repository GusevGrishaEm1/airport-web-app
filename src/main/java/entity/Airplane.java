package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airplane")
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "tail_number", nullable = false)
    private String tailNumber;

    @Column(name = "model_name", nullable = false)
    private String modelName;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy = "airplane", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Flight> flights = new ArrayList<>();

    public Airplane(String tailNumber, String modelName, Integer capacity) {
        this.tailNumber = tailNumber;
        this.modelName = modelName;
        this.capacity = capacity;
    }

    public Airplane(Integer id, String tailNumber, String modelName, Integer capacity) {
        this.id = id;
        this.tailNumber = tailNumber;
        this.modelName = modelName;
        this.capacity = capacity;
    }

    public Airplane() {
    }

    public Integer getId() {
        return id;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
