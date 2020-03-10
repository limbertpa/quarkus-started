package org.lparce.app.core.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.lparce.app.core.entity.Product;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
}
