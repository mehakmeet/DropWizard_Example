package MainPackage;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizard_Application extends Application<ConfigClass> {

    public static void main(String[] args) throws Exception

    {
        new DropWizard_Application().run(args);

    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<ConfigClass> bootstrap) {

    }

    @Override
    public void run(ConfigClass configClass, Environment environment){

        final ResourceClass resourceClass = new ResourceClass(configClass.getTemplate(),configClass.getDefName());

       final MainPackage.HealthCheckClass healthCheckClass = new MainPackage.HealthCheckClass(configClass.getTemplate());
        environment.healthChecks().register("Template",healthCheckClass);
        environment.jersey().register(resourceClass);



    }

}
