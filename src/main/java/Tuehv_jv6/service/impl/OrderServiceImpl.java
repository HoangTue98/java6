package Tuehv_jv6.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Tuehv_jv6.entity.Order;
import Tuehv_jv6.entity.OrderDetail;
import Tuehv_jv6.repository.AccountRepository;
import Tuehv_jv6.repository.OrderDetailRepository;
import Tuehv_jv6.repository.OrderRepository;
import Tuehv_jv6.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderData,Order.class);
        orderRepository.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>(){};
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"),type)
                .stream().peek(d->d.setOrder(order)).collect(Collectors.toList());
        orderDetailRepository.saveAll(details);

        return order;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Page<Order> findByCus(String name, Pageable pageable) {
        return orderRepository.findAllByAccount_Username(name,pageable);
    }
}
