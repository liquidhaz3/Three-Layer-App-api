package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dtos.ProductDTO;
import org.example.models.Product;
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
    public Response createProduct(ProductDTO productDTO) {
        Product createdProduct = productService.createProduct(
                productDTO.getType(),
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getAttributes()
        );
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
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") int id, ProductDTO productDTO) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        product.setName(productDTO.getName());
        product.setAttributes(productDTO.getAttributes());
        productService.updateProduct(product);
        return Response.ok(product).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") int id) {
        productService.deleteProduct(id);
        return Response.ok().build();
    }
}