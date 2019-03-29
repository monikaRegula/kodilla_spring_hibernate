package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDeatils;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.Dao.TaskListDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    @Autowired
    private TaskDao taskDao;

    private static final String DESCRIPTION = "CREATING ENTITY ;)";
    private static final String LISTNAME = " LISTNAME";

    @Test
    public void testFindByListName() {
        //given
        TaskList taskList = new TaskList("John", DESCRIPTION);
        taskListDao.save(taskList);
        String listName = taskList.getListName();
        //when
        int id = taskList.getId();
        List<TaskList> readTask = taskListDao.findByListName(listName);
        //then
        Assert.assertEquals(1, readTask.size());
        //cleanup
        taskListDao.deleteById(id);
    }

    @Test
    public void testTaskListDaoSaveWithTasks() {
        //given
        Task task = new Task("Learning Hibernate", 14);
        Task task2 = new Task("Writing some entities:", 3);
        TaskFinancialDeatils tfd = new TaskFinancialDeatils(new BigDecimal(20), false);
        TaskFinancialDeatils tfd2 = new TaskFinancialDeatils(new BigDecimal(10), false);
        task.setTaskFinancialDeatils(tfd);
        task2.setTaskFinancialDeatils(tfd2);
        TaskList taskList = new TaskList(LISTNAME, "TO DO TASKS");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);
        //when
        taskListDao.save(taskList);
        int id = taskList.getId();
        //then
        Assert.assertNotEquals(0, id);
        //cleanup
        taskListDao.deleteById(id);
    }

    @Test
    public void testNamedQuerise() {
        //given
        Task task1 = new Task("Test: Study Hibernate", 3);
        Task task2 = new Task("Test: Practice Named Queries", 6);
        Task task3 = new Task("Test: Study native queries", 7);
        Task task4 = new Task("Test: Makse some tests", 13);

        TaskFinancialDeatils tfd1 = new TaskFinancialDeatils(new BigDecimal(5), false);
        TaskFinancialDeatils tfd2 = new TaskFinancialDeatils(new BigDecimal(10), false);
        TaskFinancialDeatils tfd3 = new TaskFinancialDeatils(new BigDecimal(20), false);
        TaskFinancialDeatils tfd4 = new TaskFinancialDeatils(new BigDecimal(15), false);

        task1.setTaskFinancialDeatils(tfd1);
        task2.setTaskFinancialDeatils(tfd2);
        task3.setTaskFinancialDeatils(tfd3);
        task4.setTaskFinancialDeatils(tfd4);

        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);

        taskListDao.save(taskList);
        int id = taskList.getId();
       //when
        List<Task> longTasks = taskDao.retrieveLongTasks();
        List<Task> shortTasks = taskDao.retrieveShortTasks();
        List<Task> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
        List<Task> durationLOngerThanTasks = taskDao.retrieveTasksWithDurationLongerThan(6);
        //then
        try {
            Assert.assertEquals(1, longTasks.size());
            Assert.assertEquals(3, shortTasks.size());
            Assert.assertEquals(3, enoughTimeTasks.size());
            Assert.assertEquals(2,durationLOngerThanTasks.size());
       } finally {
           // CleanUp
            taskListDao.deleteById(id);
        }
    }

}
