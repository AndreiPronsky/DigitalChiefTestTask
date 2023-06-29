package pronsky.digitalChiefTestTask.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Getter
@Setter
public class FilmDto {
    private Long id;
    @NotBlank
    private String title;
    @Positive
    private Integer yearOfRelease;
    @Positive
    private Integer budget;
    @Positive
    private Integer duration;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmDto filmDto = (FilmDto) o;
        return Objects.equals(id, filmDto.id) && Objects.equals(title, filmDto.title) && Objects.equals(yearOfRelease, filmDto.yearOfRelease) && Objects.equals(budget, filmDto.budget) && Objects.equals(duration, filmDto.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, yearOfRelease, budget, duration);
    }

    @Override
    public String toString() {
        return "FilmDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", budget=" + budget +
                ", duration=" + duration +
                '}';
    }
}
