# Asterics Alexa Function

This project contains an Alexa skill implementation for AWS lambda hosting.

## Build

**Prerequisites**

- Apache Maven 3.6.3 
- Java version 11


**To build this project run:**

```
mvn clean install
```



The build process drops a file called `astericsAlexaFunction-1.0-SNAPSHOT-jar-with-dependencies` in the target subfolder.

This jar contains the whole function code and all used dependencies because AWS lambda requires all dependencies to be packed within one jar.

## Deploy

To deploy this code on AWS Lambda head to https://console.aws.amazon.com/lambda/ login to your account an create a new Lambda function from scratch.

On the configuration page, head to the section Function code, click on `Actions>Upload a zip or jar file` and upload the jar file created in the previous section. Alternatively you can create an Amazon S3 bucket and link that by using the second option available under `Actions`. For this head to https://s3.console.aws.amazon.com/s3. 

I generally recommend using the bucket approach as it's much smoother with the upload handling. The best option would be using the AWS command client and script your way through the jungle.

Next head back to the lambda function configuration and add an `Alexa Skills Kit` trigger to your function. For this you need your skill's ID which you find on the Alexa developer console.

For creating the Alexa skill itself please refer to the readme in the subfolder `alexa-skill-model`. 



## Logging

Any logging and monitoring can be done within the `Monitoring` section on the functions home page. I would recommend to view logs in the CloudWatch log-group-view.