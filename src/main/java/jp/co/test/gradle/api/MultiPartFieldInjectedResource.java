package jp.co.test.gradle.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import jp.co.test.gradle.model.User;

@Path("/form-field-injected")
public class MultiPartFieldInjectedResource {
    @FormDataParam("string") private String s;
    @FormDataParam("string") private FormDataContentDisposition sd;
    @FormDataParam("bean") private User u;
    @FormDataParam("bean") private FormDataContentDisposition bd;

    @POST
    @Path("xml-jaxb-part")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String post() {
        return s + ":" + sd.getFileName() + "," + u + ":" + bd.getFileName();
    }
}
