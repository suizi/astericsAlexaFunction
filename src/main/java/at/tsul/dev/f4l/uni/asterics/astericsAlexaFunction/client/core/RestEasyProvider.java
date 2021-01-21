package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.core;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;

import java.util.concurrent.TimeUnit;

public class RestEasyProvider {

    public static ResteasyClient getClient () {
        return new ResteasyClientBuilderImpl()//
                .connectTimeout(1000, TimeUnit.MILLISECONDS)//
                .readTimeout(1000, TimeUnit.MILLISECONDS)//
                .register(JacksonJsonProvider.class)//
                .build();
    }

    public static <T> T getProxy (ResteasyClient client, String url, Class<T> endpointClass) {
        return client.target(url).proxy(endpointClass);
    }
}
