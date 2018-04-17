package jp.co.test.gradle.api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        super(MultiPartResource.class, MultiPartFieldInjectedResource.class, MultiPartFeature.class, SampleResource.class);
    }
}
