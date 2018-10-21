$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/cucumber/1001_User_Authentication.feature");
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
  "name": "Root user executes API",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Scenario\u003dtest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the OC root user retrieve the API Key via an API",
  "keyword": "* "
});
formatter.match({
  "location": "ApiSteps.the_OC_root_user_retrieve_her_API_Key_via_an_API()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});