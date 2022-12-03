package vask.spring.microservices.planner.todo.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import vask.spring.microservices.planner.entity.Priority;
import vask.spring.microservices.planner.todo.repo.PriorityRepository;

import java.util.List;

// всегда нужно создавать отдельный класс Service для доступа к данным, даже если кажется,
// что мало методов или это все можно реализовать сразу в контроллере
// Такой подход полезен для будущих доработок и правильной архитектуры (особенно, если работаете с транзакциями)
@Service

// все методы класса должны выполниться без ошибки, чтобы транзакция завершилась
// если в методе возникнет исключение - все выполненные операции из данного метода откатятся (Rollback)
@Transactional
public class PriorityService {

    private final PriorityRepository repository; // сервис имеет право обращаться к репозиторию (БД)

    public PriorityService(PriorityRepository repository) {
        this.repository = repository;
    }

    public List<Priority> findAll(Long userId) {
        return repository.findByUserIdOrderByIdAsc(userId);
    }

    public Priority add(Priority priority) {
        return repository.save(priority); // метод save обновляет или создает новый объект, если его не было
    }

    public Priority update(Priority priority) {
        return repository.save(priority); // метод save обновляет или создает новый объект, если его не было
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Priority findById(Long id) {
        return repository.findById(id).get(); // т.к. возвращается Optional - можно получить объект методом get()
    }

    public List<Priority> find(String title, Long userId) {
        return repository.findByTitle(title, userId);
    }

}
