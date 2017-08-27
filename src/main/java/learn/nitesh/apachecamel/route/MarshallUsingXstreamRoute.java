package learn.nitesh.apachecamel.route;

import learn.nitesh.apachecamel.processor.MarshallUsingXstreamProcessor;
import org.apache.camel.builder.RouteBuilder;

public class MarshallUsingXstreamRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:csvInput")
                .to("log:?level=INFO&showBody=true")
                .process(new MarshallUsingXstreamProcessor())
                .marshal().xstream()
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }
}
