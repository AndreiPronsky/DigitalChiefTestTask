package pronsky.digitalChiefTestTask.service.mapper;

import org.mapstruct.Mapper;
import pronsky.digitalChiefTestTask.data.entities.Director;
import pronsky.digitalChiefTestTask.data.entities.Film;
import pronsky.digitalChiefTestTask.service.dto.DirectorDto;
import pronsky.digitalChiefTestTask.service.dto.FilmDto;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    FilmDto toDto(Film film);

    Film toEntity(FilmDto filmDto);

    DirectorDto toDto(Director director);

    Director toEntity(DirectorDto directorDto);
}
