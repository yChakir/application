package ma.tiwtiw.application.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import ma.tiwtiw.application.dto.ApplicationDTO;
import ma.tiwtiw.application.model.Application;
import ma.tiwtiw.application.service.ApplicationService;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("applications")
public class ApplicationController {

  private final ApplicationService applicationService;

  private final ConversionService conversionService;

  @PostMapping
  public ResponseEntity save(@RequestBody ApplicationDTO dto) {
    final Application application = conversionService.convert(dto, Application.class);

    applicationService.save(application);

    return ResponseEntity.created(null).build();
  }

  @PutMapping("{id}")
  public ResponseEntity update(@PathVariable String id, @RequestBody ApplicationDTO dto) {
    final Application application = conversionService.convert(dto, Application.class);

    applicationService.update(id, application);

    return ResponseEntity.noContent().build();
  }

  @PatchMapping("{id}")
  public ResponseEntity patch(@PathVariable String id, @RequestBody ApplicationDTO dto) {
    final Application application = conversionService.convert(dto, Application.class);

    applicationService.patch(id, application);

    return ResponseEntity.noContent().build();
  }

  @GetMapping("{id}")
  public ResponseEntity findById(@PathVariable String id) {
    final Application application = applicationService.findById(id);

    final ApplicationDTO dto = conversionService.convert(application, ApplicationDTO.class);

    return ResponseEntity.ok(dto);
  }

  @GetMapping("{id}/exists")
  public ResponseEntity existsById(@PathVariable String id) {
    final boolean exists = applicationService.existsById(id);

    return ResponseEntity.ok(exists);
  }

  @DeleteMapping("{id}")
  public ResponseEntity deleteById(@PathVariable String id) {
    applicationService.deleteById(id);

    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity findAll() {
    final List<Application> applications = applicationService.findAll();

    final List<ApplicationDTO> dtos = applications.stream()
        .map(application -> conversionService.convert(application, ApplicationDTO.class))
        .collect(Collectors.toList());

    return ResponseEntity.ok(dtos);
  }

  @GetMapping("getPage")
  public ResponseEntity findAll(Pageable pageable) {
    final Page<Application> applications = applicationService.findAll(pageable);

    final Page<ApplicationDTO> page = applications
        .map(application -> conversionService.convert(application, ApplicationDTO.class));

    return ResponseEntity.ok(page);
  }
}
