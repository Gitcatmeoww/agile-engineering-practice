package edu.berkeley;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/")
public class Resource {
    @GET
    @Path("/hello")
    public String hello() {
        return "Hello";
    }

    @GET
    @Path("/query")
    public QueryView query(@QueryParam("message") String message) {
        return new QueryView(message);
    }

    @POST
    @Path("/postbody")
    public String postBody(String message) {
        return "You posted " + message;
    }

    @POST
    @Path("/postparam")
    public String postParam(@FormParam("message") String message) {
        return "You posted " + message;
    }

    @GET
    @Path("/calculator")
    public CalculatorView getCalculator() {
        return new CalculatorView();
    }

    @POST
    @Path("/calculator")
    public String postCalculator(@FormParam("num1") String num1, @FormParam("num2") String num2) {
        int num1_int = Integer.parseInt(num1);
        int num2_int = Integer.parseInt(num2);
        int sum = num1_int + num2_int;
        return "The sum is " + sum;
    }
}