package jp.co.test.gradle.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jp.co.test.gradle.model.User;

@Path("/sample")
public class SampleResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getSample() {
        return new User("test user", 10);
    }
}
