package org.lparce.app.core.service;

import org.lparce.app.core.entity.Product;
import org.lparce.app.core.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    @Transactional
    public Product addProduct(Product product) {
        productRepository.persist(product);
        return product;
    }

    public List<Product> list() {
        return productRepository.listAll();
    }

    @Transactional
    public void delete(Long id) {
        productRepository.delete("id", id);
    }

    public List<Product> findByName(String name){
        //productRepository.find(name,na)
        return new ArrayList<>();
    }

}
