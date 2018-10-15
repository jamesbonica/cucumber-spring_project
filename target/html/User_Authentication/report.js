$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/cucumber/user_authentication.feature");
formatter.feature({
  "name": "User Authentication",
  "description": "  Description: As a study administrator, I want OC to accept only valid login credentials from authorized users",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "OpenClinica shows an error message when a user enters invalid credentials",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "a user attempts to login using username \"root\"  with password \"password\"",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.a_user_attempts_to_login_using_username_with_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "OC must return the error message",
  "keyword": "Then ",
  "doc_string": {
    "value": "Your User Name and Password combination could not be found. Please try again. If you continue to have trouble, please click \"Forgot Password\" or contact the Administrator."
  }
});
formatter.embedding("image/png", "embedded0.png");
formatter.write("This is the end.....");
formatter.match({
  "location": "UserSteps.oc_must_return_the_error_message(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});