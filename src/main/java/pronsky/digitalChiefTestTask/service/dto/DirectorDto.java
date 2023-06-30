package pronsky.digitalChiefTestTask.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class DirectorDto {
    private Long id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Positive
    private Integer yearOfBirth;

    private String sex;

    private String countryOfBirth;

    private List<FilmDto> films;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorDto that = (DirectorDto) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(yearOfBirth, that.yearOfBirth) && Objects.equals(sex, that.sex) && Objects.equals(countryOfBirth, that.countryOfBirth) && Objects.equals(films, that.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, yearOfBirth, sex, countryOfBirth, films);
    }

    @Override
    public String toString() {
        return "DirectorDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", sex='" + sex + '\'' +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                ", films=" + films +
                '}';
    }
}
