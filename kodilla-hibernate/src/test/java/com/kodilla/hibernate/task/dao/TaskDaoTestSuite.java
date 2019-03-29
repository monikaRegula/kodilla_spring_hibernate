package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDeatils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDaoTestSuite {
    @Autowired
    private TaskDao taskDao;//referencja do kontrolera repozytorium
    private static final String DESCRIPTION = "Test: learn HIBERNATE";

    @Test
    public void testTaskDaoSave() {
        //given
        Task task = new Task(DESCRIPTION, 7);
        //when
        taskDao.save(task);
        //then
        int id = task.getId();
        //Optional&lt;Task&gt; readTask = taskDao.findById(id);
        Optional<Task> readTask = taskDao.findById(id);
        //cleanUp
        taskDao.deleteById(id);

    }

    @Test
    public void testTaskDaoFindByDuration() {
        //given
        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        int duration = task.getDuration();
        //when
       // List<Task> readTask = taskDao.findByDuration(duration);
        //then
        //Assert.assertEquals(1, readTask.size());
    }

    @Test
    public void testTaskDaoSaveWithFinancialDetails(){
        //given
        Task task = new Task(DESCRIPTION,30);
        task.setTaskFinancialDeatils(new TaskFinancialDeatils(new BigDecimal(120),false));
        //when
        taskDao.save(task);
        int id = task.getId();
        //then
        Assert.assertNotEquals(0,id);
        //cleanup
        //taskDao.deleteById(id);

    }
}
