package pronsky.digitalChiefTestTask.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pronsky.digitalChiefTestTask.service.FilmService;
import pronsky.digitalChiefTestTask.service.dto.FilmDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmController {
    private final FilmService service;

    @GetMapping("/{id}")
    public FilmDto getOneById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping()
    public List<FilmDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{title}")
    public FilmDto getOneByTitle(@PathVariable String title) {
        return service.getByTitle(title);
    }

    @GetMapping("/{year}")
    public List<FilmDto> getAllByYearOfRelease(@PathVariable Integer year) {
        return service.getByYearOfRelease(year);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public FilmDto add(@RequestBody @Valid FilmDto filmDto) {
        return service.save(filmDto);
    }

    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public FilmDto edit(@RequestBody @Valid FilmDto filmDto) {
        return service.save(filmDto);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
