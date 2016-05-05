package pocmetrics;

import ch.qos.logback.classic.Logger;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pocmetrics.pojo.Metric;

import java.io.IOException;

@Controller
public class ApplicationController {

    private ObjectMapper mapper = new ObjectMapper();
    private static final Logger metricsLogger = (Logger) LoggerFactory.getLogger("metrics");

    @RequestMapping("/")
    public String homePage(Model model) {
        return "homepage";
    }

    @RequestMapping("/list")
    public String listPage(Model model) {
        return "listpage";
    }

    @RequestMapping("/product")
    public String productPage(Model model) {
        return "productPage";
    }

    @RequestMapping(value = "/metrics", method = RequestMethod.POST)
    public @ResponseBody String metrics(@RequestParam("data") String data) throws IOException {
        Metric metric = mapper.readValue(data,Metric.class);
        metricsLogger.info(metric.getPathname() + ";" + metric.getDnsLookup()+ ";" + metric.getHandshake()+ ";"
                + metric.getTtfb()+ ";" + metric.getDownloadPage()+ ";" + metric.getRenderingProcess());
        return "You successfully uploaded ";
    }

}
