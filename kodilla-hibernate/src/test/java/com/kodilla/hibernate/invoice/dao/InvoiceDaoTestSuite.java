package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    ItemDao itemDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    InvoiceDao invoiceDao;
    private static final String NUMBER= " NUMBER";


    @Test
    public void testInvoiceDaoSave(){
//        //given
//        Product product = new Product("banan");
//        Product product1 = new Product("gruszka");
//        Product product2 = new Product("truskawka");
//
//        Item item = new Item(new BigDecimal(10),2,new BigDecimal(5));
//        Item item2 = new Item(new BigDecimal(10),2,new BigDecimal(5));
//        Item item3 = new Item(new BigDecimal(10),2,new BigDecimal(5));
//
//        item.getProducts().add(product);
//        item.getProducts().add(product1);
//        item2.getProducts().add(product2);
//        item3.getProducts().add(product1);
//        item3.getProducts().add(product2);
//
//        Invoice invoice = new Invoice(NUMBER);
//        invoice.getItems().add(item);
//        invoice.getItems().add(item2);
//        invoice.getItems().add(item3);
//
//        //when
//        itemDao.save(item);
//        int id = item.getId();
//        itemDao.save(item2);
//        itemDao.save(item3);
//
//        //then
//        Assert.assertNotEquals(0,id);

    }
}
