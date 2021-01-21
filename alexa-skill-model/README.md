# Asterics Alexa Skill Model

This folder contains the Json representation of the Alexa Skill interaction model. This defines the different types and variants of interactions that are possible while talking to the Alexa skill.

Important: this only defines the interaction model for the Alexa Skill service, that then delegates the requests and their data to the linked service or function.

# Build

The json is pretty much everything you need to create the Alexa Skill.

Head to https://developer.amazon.com/alexa/, login, and create a new Skill. Choose `Custom` as Model, `provision your own` as hosting model and `start from scratch` on the next page.

In the `Build`-Section of your skill head to `CUSTOM>Interaction Model>JSON Editor` and paste the `alexa-skill-model-v1.0.json` content. This will create the Asterics interaction model. For details about this refer to the linked tutorial pages for creating Alexa skills.

Head to `CUSTOM>Invocation` and type a name of your choice into the field `skill invocation name` (eg. 'the asterics integration'). 

Head to `CUSTOM>Endpoint` and enter your AWS lambdas ARN into the `Default Region` field. Here you can also find your skill's ID needed for adding the lambdas trigger. Please refer to the README in the root folder of the project for lambda configuration and setup.

Important: For the whole interaction to work, both, the lambda function and the alexa skill have to be linked with each other.

## Debugging

You can use the `Utterance Profiler` for offline debugging your interaction model.

## Testing

You can test your alexa skill in two ways:

- Use a real physical Alexa linked to the same account you are using for developing this skill
- use the `Test` section in the Alexa developer console