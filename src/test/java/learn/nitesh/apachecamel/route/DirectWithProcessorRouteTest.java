package learn.nitesh.apachecamel.route;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class DirectWithProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DirectWithProcessorRoute();
    }

    @Test
    public void testDirectWithProcessorRoute() throws InterruptedException {
        String inputText = "This is file1\n" +
                "Nitesh - Saxena\n" +
                "06 - 08 - 1989";

        String output = (String) template.requestBody("direct:testRoute", inputText);

        String expectedOutput = "This is file1\n" +
                "Nitesh ** Saxena\n" +
                "06 ** 08 ** 1989";

        assertEquals(expectedOutput, output);

    }

    @Test
    public void testDirectWithProcessorRouteWithMock() throws InterruptedException {
        String inputText = "This is file1\n" +
                "Nitesh - Saxena\n" +
                "06 - 08 - 1989";

        String output = (String) template.requestBody("direct:testRoute", inputText);

        String expectedOutput = "This is file1\n" +
                "Nitesh ** Saxena\n" +
                "06 ** 08 ** 1989";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedOutput);

//        assertEquals(expectedOutput, output);
        assertMockEndpointsSatisfied();
    }
}
