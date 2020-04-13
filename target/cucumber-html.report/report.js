$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("invalidLogin.feature");
formatter.feature({
  "line": 2,
  "name": "Test Naukri with invalid credentials Login",
  "description": "",
  "id": "test-naukri-with-invalid-credentials-login",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@invalidLogin"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Test login with invalid credentials",
  "description": "",
  "id": "test-naukri-with-invalid-credentials-login;test-login-with-invalid-credentials",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "Open chrome and start application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "closing popUps and click login",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I enter Invalid \u003cusernameNumber\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user should not able to login",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "taking screenshot",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "application should be closed",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "test-naukri-with-invalid-credentials-login;test-login-with-invalid-credentials;",
  "rows": [
    {
      "cells": [
        "usernameNumber"
      ],
      "line": 13,
      "id": "test-naukri-with-invalid-credentials-login;test-login-with-invalid-credentials;;1"
    },
    {
      "cells": [
        "3"
      ],
      "line": 14,
      "id": "test-naukri-with-invalid-credentials-login;test-login-with-invalid-credentials;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "Test login with invalid credentials",
  "description": "",
  "id": "test-naukri-with-invalid-credentials-login;test-login-with-invalid-credentials;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@invalidLogin"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Open chrome and start application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "closing popUps and click login",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I enter Invalid 3",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user should not able to login",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "taking screenshot",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "application should be closed",
  "keyword": "Then "
});
formatter.match({
  "location": "ctsNaukriProjectStepDefinition.open_chrome_and_start_application()"
});
formatter.result({
  "duration": 14112764800,
  "status": "passed"
});
formatter.match({
  "location": "ctsNaukriProjectStepDefinition.closing_popUps_and_click_login()"
});
formatter.result({
  "duration": 8311266800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 16
    }
  ],
  "location": "ctsNaukriProjectStepDefinition.i_enter_Invalid(String)"
});
formatter.result({
  "duration": 302513400,
  "status": "passed"
});
formatter.match({
  "location": "ctsNaukriProjectStepDefinition.user_should_not_able_to_login()"
});
formatter.result({
  "duration": 73104500,
  "status": "passed"
});
formatter.match({
  "location": "ctsNaukriProjectStepDefinition.taking_screenshot()"
});
formatter.result({
  "duration": 482101100,
  "status": "passed"
});
formatter.match({
  "location": "ctsNaukriProjectStepDefinition.application_should_be_closed()"
});
formatter.result({
  "duration": 1060197900,
  "status": "passed"
});
});