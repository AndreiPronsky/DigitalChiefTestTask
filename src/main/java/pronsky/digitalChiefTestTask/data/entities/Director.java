package pronsky.digitalChiefTestTask.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "directors")
public class Director {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "birth_year")
    private Integer yearOfBirth;

    @Column(name = "sex")
    private String sex;

    @Column(name = "country_of_birth")
    private String countryOfBirth;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id")
    private List<Film> films;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return Objects.equals(id, director.id) && Objects.equals(firstName, director.firstName) && Objects.equals(lastName, director.lastName) && Objects.equals(yearOfBirth, director.yearOfBirth) && Objects.equals(sex, director.sex) && Objects.equals(countryOfBirth, director.countryOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, yearOfBirth, sex, countryOfBirth);
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", sex='" + sex + '\'' +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                '}';
    }
}