package com.ronving.dao.impl;

import com.ronving.model.Account;
import com.ronving.model.Order;
import com.ronving.model.builders.AccountBuilder;
import com.ronving.model.builders.OrderBuilder;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SQLOrderDAOTest {

    private static SQLOrderDAO orderDAO;
    private static Order order1;
    private static Order order2;
    String sdate = "2020-03-05";
    Date date;

    {
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static Account account;

    @Before
    public void setUp() throws Exception {
        orderDAO = mock(SQLOrderDAO.class);

        account = new AccountBuilder().setId(1).setLogin("log1").setPassword("pass1").setRole().setBalance(0).build();
        order1 = new OrderBuilder().setOrderKey(01).setHallId(1).setDateValid(date).setHallTheme("theme").build();
        order2 = new OrderBuilder().setOrderKey(02).setHallId(1).setDateValid(date).setHallTheme("theme").build();

        when(orderDAO.getOrders(account)).thenReturn(Arrays.asList(order1, order2));
    }

    @Test
    public void getOrders() {
        List<Order> orders = orderDAO.getOrders(account);
        assertEquals(2, orders.size());
    }
}