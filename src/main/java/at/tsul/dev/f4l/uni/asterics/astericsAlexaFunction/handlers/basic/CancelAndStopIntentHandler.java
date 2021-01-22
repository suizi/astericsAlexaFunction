package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers.basic;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

/**
 * This class belongs to the basic {@link RequestHandler}s every Alexa skill must support.
 *
 * @author Thomas Sulzbacher
 * @author Lisa Fixl
 */
public class CancelAndStopIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle (HandlerInput handlerInput) {
        return handlerInput.matches(intentName("AMAZON.StopIntent").or(intentName("AMAZON.CancelIntent")));
    }

    @Override
    public Optional<Response> handle (HandlerInput handlerInput) {
        return handlerInput.getResponseBuilder().withSpeech("Thank you for using the asterics alexa skill. Good bye!").withShouldEndSession(true).build();
    }
}
