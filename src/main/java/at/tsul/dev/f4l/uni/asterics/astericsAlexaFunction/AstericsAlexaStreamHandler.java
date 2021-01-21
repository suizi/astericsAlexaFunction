package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers.ApplicationLaunchIntent;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers.KeyboardActionIntent;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers.MouseActionIntent;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers.basic.CancelAndStopIntentHandler;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers.basic.FallbackIntentHandler;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers.basic.HelpIntentHandler;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers.basic.LaunchRequestHandler;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers.basic.SessionEndedRequestHandler;
import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class AstericsAlexaStreamHandler extends SkillStreamHandler {

    private static Skill getSkill () {
        return Skills.standard() //
                .addRequestHandlers(
                        // standard ones
                        new LaunchRequestHandler(),//
                        new HelpIntentHandler(),//
                        new CancelAndStopIntentHandler(),//
                        new FallbackIntentHandler(),//
                        new SessionEndedRequestHandler(),//
                        // custom ones:
                        new ApplicationLaunchIntent(),//
                        new KeyboardActionIntent(),//
                        new MouseActionIntent())//
                .build();
    }

    public AstericsAlexaStreamHandler () {
        super(getSkill());
    }
}
