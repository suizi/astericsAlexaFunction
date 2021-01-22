package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.core;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;

import java.util.concurrent.TimeUnit;

/**
 * This class offers configuration methods for {@link ResteasyClient}s.
 *
 * @author Thomas Sulzbacher
 * @author Lisa Fixl
 */
public class RestEasyProvider {

    /**
     * Constructs an {@link ResteasyClient} using the {@link ResteasyClientBuilder}.
     *
     * The readTimeout and connectTimeout has been set to 1000 milli seconds.
     *
     * To provide automatic payload parsing the {@link JacksonJsonProvider} has been registered.
     *
     * @return a configured {@link ResteasyClient}
     */
    public static ResteasyClient getClient () {
        return new ResteasyClientBuilderImpl()//
                .connectTimeout(1000, TimeUnit.MILLISECONDS)//
                .readTimeout(1000, TimeUnit.MILLISECONDS)//
                .register(JacksonJsonProvider.class)//
                .build();
    }

    /**
     * Constructs a proxy of the given JaxRS annotated interface and configures it with the target URL.
     *
     * @param client the configured {@link ResteasyClient} to create a proxy from
     * @param url the target URL (e.g. http://myMachine.com, http://someTunnel.ngrok.com)
     * @param endpointClass the JaxRS annotated interface defining the target endpoint
     * @param <T> the generic type of endpoint class
     * @return a configured Proxy, ready to use to perform HTTP requests
     */
    public static <T> T getProxy (ResteasyClient client, String url, Class<T> endpointClass) {
        return client.target(url).proxy(endpointClass);
    }
}
