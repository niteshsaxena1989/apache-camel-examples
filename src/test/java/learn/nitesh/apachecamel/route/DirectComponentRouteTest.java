package learn.nitesh.apachecamel.route;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class DirectComponentRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DirectComponentRoute();
    }

    @Test
    public void testWhetherGivenTextExposedToFile() throws InterruptedException {
        template.sendBody("direct:sampleDirectInput", "Hello, Test message provided");

        File file = new File("sampleOutput");

        assertTrue(file.isDirectory());
    }
}
