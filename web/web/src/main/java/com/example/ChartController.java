package com.example;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ChartController {

    @RequestMapping(value="/chartData",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public String chart() {

        //String data_tmp="{\"type\": \"column\",\"dataPoints\": [{ \"x\": 10, \"y\": 10 }, { \"x\": 20, \"y\": 15}]}";
        String data_tmp="{\"charts\":[{\"type\": \"column\",\"dataPoints\": [{ \"x\": 10, \"y\": 10 }, { \"x\": 20, \"y\": 15}]},{\"type\": \"spline\",\"dataPoints\": [{ \"x\": 10, \"y\": 10 }, { \"x\": 20, \"y\": 15}]}]}";
       return data_tmp;
    }
    @RequestMapping(value = "/chartview",
            produces = MediaType.TEXT_HTML_VALUE,
            method = RequestMethod.GET)
    public String chartView()
    {
        return "chart";
    }
}
