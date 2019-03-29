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
//    @Autowired
//    InvoiceDao invoiceDao;
    private static final String NUMBER= " NUMBER";
//
//    @Test
//    public void testInvoiceDaoSave(){
//        //given
////        Product product = new Product("banan");
////        Product product1 = new Product("gruszka");
////        Product product2 = new Product("truskawka");
////
////        Item item = new Item(new BigDecimal(10),2,new BigDecimal(5));
////        item.getProducts().add(product);
////        item.getProducts().add(product1);
////        item.getProducts().add(product2);
////
////        Invoice invoice = new Invoice(NUMBER);
////        Invoice invoice1 = new Invoice(NUMBER);
////        Invoice invoice2 = new Invoice(NUMBER);
////
////        item.setInvoice(invoice);
////        item.setInvoice(invoice1);
////        item.setInvoice(invoice2);
////
////        invoice.getItems().add(item);
////        invoice1.getItems().add(item);
////        invoice2.getItems().add(item);
////
////        //when
////        invoiceDao.save(invoice);
////        int id = item.getId();
////        invoiceDao.save(invoice1);
////        invoiceDao.save(invoice2);
////
////
////        //then
////        Assert.assertNotEquals(0,id);
//
//    }
}
