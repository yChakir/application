package ma.tiwtiw.application.service.impl;

import lombok.RequiredArgsConstructor;
import ma.tiwtiw.application.model.Application;
import ma.tiwtiw.application.exception.ResourceNotFoundException;
import ma.tiwtiw.application.repository.ApplicationRepository;
import ma.tiwtiw.application.service.ApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public Application save(Application object) {
        return applicationRepository.save(object);
    }

    @Override
    public Application update(String id, Application object) {
        Application application = findById(id);

        application.setName(object.getName());
        application.setDescription(object.getDescription());

        return applicationRepository.save(application);
    }

    @Override
    public Application patch(String id, Application object) {
        Application application = findById(id);

        if (!StringUtils.isEmpty(object.getName())) {
            application.setName(object.getName());
        }

        if (!StringUtils.isEmpty(object.getDescription())) {
            application.setDescription(object.getDescription());
        }

        return applicationRepository.save(application);
    }

    @Override
    public Application findById(String id) {
        return applicationRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsById(String id) {
        return applicationRepository.existsById(id);
    }

    @Override
    public void deleteById(String id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public void delete(Application object) {
        applicationRepository.delete(object);
    }

    @Override
    public Iterable<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Override
    public Page<Application> findAll(Pageable pageable) {
        return applicationRepository.findAll(pageable);
    }
}
