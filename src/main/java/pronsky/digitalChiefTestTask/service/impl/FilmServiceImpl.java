package pronsky.digitalChiefTestTask.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pronsky.digitalChiefTestTask.data.entities.Film;
import pronsky.digitalChiefTestTask.data.repositories.FilmRepository;
import pronsky.digitalChiefTestTask.service.FilmService;
import pronsky.digitalChiefTestTask.service.dto.FilmDto;
import pronsky.digitalChiefTestTask.service.mapper.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository repository;
    private final Mapper mapper;

    @Override
    public FilmDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Unable to find film with id : " + id));
    }

    @Override
    public List<FilmDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FilmDto save(FilmDto filmDto) {
        Film film = mapper.toEntity(filmDto);
        return mapper.toDto(repository.save(film));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
