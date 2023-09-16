package pronsky.digitalChiefTestTask.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pronsky.digitalChiefTestTask.service.DirectorService;
import pronsky.digitalChiefTestTask.service.dto.DirectorDto;
import pronsky.digitalChiefTestTask.service.exception.ValidationException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/directors")
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
    public DirectorDto update(@PathVariable Long id, @RequestBody @Valid DirectorDto directorDto, Errors errors) {
        checkErrors(errors);
        directorDto.setId(id);
        return service.save(directorDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DirectorDto updatePart(@PathVariable Long id, @RequestBody @Valid DirectorDto director) {
        director.setId(id);
        return service.save(director);
    }


        @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    private ResponseEntity<DirectorDto> buildResponseCreated(DirectorDto created) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(getLocation(created))
                .body(created);
    }

    private void checkErrors(Errors errors) {
        if (errors.hasErrors()) {
            throw new ValidationException(errors);
        }
    }

    private URI getLocation(DirectorDto director) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/directors/{id}")
                .buildAndExpand(director.getId())
                .toUri();
    }
}
