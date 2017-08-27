package learn.nitesh.apachecamel.route;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class ProcessorExampleRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new ProcessorExampleRoute();
    }

    @Test
    public void testProcessorExampleRoute() throws InterruptedException {
        Thread.sleep(5000);
        String expectedOutput = "This is file1\n" +
                "Nitesh ** Saxena\n" +
                "06 ** 08 ** 1989";
        File file = new File("data/output");

        System.out.println("Expected Value is => " + expectedOutput);

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedOutput);

        assertTrue(file.isDirectory());
        assertEquals(1, file.listFiles().length);
        assertMockEndpointsSatisfied();
    }
}
