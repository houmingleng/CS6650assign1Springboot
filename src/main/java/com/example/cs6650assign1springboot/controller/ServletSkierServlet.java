package com.example.cs6650assign1springboot.controller;

import com.google.gson.Gson;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("springServlet")
public class ServletSkierServlet{
        private Gson gson = new Gson();
    public static class Message{
        String message;
        public Message(String msg) {
            message = msg;
        }
    }
    private Message outputMsg = new Message("hello");
    @PostMapping("/**")
    public String show(HttpServletRequest request,
                                    HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        String urlPath = request.getRequestURI();
      //  PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        // check we have a URL!
        if (urlPath == null || urlPath.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
         //   response.getWriter().write("missing paramterers");
            return request.getRequestURI();
        }

        String[] urlParts = urlPath.split("/");
        // and now validate url path and return the response status code
        // (and maybe also some value if input is valid)

        if (!isUrlValid(urlPath)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
          //  out.write(gson.toJson(outputMsg));
            response.setStatus(HttpServletResponse.SC_OK);
            // do any sophisticated processing with urlParts which contains all the url params
            // TODO: process url params in `urlParts`
         //   response.getWriter().write("It works!");
        }
        return request.getRequestURI()+"good";
    }
    private boolean isUrlValid(String urlPath) {
        // TODO: validate the request url path according to the API spec
        // urlPath  = "/1/seasons/2019/day/1/skier/123"
        // urlParts = [, 1, seasons, 2019, day, 1, skier, 123]
        if(urlPath == null || urlPath.isEmpty()) return false;
        return true;
    }
}

//
//@Controller
//@RestController@
//public class ServletSkierServlet {
//    private Gson gson = new Gson();
//    public static class Message{
//        String message;
//        public Message(String msg) {
//            message = msg;
//        }
//    }
//    private Message outputMsg = new Message("hello");
//
//
//    @RequestMapping(("/springServlet"))
//
//    public String recvProductInfo(
//                                      HttpServletRequest request,
//                                      HttpServletResponse response) throws IOException {
//
//        response.setContentType("text/plain");
//        String urlPath = request.getPathInfo();
//        PrintWriter out = response.getWriter();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        // check we have a URL!
//        if (urlPath == null || urlPath.isEmpty()) {
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//            response.getWriter().write("missing paramterers");
//            return"bad";
//        }
//
//        String[] urlParts = urlPath.split("/");
//        // and now validate url path and return the response status code
//        // (and maybe also some value if input is valid)
//
//        if (!isUrlValid(urlPath)) {
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//        } else {
//            out.write(gson.toJson(outputMsg));
//            response.setStatus(HttpServletResponse.SC_OK);
//            // do any sophisticated processing with urlParts which contains all the url params
//            // TODO: process url params in `urlParts`
//            response.getWriter().write("It works!");
//        }
//        return "good";
//    }
//    private boolean isUrlValid(String urlPath) {
//        // TODO: validate the request url path according to the API spec
//        // urlPath  = "/1/seasons/2019/day/1/skier/123"
//        // urlParts = [, 1, seasons, 2019, day, 1, skier, 123]
//        if(urlPath == null || urlPath.isEmpty()) return false;
//        return true;
//    }
//}
