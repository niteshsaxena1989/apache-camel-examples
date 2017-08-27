package learn.nitesh.apachecamel.processor;

import learn.nitesh.apachecamel.domain.Product;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MarshallUsingXstreamProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        String[] arr = body.split(",");
        Product product = new Product();
        product.setId(Long.parseLong(arr[0]));
        product.setName(arr[1]);
        product.setMfgDate(arr[2]);

        exchange.getIn().setBody(product, Product.class);
    }
}
