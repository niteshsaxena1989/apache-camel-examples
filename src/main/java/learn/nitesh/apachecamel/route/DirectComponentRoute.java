package learn.nitesh.apachecamel.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class DirectComponentRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:sampleDirectInput")
                .log(LoggingLevel.DEBUG, "Received message is : ${body} and headers are : ${headers}")
                .to("file:sampleOutput?fileName=output.txt");
    }
}
