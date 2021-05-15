package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "OK";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mappingGetV2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String userId){
        log.info("mapping Id: {}", userId);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orders}")
    public String mappingPaths(@PathVariable String userId, @PathVariable Long orders){
        log.info("mapping Id: {}", userId);
        log.info("mapping Id: {}", orders);
        return "ok";
    }

    @GetMapping(value = "/mapping-param", params = "mode-debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    @GetMapping(value = "/mapping-header", params = "mode-debug")
    public String mappingHeader(){
        log.info("mappingHeader");
        return "ok";
    }

    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsume(){
        log.info("mappingConsume");
        return "ok";
    }

    @PostMapping(value = "/mapping-produce", consumes = "text/html")
    public String mappingProduce(){
        log.info("mappingProduce");
        return "ok";
    }
}
