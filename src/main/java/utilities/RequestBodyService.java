package utilities;

import com.jayway.jsonpath.DocumentContext;
import stepDefinitions.BaseSteps;

public class RequestBodyService extends BaseSteps{
    public void setRequestBodyForPostingNewPost(DocumentContext requestBody, String uId, String title, String body){
        requestBody.set("userId", uId);
        requestBody.set("title", title);
        requestBody.set("body", body);
    }

    public void setRequestBodyForPostingNewComment(DocumentContext requestBody, String postId, String name, String email, String body){
        requestBody.set("postId", postId);
        requestBody.set("name", name);
        requestBody.set("email", email);
        requestBody.set("body", body);
    }

}
