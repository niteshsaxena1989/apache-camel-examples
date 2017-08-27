package learn.nitesh.apachecamel.route;

import org.apache.camel.builder.RouteBuilder;

public class FileCopyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:data/inputNew?noop=true")
                .to("file:data/output");
    }
}
