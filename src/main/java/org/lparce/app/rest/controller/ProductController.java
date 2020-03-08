package org.lparce.app.rest.controller;


import org.lparce.app.core.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @GET
    public List<Product> list() {
        return Product.listAll();
    }

    @Transactional
    @POST
    public Product add (Product product){
        product.persist();
        return product;
    }
}
