package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers.basic;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class FallbackIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle (HandlerInput handlerInput) {
        return handlerInput.matches(Predicates.intentName("AMAZON.FallbackIntent"));
    }
    @Override
    public Optional<Response> handle (HandlerInput handlerInput) {
        String say = "Sorry, I don't know that. You can try saying help!";
        return handlerInput.getResponseBuilder().withSpeech(say).withReprompt(say).build();
    }
}
