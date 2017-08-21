package com.morkovka.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.morkovka.entity.OrderLine;

@Repository
public class OrderLineRepository implements IOrderLineRepository {

    Logger LOG = LoggerFactory.getLogger(OrderLineRepository.class);

    @PersistenceContext(unitName = "unitH2", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    private EntityManagerFactory emf;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public OrderLine findById(Long id) {
        LOG.info("find orderLine by id {}", id);
        return this.getEm().find(OrderLine.class, id);
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<OrderLine> listOrderLines() {
        LOG.info("list orderLines");
        Query query = this.getEm().createQuery("select o from ORDERLINE_TABLE o");
        return (List<OrderLine>) query.getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public OrderLine save(OrderLine orderLine) {
        if (orderLine.getId() == null) {
            this.getEm().persist(orderLine);
            LOG.info("create: ", orderLine);
            return orderLine;
        } else {
            LOG.info("update: ", orderLine);
            return this.getEm().merge(orderLine);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(OrderLine orderLine) {
        OrderLine oldOrderLine = findById(orderLine.getId());
        this.getEm().remove(oldOrderLine);
    }

    public EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("testDS");
        }
        return emf;
    }

    public EntityManager getEm() {
        if (em == null && null != getEmf()) {
            em = emf.createEntityManager();
        }
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}