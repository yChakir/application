package ma.tiwtiw.application.converter;

import ma.tiwtiw.application.dto.ApplicationDTO;
import ma.tiwtiw.application.model.Application;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ApplicationToDtoConverter implements Converter<Application, ApplicationDTO> {

  @Override
  public ApplicationDTO convert(Application application) {
    return ApplicationDTO.builder()
        .id(application.getId())
        .name(application.getName())
        .description(application.getDescription())
        .version(application.getVersion())
        .build();
  }
}
