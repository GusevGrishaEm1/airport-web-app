package entity;

import javax.persistence.*;

@Entity
@Table(name = "airplane")
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "model_name", nullable = false)
    private String modelName;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

}
