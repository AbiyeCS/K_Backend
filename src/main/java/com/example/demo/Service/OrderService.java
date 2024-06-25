package com.example.demo.Service;

import com.example.demo.Exception.OrderDoesNotExistException;
import com.example.demo.Model.Order1;
import com.example.demo.Repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class OrderService {
    private OrderRepository orderRepository;

    public String deleteOrder(Integer id) {
        if(!orderRepository.existsById(id)) {
            throw new OrderDoesNotExistException("Order with id " + id + " does not exist");
        }
        orderRepository.deleteById(id);

        return "Order with id: " + id + " deleted";
    }

    public Order1 updateOrder(Integer id, Order1 newOrder) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setOrderID(newOrder.getOrderID());
                    order.setCustomerID(newOrder.getCustomerID());
                    order.setOrderDate(newOrder.getOrderDate());
                    return orderRepository.save(order);
                }).orElseThrow(() -> new OrderDoesNotExistException("Order with id " + id + " does not exist"));
    }

    public Order1 findOrderById(Integer id) {
        Optional<Order1> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new OrderDoesNotExistException("This product does not exist"));
    }

    public List<Order1> getAllOrders(){
        List<Order1> orders = orderRepository.findAll();

        // Uses the toString method in the Order class that we created
        System.out.println(orders);

        // Sort in descending order
        Collections.sort(orders);
        System.out.println("Orders in a descending order= " + orders);

        //Only displays orders from last week
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -7); // Subtract 7 days to get the date from last week
        Date lastWeekDate = cal.getTime();
        List<Order1> ordersFromLastWeek = orders.stream()
                .filter(order -> order.getOrderDate().after(lastWeekDate))
                .toList();
        System.out.println("Orders from last week = "+ ordersFromLastWeek);

        //Only displays orders from specific customerID
        List<Order1> orderFromSpecificID = orders.stream().filter(order -> order.getOrderID() == 5).toList();
        System.out.println("Orders from specific ID = "+ orderFromSpecificID);

        //Display most recent order
        Order1 mostRecentOrder = orders.stream()
                .max(Comparator.comparing(Order1::getOrderDate))
                .orElse(null);
        System.out.println("Most recent order = "+ mostRecentOrder);

        //Display oldest order
        Order1 oldestOrder = orders.stream()
                .min(Comparator.comparing(Order1::getOrderDate))
                .orElse(null);

        System.out.println("Oldest order = "+ oldestOrder);

        //Display the person with the most orders


        //Display the person with the least orders

        return orders;
    }
}
