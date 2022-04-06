package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "address", nullable = false)
    private Gender gender;

    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Baggage> baggagies = new ArrayList<>();

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<PersonFlight> personFlightList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public Role getRole() {
        return role;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Person(String fullName, Gender gender, Role role, Date birthday) {
        this.fullName = fullName;
        this.gender = gender;
        this.role = role;
        this.birthday = birthday;
    }

    public Person(Integer id, String fullName, Gender gender, Role role, Date birthday) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.role = role;
        this.birthday = birthday;
    }

    public Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", birthday=" + birthday;
    }
}
