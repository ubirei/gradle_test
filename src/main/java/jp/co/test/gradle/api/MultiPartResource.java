package jp.co.test.gradle.api;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;

import jp.co.test.gradle.model.User;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

@Path("/form")
public class MultiPartResource {

    @POST
    @Path("part")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String post(@FormDataParam("part") String s) {
        return s;
    }

    @POST
    @Path("part-file-name")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String post(
            @FormDataParam("file") InputStream file,
            @FormDataParam("file") FormDataContentDisposition d) {
    	saveFile(file, d.getFileName());
    	
        return d.getFileName();
    }

    @POST
    @Path("xml-jaxb-part")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String post(
            @FormDataParam("string") String s,
            @FormDataParam("string") FormDataContentDisposition sd,
            @FormDataParam("bean") User u,
            @FormDataParam("bean") FormDataContentDisposition bd) {
        return s + ":" + sd.getFileName() + "," + u + ":" + bd.getFileName();
    }
    
	private void saveFile(InputStream file, String name) {
		try {
			/* Change directory path */
			java.nio.file.Path path = FileSystems.getDefault().getPath("/Users/ubirei/Downloads/new_" + name);
			/* Save InputStream as file */
			Files.copy(file, path);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
