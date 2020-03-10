package org.lparce.app.core.service;

import org.lparce.app.core.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Transactional
    public Product addProduct(Product product) {
        Product.persist(product);
        return product;
    }

    public List<Product> list() {
        return Product.listAll();
    }

    @Transactional
    public void delete(Long id) {
        Product.delete("id", id);
    }

}
