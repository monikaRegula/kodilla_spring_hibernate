package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskFinancialDeatils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TaskFinancialDetailsDao extends CrudRepository<TaskFinancialDeatils,Integer> {
    List<TaskFinancialDeatils> findByPaid(boolean paid);
}
