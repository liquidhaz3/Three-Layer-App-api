package org.example;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import org.example.controllers.CharacterController;
import org.example.controllers.PlanetsController;
import org.example.daos.PlanetsDao;
import org.example.service.PlanetsService;

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
        // TODO: application initialization
    }

    @Override
    public void run(final threelayerappConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new PlanetsController(new PlanetsService(new PlanetsDao())));
        environment.jersey().register(new CharacterController());
    }

}
