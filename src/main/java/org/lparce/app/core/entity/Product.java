package org.lparce.app.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product extends PanacheEntity {

    public String name;
    public BigDecimal price;

    public static Product findByName(String name) {
        return find("name", name).firstResult();
    }

    public static List<Product> priceGte(BigDecimal price) {
        return find("price >= ?1", price).list();
    }
}
