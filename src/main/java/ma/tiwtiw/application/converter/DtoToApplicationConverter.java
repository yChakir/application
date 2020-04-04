package ma.tiwtiw.application.converter;

import ma.tiwtiw.application.dto.ApplicationDTO;
import ma.tiwtiw.application.model.Application;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToApplicationConverter implements Converter<ApplicationDTO, Application> {

    @Override
    public Application convert(ApplicationDTO dto) {
        return Application.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}
