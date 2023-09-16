package pronsky.digitalChiefTestTask.service;

import pronsky.digitalChiefTestTask.service.dto.FilmDto;

import java.util.List;

public interface FilmService {
    FilmDto getById(Long id);

    List<FilmDto> getAll();

    FilmDto save(FilmDto filmDto);

    void deleteById(Long id);
}
