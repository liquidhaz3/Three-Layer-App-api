package org.example;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import org.example.controllers.CharacterController;
import org.example.controllers.PlanetsController;
import org.example.controllers.ProductController;
import org.example.daos.CharactersDao;
import org.example.daos.PlanetsDao;
import org.example.daos.ProductDao;
import org.example.filters.CorsFilter;
import org.example.service.CharactersService;
import org.example.service.PlanetsService;
import org.example.service.ProductService;
import org.example.service.ProductServiceImpl;

public class threelayerappApplication extends Application<threelayerappConfiguration> {

    public static void main(final String[] args) throws Exception {
        new threelayerappApplication().run(args);
    }

    @Override
    public String getName() {
        return "threelayerapp";
    }

    @Override
    public void initialize(final Bootstrap<threelayerappConfiguration> bootstrap) {
        // Application initialization
    }

    @Override
    public void run(final threelayerappConfiguration configuration,
                    final Environment environment) {
        // Initialize DAOs
        ProductDao productDao = new ProductDao();
        PlanetsDao planetsDao = new PlanetsDao();
        CharactersDao charactersDao = new CharactersDao();

        // Initialize services
        ProductService productService = new ProductServiceImpl(productDao);
        PlanetsService planetsService = new PlanetsService(planetsDao);
        CharactersService charactersService = new CharactersService(charactersDao);

        // Register controllers
        environment.jersey().register(new PlanetsController(planetsService));
        environment.jersey().register(new CharacterController(charactersService));
        environment.jersey().register(new ProductController(productService));

        // Register CORS filter
        environment.servlets().addFilter("CorsFilter", CorsFilter.class)
                .addMappingForUrlPatterns(null, false, "/*");
    }
}
