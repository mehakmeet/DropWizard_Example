package MainPackage;

import MainPackage.RepresentationClass;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;




@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class ResourceClass {


    static final MetricRegistry metrics = new MetricRegistry();


    private final String template;
    private final String defName;
    private final AtomicLong counter;

    Meter requests = metrics.meter("requests");

    public ResourceClass(String template, String defName) {
        this.template = template;
        this.defName = defName;
        this.counter = new AtomicLong();
        requests.mark();
    }

    @GET
    @Timed
    public RepresentationClass sayHello(@QueryParam("name") Optional<String> name) {
        String value = null;
        if (name.isPresent()) {
            value = name.get();
        }
        System.out.println(template+" "+value);
        return new RepresentationClass(counter.incrementAndGet(), value);
    }
}
