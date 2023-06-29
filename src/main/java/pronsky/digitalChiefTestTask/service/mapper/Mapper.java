package pronsky.digitalChiefTestTask.service.mapper;

import pronsky.digitalChiefTestTask.data.entities.Director;
import pronsky.digitalChiefTestTask.data.entities.Film;
import pronsky.digitalChiefTestTask.service.dto.DirectorDto;
import pronsky.digitalChiefTestTask.service.dto.FilmDto;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    FilmDto toDto(Film film);

    Film toEntity(FilmDto filmDto);

    DirectorDto toDto(Director director);

    Director toEntity(DirectorDto directorDto);
}
