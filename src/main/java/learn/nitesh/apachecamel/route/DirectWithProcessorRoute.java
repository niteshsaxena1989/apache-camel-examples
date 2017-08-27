package learn.nitesh.apachecamel.route;

import learn.nitesh.apachecamel.processor.FileProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class DirectWithProcessorRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:testRoute")
                .log(LoggingLevel.DEBUG, "Body - \n ${body} \n Headers - ${headers}")
                .process(new FileProcessor())
                .to("file:data/output?fileName=outputNew.txt")
                .to("mock:output");
    }
}
