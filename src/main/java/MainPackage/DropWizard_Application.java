package MainPackage;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.concurrent.TimeUnit;

public class DropWizard_Application extends Application<ConfigClass> {



    public static void main(String[] args) throws Exception

    {


        new DropWizard_Application().run(args);



    }

    private static void startReport(Environment environment) {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(environment.metrics())
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.SECONDS);
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

        startReport(environment);



        final ResourceClass resourceClass = new ResourceClass(configClass.getTemplate(),configClass.getDefName());

       final MainPackage.HealthCheckClass healthCheckClass = new MainPackage.HealthCheckClass(configClass.getTemplate());
        environment.healthChecks().register("Template",healthCheckClass);
        environment.jersey().register(resourceClass);



    }

}
