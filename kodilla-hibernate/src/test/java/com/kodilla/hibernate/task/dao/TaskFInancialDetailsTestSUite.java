package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskFinancialDeatils;
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
public class TaskFInancialDetailsTestSUite {
    @Autowired
    TaskFinancialDetailsDao taskFinancialDetailsDao;

    @Test
    public void testFindByPaid(){
        //given
        TaskFinancialDeatils taskFinancialDeatils =
                new TaskFinancialDeatils(new BigDecimal(115),false);
        taskFinancialDetailsDao.save(taskFinancialDeatils);
        int id = taskFinancialDeatils.getId();
        //when
        List<TaskFinancialDeatils> resultList = taskFinancialDetailsDao.findByPaid(false);
        //then
        Assert.assertEquals(1,resultList.size());
        //cleanup
        taskFinancialDetailsDao.deleteById(id);
    }
}
