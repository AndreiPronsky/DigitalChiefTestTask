package pronsky.digitalChiefTestTask.service;

import pronsky.digitalChiefTestTask.service.dto.FilmDto;

import java.util.List;

public interface FilmService {
    FilmDto getById(Long id);

    List<FilmDto> getAll();

    FilmDto getByTitle(String title);

    List<FilmDto> getByYearOfRelease(Integer year);

    FilmDto save(FilmDto filmDto);

    void deleteById(Long id);
}
