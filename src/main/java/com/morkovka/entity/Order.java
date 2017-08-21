package com.morkovka.entity;

import org.springframework.util.Assert;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;


@Entity(name = "ORDER_TABLE")
@Table(name = "ORDER_TABLE")
public class Order implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String client;

    @Column(nullable = false)
    private String address;

    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderLine> orderLines = new LinkedList<>();


    public Order() {}
    public Order(String client, String address, LocalDate orderDate) {
        Assert.hasText(client, "client can not be empty or null!");
        Assert.hasText(address, "address can not be empty or null!");

        this.client = client;
        this.address = address;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String code) {
        this.address = address;
    }


    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void OrderLinesClear() {
        orderLines.clear();
    }

    public void addOrderLines(OrderLine order) {
        if (this.orderLines == null) {
            orderLines = new LinkedList<OrderLine>();
        }
        this.orderLines.add(order);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}