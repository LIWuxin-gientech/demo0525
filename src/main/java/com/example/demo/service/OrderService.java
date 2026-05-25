package com.example.demo.service;

import com.example.demo.DTO.OrderDTO;
import com.example.demo.Mapper.OrderRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final JdbcTemplate jdbcTemplate;

    public OrderService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OrderDTO> getOrderDetails() {
        String sql = """
                select
                    o.order_id,
                    o.order_no,
                    o.order_date,
                    o.status,
                    c.customer_name,
                    c.customer_type,
                    oi.product_name,
                    oi.quantity,
                    oi.unit_price,
                    (oi.quantity * oi.unit_price) as amount
                from orders o
                inner join customers c
                    on o.customer_id = c.customer_id
                inner join order_items oi
                    on o.order_id = oi.order_id
                order by o.order_id, oi.order_item_id
                """;

        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    public List<OrderDTO> searchOrderDetails(String customerType, String status) {
        String sql = """
                select
                    o.order_id,
                    o.order_no,
                    o.order_date,
                    o.status,
                    c.customer_name,
                    c.customer_type,
                    oi.product_name,
                    oi.quantity,
                    oi.unit_price,
                    (oi.quantity * oi.unit_price) as amount
                from orders o
                inner join customers c
                    on o.customer_id = c.customer_id
                inner join order_items oi
                    on o.order_id = oi.order_id
                where 1 = 1
                  and (? is null or c.customer_type = ?)
                  and (? is null or o.status = ?)
                order by o.order_id, oi.order_item_id
                """;

        return jdbcTemplate.query(
                sql,
                new OrderRowMapper(),
                customerType, customerType,
                status, status
        );
    }
}