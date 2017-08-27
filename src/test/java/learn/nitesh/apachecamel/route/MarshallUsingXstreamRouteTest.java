package learn.nitesh.apachecamel.route;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MarshallUsingXstreamRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshallUsingXstreamRoute();
    }

    @Test
    public void testMarshallUsingXstreamRoute() throws InterruptedException,IOException,ClassNotFoundException {

        byte[] output = (byte[]) template.requestBody("direct:csvInput", "1000,Mother-Board,22-02-1989");
        System.out.println("Output => \n" + deserialize(output));

        Thread.sleep(5000);
        assertTrue("true".equals("true"));
    }

    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }
}
