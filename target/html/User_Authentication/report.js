$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/cucumber/user_authentication.feature");
formatter.feature({
  "name": "User Authentication",
  "description": "  Description: As a study administrator, I want OC to accept only valid login credentials from authorized users",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Initialize host domain for testing",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Initialize"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "there is a study that uses the following variables:",
  "rows": [
    {
      "cells": [
        "studyName",
        "studyManager",
        "studyOid"
      ]
    },
    {
      "cells": [
        "Study 1001: User Authentication Test",
        "01_manager",
        "S_01_AUTOM"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "StudySteps.there_is_a_study_that_uses_the_following_variables(Study\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OpenClinica shows an error message when a user enters invalid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Scenario\u003d1"
    },
    {
      "name": "@OC-1001"
    }
  ]
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
formatter.write("This has been productive!!!!!!");
formatter.match({
  "location": "UserSteps.oc_must_return_the_error_message(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OC shows an error message when a user enters invalid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Scenario\u003d2"
    },
    {
      "name": "@OC-1001"
    }
  ]
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
formatter.embedding("image/png", "embedded1.png");
formatter.write("This has been productive!!!!!!");
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