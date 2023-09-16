package pronsky.digitalChiefTestTask.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pronsky.digitalChiefTestTask.service.DirectorService;
import pronsky.digitalChiefTestTask.service.dto.DirectorDto;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/directors")
public class DirectorController {
    private final DirectorService service;

    @GetMapping("/{id}")
    public DirectorDto get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<DirectorDto> getAll() {
        return service.getAll();
    }

    @PostMapping()
    public ResponseEntity<DirectorDto> create(@RequestBody @Valid DirectorDto directorDto, Errors errors) {
        checkErrors(errors);
        DirectorDto created = service.save(directorDto);
        return buildResponseCreated(created);
    }

    @PutMapping("/{id}")
    public DirectorDto edit(@PathVariable Long id, @RequestBody @Valid DirectorDto directorDto, Errors errors) {
        checkErrors(errors);
        directorDto.setId(id);
        return service.save(directorDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    private ResponseEntity<DirectorDto> buildResponseCreated(DirectorDto created) {
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    private void checkErrors(Errors errors) {
        if (errors.hasErrors()) {
            throw new ValidationException((Throwable) errors);
        }
    }
}
