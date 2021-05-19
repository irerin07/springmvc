package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @ResponseBody
    @RequestMapping("request-param-v2")
    public String requestParamV2(@RequestParam("username")String memberName,
                               @RequestParam("age")int memberAge) {
        log.info("username = {}, age = {}" ,memberName, memberAge);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-v3")
    public String requestParamV3(@RequestParam String memberName,
                                 @RequestParam int memberAge) {
        log.info("username = {}, age = {}" ,memberName, memberAge);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-v4")
    public String requestParamV4( String memberName,
                                  int memberAge) {
        log.info("username = {}, age = {}" ,memberName, memberAge);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String memberName,
                                 @RequestParam(required = false) int memberAge) {
        log.info("username = {}, age = {}" ,memberName, memberAge);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String memberName,
                                       @RequestParam(required = false, defaultValue = "-1") int memberAge) {
        log.info("username = {}, age = {}" ,memberName, memberAge);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        paramMap.get("username");
        log.info("username = {}, age = {}" ,paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        helloData.setUsername(helloData.getUsername());
        helloData.setAge(helloData.getAge());

        return "ok";
    }
}
