package com.upgrade.steps_definitions;

import com.upgrade.POJO.LoginPOJO;
import com.upgrade.pages.LoginPage;
import org.json.simple.JSONObject;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class APITesting {

    @Test
    public void postRequest () {

           JSONObject obj = new JSONObject();
         obj.put("username","coding.challenge.login@upgrade.com");
         obj.put("password","On$3XcgsW#9q");

        Response response =
                given()
                        .contentType("application/json")
                        .header("x-cf-source-id","coding-challenge")
                        .header("x-cf-corr-id","230ea84a-7199-41c9-bf38-fff27e35970d")
                        .body(obj)
                        .post("https://credapi.credify.tech/api/brportorch/v2/login");

        LoginPOJO loginPOJO = response.body().as(LoginPOJO.class);
        System.out.println(loginPOJO.getLoansInReviewPOJO().getProductType());



        response.statusCode();
        response.prettyPrint();
        Assert.assertEquals(200,response.statusCode());
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
    }

    @Test
    public void postRequestUnauthorized() {

        JSONObject obj = new JSONObject();
        obj.put("username","coding.challenge.login.Unauthorized@upgrade.com");
        obj.put("password","On$3XcgsW#9q");

        Response response =
                given()
                        .contentType("application/json")
                        .header("x-cf-source-id","coding-challenge")
                        .header("x-cf-corr-id","230ea84a-7199-41c9-bf38-fff27e35970d")
                        .body(obj)
                        .post("https://credapi.credify.tech/api/brportorch/v2/login");


        response.statusCode();
        response.prettyPrint();
        Assert.assertEquals(401,response.statusCode());
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
    }


}

