package learn.nitesh.apachecamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        System.out.println("FileProcessor -> The body in exchange is - " + exchange.getIn().getBody(String.class));
        String oldData = exchange.getIn().getBody(String.class);

        System.out.println("Old Data => " + oldData);
        oldData = oldData.replaceAll("-", "**");

        System.out.println("New Data => " + oldData);
        exchange.getIn().setBody(oldData, String.class);
    }
}
