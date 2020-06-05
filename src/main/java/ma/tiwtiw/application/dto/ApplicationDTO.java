package ma.tiwtiw.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.tiwtiw.application.model.Application;
import ma.tiwtiw.core.dto.BaseDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDTO extends BaseDto<Application, String> {

  private String id;
  private String name;
  private String description;
  private String version;
}
