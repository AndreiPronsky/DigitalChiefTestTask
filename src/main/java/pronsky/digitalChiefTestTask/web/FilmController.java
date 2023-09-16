package pronsky.digitalChiefTestTask.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pronsky.digitalChiefTestTask.service.FilmService;
import pronsky.digitalChiefTestTask.service.dto.FilmDto;
import pronsky.digitalChiefTestTask.service.exception.ValidationException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/films")
public class FilmController {
    private final FilmService service;

    @GetMapping("/{id}")
    public FilmDto get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping()
    public List<FilmDto> getAll() {
        return service.getAll();
    }


    @PostMapping()
    public ResponseEntity<FilmDto> add(@RequestBody @Valid FilmDto filmDto, Errors errors) {
        checkErrors(errors);
        FilmDto created = service.save(filmDto);
        return buildResponseCreated(created);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public FilmDto update(@PathVariable Long id, @RequestBody @Valid FilmDto filmDto, Errors errors) {
        checkErrors(errors);
        filmDto.setId(id);
        return service.save(filmDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public FilmDto updatePart(@PathVariable Long id, @RequestBody @Valid FilmDto film) {
        film.setId(id);
        return service.save(film);
    }


        @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    private ResponseEntity<FilmDto> buildResponseCreated(FilmDto created) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(getLocation(created))
                .body(created);
    }

    private void checkErrors(Errors errors) {
        if (errors.hasErrors()) {
            throw new ValidationException(errors);
        }
    }

    private URI getLocation(FilmDto film) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/films/{id}")
                .buildAndExpand(film.getId())
                .toUri();
    }
}
