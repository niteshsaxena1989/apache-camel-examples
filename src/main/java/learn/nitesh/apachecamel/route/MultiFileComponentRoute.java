package learn.nitesh.apachecamel.route;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by nitesh on 19/8/17.
 */
public class MultiFileComponentRoute {

    public static void main(String[] args) {
        CamelContext camelContext = new DefaultCamelContext();
        try {
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:data/output");

                    /*from("file:data/inputNew?noop=true")
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:data/output");*/
                }
            });

            camelContext.start();

            Thread.sleep(5000);

            camelContext.stop();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
