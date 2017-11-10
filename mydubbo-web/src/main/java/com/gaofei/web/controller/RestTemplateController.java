package com.gaofei.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * restTemplate test 已经测试通过
 * Created by GaoQingming on 2017/9/12 0012.
 */
@Controller
@RequestMapping("rest")
public class RestTemplateController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("testRest")
    public String testRest() {
        /*      url:http://192.168.30.88:10000/dataservice/users
                prefix:/question-duration-distribution/class-subject-history
                params:MultiValueMap<String,String>
        URI targetURI = UriComponentsBuilder.fromUriString(url)
                .path(prefix)
                .queryParams(params)
                .build()
                .encode()
                .toUri();
        String result = restTemplate.getForObject(targetURI, String.class);
        */
        String url = "http://127.0.0.1:8081/gaofeiweb/controller/testRest?requestParam=hah";

        String result = restTemplate.getForObject(url, String.class);

        System.out.println("restTemplate return value is : " + result);
        return "index";
    }

}
