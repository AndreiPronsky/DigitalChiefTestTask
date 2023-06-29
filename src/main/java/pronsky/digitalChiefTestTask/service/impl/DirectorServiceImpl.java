package pronsky.digitalChiefTestTask.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pronsky.digitalChiefTestTask.data.entities.Director;
import pronsky.digitalChiefTestTask.data.repositories.DirectorRepository;
import pronsky.digitalChiefTestTask.service.DirectorService;
import pronsky.digitalChiefTestTask.service.dto.DirectorDto;
import pronsky.digitalChiefTestTask.service.mapper.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final Mapper mapper;
    private final DirectorRepository repository;

    @Override
    public DirectorDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Unable to find director with id : " + id));
    }

    @Override
    public List<DirectorDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DirectorDto getByLastName(String lastName) {
        return repository.findByLastName(lastName)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Unable to find director with lastname : " + lastName));
    }

    @Override
    public List<DirectorDto> getByCountryOfBirth(String country) {
        return repository.findByCountryOfBirth(country)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DirectorDto> getByYearOfBirth(Integer yearOfBirth) {
        return repository.findAllByYearOfBirth(yearOfBirth)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DirectorDto save(DirectorDto directorDto) {
        Director director = mapper.toEntity(directorDto);
        return mapper.toDto(repository.save(director));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
