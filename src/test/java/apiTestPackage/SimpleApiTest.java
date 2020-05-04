package apiTestPackage;

import io.restassured.http.ContentType;
import org.junit.Test;

import javax.swing.text.AbstractDocument;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class SimpleApiTest {
//@Test
    public void apiTestForGetMethod(){
        given().contentType(ContentType.JSON).log().all().
                when().get("https://jsonplaceholder.typicode.com/users/3").
                then().statusCode(200).body("name", is("Clementine Bauch")).
                body("username", is ("Samantha")).
                body("address.street", is ("Douglas Extension")).log().all();
    }
    @Test
    public void apiTestForPostMethod(){
        HashMap<String, String> ContentOfPost = new HashMap<>();
        ContentOfPost.put(	"userId", "102");
        ContentOfPost.put(	"title", "I am a king");
        ContentOfPost.put(	"body", "This is to tell everybody that i am a king");

        given().contentType(ContentType.JSON).with().body(ContentOfPost).log().all().
                when().post("https://jsonplaceholder.typicode.com/posts ").
                then().statusCode(201).
                body( "title", is( "I am a king")).
                body("body", is( "This is to tell everybody that i am a king")).log().all();
    }
}
