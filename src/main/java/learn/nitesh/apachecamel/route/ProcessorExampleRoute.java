package learn.nitesh.apachecamel.route;

import learn.nitesh.apachecamel.processor.FileProcessor;
import org.apache.camel.builder.RouteBuilder;

public class ProcessorExampleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .log("Before Processor - File Body - ${body} and Headers - ${headers}")
                .process(new FileProcessor())
                .to("file:data/output?fileName=outputFile.txt")
                .to("mock:output");
    }
}
