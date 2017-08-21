package com.morkovka.entity;

import org.springframework.util.Assert;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;


@Entity(name = "ORDERLINE_TABLE")
@Table(name = "ORDERLINE_TABLE")
public class OrderLine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long idOrder;

    @Column(nullable = false)
    private Integer count;

    @Column(nullable = false)
    private String goods;

    @Column(nullable = false)
    private Double price;


    public OrderLine() {}
    public OrderLine(Long id, Long idOrder, String goods, Integer count, Double price) {
        Assert.hasText(idOrder.toString(), "id can not be empty or null!");
        Assert.hasText(id.toString(), "id can not be empty or null!");
        Assert.hasText(goods, "goods can not be empty or null!");
        Assert.hasText(count.toString(), "count can not be empty or null!");
        Assert.hasText(price.toString(), "price can not be empty or null!");
        this.id = id;
        this.goods = goods;
        this.count = count;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }
    public String getClientGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(String code) {
        this.count = count;
    }

    public Double getPrice() { return this.price; }

    public void setPrice(Double price) {
        this.price = price;
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
        OrderLine other = (OrderLine) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}