package pronsky.digitalChiefTestTask.service;

import pronsky.digitalChiefTestTask.service.dto.DirectorDto;

import java.util.List;

public interface DirectorService {
    DirectorDto getById(Long id);

    List<DirectorDto> getAll();

    DirectorDto save(DirectorDto directorDto);

    void deleteById(Long id);
}
