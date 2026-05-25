package com.example.demo.Mapper;

import com.example.demo.DTO.OrderDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<OrderDTO> {

    @Override
    public OrderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDTO dto = new OrderDTO();
        dto.setOrderId(rs.getLong("order_id"));
        dto.setOrderNo(rs.getString("order_no"));
        dto.setOrderDate(rs.getDate("order_date").toLocalDate());
        dto.setStatus(rs.getString("status"));
        dto.setCustomerName(rs.getString("customer_name"));
        dto.setCustomerType(rs.getString("customer_type"));
        dto.setProductName(rs.getString("product_name"));
        dto.setQuantity(rs.getInt("quantity"));
        dto.setUnitPrice(rs.getBigDecimal("unit_price"));
        dto.setAmount(rs.getBigDecimal("amount"));
        return dto;
    }
}