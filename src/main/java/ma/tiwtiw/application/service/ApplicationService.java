package ma.tiwtiw.application.service;

import java.util.List;
import ma.tiwtiw.application.model.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ApplicationService {

    Application save(Application object);

    Application update(String id, Application object);

    Application patch(String id, Application object);

    Application findById(String id);

    boolean existsById(String id);

    void deleteById(String id);

    void delete(Application object);

    List<Application> findAll();

    Page<Application> findAll(Pageable pageable);
}
