package ma.tiwtiw.application.controller;

import ma.tiwtiw.application.dto.ApplicationDTO;
import ma.tiwtiw.application.model.Application;
import ma.tiwtiw.application.service.ApplicationService;
import ma.tiwtiw.core.controller.impl.BaseRestController;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("applications")
public class ApplicationController extends BaseRestController<Application, ApplicationDTO, String> {

  private final ApplicationService applicationService;

  private final ModelMapper modelMapper;

  public ApplicationController(ApplicationService applicationService,
      ModelMapper modelMapper) {
    super(Application.class, ApplicationDTO.class);
    this.applicationService = applicationService;
    this.modelMapper = modelMapper;
  }


  @Override
  protected ApplicationService getService() {
    return applicationService;
  }

  @Override
  protected ModelMapper getMapper() {
    return modelMapper;
  }
}
