package pronsky.digitalChiefTestTask.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pronsky.digitalChiefTestTask.service.FilmService;
import pronsky.digitalChiefTestTask.service.dto.FilmDto;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
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
    public FilmDto edit(@PathVariable Long id, @RequestBody @Valid FilmDto filmDto, Errors errors) {
        checkErrors(errors);
        filmDto.setId(id);
        return service.save(filmDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    private ResponseEntity<FilmDto> buildResponseCreated(FilmDto created) {
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    private void checkErrors(Errors errors) {
        if (errors.hasErrors()) {
            throw new ValidationException((Throwable) errors);
        }
    }
}
