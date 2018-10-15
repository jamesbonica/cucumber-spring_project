$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/cucumber/is_it_friday_yet.feature");
formatter.feature({
  "name": "Is it Friday yet?",
  "description": "  Everybody wants to know when it\u0027s Friday",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Sunday isn\u0027t Friday",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "today is Sunday",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdefs.today_is_Sunday()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I ask whether it\u0027s Friday yet",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdefs.i_ask_whether_is_s_Friday_yet()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be told \"Nope\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefs.i_should_be_told(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Friday is Friday",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "today is Friday",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdefs.today_is_Friday()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I ask whether it\u0027s Friday yet",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdefs.i_ask_whether_is_s_Friday_yet()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be told \"TGIF\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefs.i_should_be_told(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/resources/cucumber/myFirstFeature.feature");
formatter.feature({
  "name": "This should work",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "When I do this it should work",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "this is the starting point",
  "keyword": "Given "
});
formatter.step({
  "name": "something happens",
  "keyword": "When "
});
formatter.step({
  "name": "this must happen",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "data"
      ]
    },
    {
      "cells": [
        "something"
      ]
    }
  ]
});
formatter.scenario({
  "name": "When I do this it should work",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "this is the starting point",
  "keyword": "Given "
});
formatter.match({
  "location": "MyFirstStepDefinition.this_is_the_starting_point()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "something happens",
  "keyword": "When "
});
formatter.match({
  "location": "MyFirstStepDefinition.something_happens()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "this must happen",
  "keyword": "Then "
});
formatter.match({
  "location": "MyFirstStepDefinition.this_must_happen()"
});
formatter.result({
  "status": "passed"
});
});