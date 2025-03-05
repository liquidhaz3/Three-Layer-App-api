package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.factories.ProductFactory;
import org.example.models.Product;
import org.example.models.Laptop;
import org.example.models.Desktop;
import org.example.models.Monitor;
import org.example.service.ProductService;

import java.util.List;

@Path("api/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @POST
    public Response createProduct(@QueryParam("type") String type, Product product) {
        Product createdProduct = ProductFactory.createProduct(
                type,
                product.getId(),
                product.getName()
        );
        productService.createProduct(createdProduct);
        return Response.status(Response.Status.CREATED).entity(createdProduct).build();
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") int id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(product).build();
    }

    @GET
    public Response getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return Response.ok(products).build();
    }

    @PUT
    public Response updateProduct(Product product) {
        productService.updateProduct(product);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") int id) {
        productService.deleteProduct(id);
        return Response.ok().build();
    }
}