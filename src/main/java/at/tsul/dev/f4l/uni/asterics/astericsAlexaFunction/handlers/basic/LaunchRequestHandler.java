package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers.basic;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

/**
 * This class belongs to the basic {@link RequestHandler}s every Alexa skill must support.
 *
 * @author Thomas Sulzbacher
 * @author Lisa Fixl
 */
public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle (HandlerInput handlerInput) {
        return handlerInput.matches(Predicates.requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle (HandlerInput handlerInput) {
        String say = "Welcome to the asterics alexa skill! For more information ask for help.";
        return handlerInput.getResponseBuilder()//
                .withShouldEndSession(false)//
                .withSpeech(say)//
                .withReprompt(say)//
                .build();
    }
}
