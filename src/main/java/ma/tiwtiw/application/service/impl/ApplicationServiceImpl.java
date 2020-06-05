package ma.tiwtiw.application.service.impl;

import ma.tiwtiw.application.model.Application;
import ma.tiwtiw.application.service.ApplicationService;
import ma.tiwtiw.core.service.impl.BaseMongoTemplateServiceImpl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl extends
    BaseMongoTemplateServiceImpl<Application, String> implements ApplicationService {

  private final MongoTemplate mongoTemplate;

  public ApplicationServiceImpl(MongoTemplate mongoTemplate) {
    super(Application.class);
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  protected MongoTemplate getMongoTemplate() {
    return mongoTemplate;
  }
}
