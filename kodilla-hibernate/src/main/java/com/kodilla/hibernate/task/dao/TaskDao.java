package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional //mówi że wywołanie danej metody powinno być zrealizowane
//w ramach 1 transakcji
@Repository// adnotacja Springa mówi że nasz interfejs powinien być użyty do
//tworzenia Beana(który jest w kontenerze Inversion of Control) który bd
//kontrolerem repozytorium
public interface TaskDao extends CrudRepository<Task,Integer> {
    List<Task>  findByDuration (int duration);
    @Query
    List<Task> retrieveLongTasks();

    @Query
    List<Task> retrieveShortTasks();

    @Query(nativeQuery = true) // nativeQuery = true bo to zapytanie w czystym języku SQL
    List<Task> retrieveTasksWithEnoughTime();

    @Query
    List<Task> retrieveTasksWithDurationLongerThan(@Param("DURATION") int duration);
}
