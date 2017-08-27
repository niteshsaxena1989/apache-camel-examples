package learn.nitesh.apachecamel.route;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class FileCopyRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FileCopyRoute();
    }

    @Test
    public void checkFileCopyRouteFilesCreatedOrNot () throws InterruptedException {
        Thread.sleep(5000);

        //check whether files has been transferred or not
        File file = new File("data/output");
        assertTrue(file.isDirectory());
        assertEquals(1, file.listFiles().length);
    }
}
