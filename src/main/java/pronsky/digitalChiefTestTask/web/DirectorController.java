package pronsky.digitalChiefTestTask.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pronsky.digitalChiefTestTask.service.DirectorService;
import pronsky.digitalChiefTestTask.service.dto.DirectorDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/directors")
public class DirectorController {
    private final DirectorService service;

    @GetMapping("/{id}")
    public DirectorDto getOneById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<DirectorDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{lastname}")
    public DirectorDto getOneByLastname(@PathVariable String lastname) {
        return service.getByLastName(lastname);
    }

    @GetMapping("/{country}")
    public List<DirectorDto> getAllByCountryOfBirth(@PathVariable String country) {
        return service.getByCountryOfBirth(country);
    }

    @GetMapping("/{yearOfBirth}")
    public List<DirectorDto> getAllByYearOfBirth(@PathVariable Integer yearOfBirth) {
        return service.getByYearOfBirth(yearOfBirth);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DirectorDto add(@RequestBody @Valid DirectorDto directorDto) {
        return service.save(directorDto);
    }

    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DirectorDto edit(@RequestBody @Valid DirectorDto directorDto) {
        return service.save(directorDto);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
