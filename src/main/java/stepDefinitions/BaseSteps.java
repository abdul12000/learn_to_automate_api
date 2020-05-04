package stepDefinitions;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseSteps {
    public String BaseURL;
    public String MakeAPost;
    public String MakeAComment;
    public String CreateAUser;
    public Headers headers;
    public Response response;
    private String endpointPath;
    DocumentContext requestBodyJson;
    String MakeAPostPayloadPath, MakeACommentPayloadPath;

    public BaseSteps(){
        BaseURL = "https://jsonplaceholder.typicode.com/";
        MakeAPost= BaseURL + "Posts/";
        MakeAComment = BaseURL + "comments/";
        CreateAUser = BaseURL + "users/";
        MakeAPostPayloadPath = "/templates/MakeAPostTemplate.json";
        MakeACommentPayloadPath = "/templates/MakeACommentTemplate.json";
    }

    public void setHeaders(Headers value){
       headers = null;
        headers = value;
    }
    public void setHeadersWithContentType(){
        Headers headers = new Headers(
                new Header("Content-Type", "application/json"));
            setHeaders(headers);
    }
    public void setHeadersWithNoContentType(){
        Headers headers = new Headers();

        setHeaders(headers);
    }

    public Response getMethodCall() {
        response = RestAssured.given().log().all().
                relaxedHTTPSValidation().headers(headers).
                when().get(getURL()).
                then().log().all().extract().response();
        return response;
    }

    public Response postMethodCall() {
        response = RestAssured.given().log().all().
                relaxedHTTPSValidation().headers(headers).
                body(requestBodyJson.jsonString()).
                when().post(getURL()).
                then().log().all().extract().response();
        return response;
    }
    protected URL getURL() {

        try {
            return new URL(endpointPath);
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }
    public void setEndpointPath(String endpointPath){
        this.endpointPath = endpointPath;
    }

    public Response getResponse(){
    return response;
    }

    public DocumentContext loadTheJsonTemplate(String path){
        requestBodyJson = JsonPath.parse(this.getClass().getResourceAsStream(path));
        return requestBodyJson;
    }

}
