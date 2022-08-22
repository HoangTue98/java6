package Tuehv_jv6.service;

import com.fasterxml.jackson.databind.JsonNode;

import Tuehv_jv6.entity.Order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    Order create(JsonNode orderData);

    Object findById(Long id);

    Page<Order> findByCus(String name, Pageable pageable);
}
