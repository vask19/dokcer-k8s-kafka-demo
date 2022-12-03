package vask.spring.microservices.planner.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vask.spring.microservices.planner.entity.Category;

import java.util.List;


// Вы можете уже сразу использовать все методы CRUD (Create, Read, Update, Delete)
// принцип ООП: абстракция-реализация - здесь описываем все доступные способы доступа к данным
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // поиск категорий пользователя (по названию)
    List<Category> findByUserIdOrderByTitleAsc(Long id);

    // поиск значений по названию для конкретного пользователя
    @Query("SELECT c FROM Category c where " +
            "(:title is null or :title='' " + // если передадим параметр title пустым, то выберутся все записи (сработает именно это условие)
            " or lower(c.title) like lower(concat('%', :title,'%'))) " + // если параметр title не пустой, то выполнится уже это условие
            " and c.userId=:id  " + // фильтрация для конкретного пользователя
            " order by c.title asc") // сортировка по названию

    List<Category> findByTitle(@Param("title") String title, @Param("id") Long id);
}
