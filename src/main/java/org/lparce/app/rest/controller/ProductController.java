package org.lparce.app.rest.controller;


import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.lparce.app.core.entity.Product;
import org.lparce.app.core.service.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/products")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Product")
public class ProductController {
    @Inject
    ProductService productService;

    @GET
    public List<Product> list() {
        return productService.list();
    }

    @POST
    @Transactional
    public Response add (@RequestBody Product product){
        if (product.id != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }
        productService.addProduct(product);
        return Response.ok(product).status(201).build();
    }

    @PUT
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        productService.delete(id);
    }

    @GET
    @Path("/search-name")
    public List<Product> searchByName(@QueryParam("name") String name){
        return productService.findByName(name);
    }
}
