package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @ManyToMany(mappedBy = "persons")
    private Set<Flight> flights = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Person(String fullName, String address, String role, Date birthday) {
        this.fullName = fullName;
        this.address = address;
        this.role = role;
        this.birthday = birthday;
    }

    public Person(Integer id, String fullName, String address, String role, Date birthday) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.role = role;
        this.birthday = birthday;
    }

    public Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", birthday=" + birthday;
    }
}
