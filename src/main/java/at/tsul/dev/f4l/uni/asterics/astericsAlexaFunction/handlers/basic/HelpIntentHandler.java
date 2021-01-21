package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers.basic;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class HelpIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle (HandlerInput handlerInput) {
        return handlerInput.matches(Predicates.intentName("AMAZON.HelpIntent"));
    }
    @Override
    public Optional<Response> handle (HandlerInput handlerInput) {
        String say = "You can use the mouse, keyboard or open an application with the asterics integration. "//
                + "Commands which are possible now are:"//
                + "right click the mouse, type/enter new line on the keyboard"//
                + "or open the app notepad, text editor or steam on my computer.";
        return handlerInput.getResponseBuilder().withShouldEndSession(false).withSpeech(say).build();
    }
}
