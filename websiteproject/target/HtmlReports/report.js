$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/sign.feature");
formatter.feature({
  "name": "signin page Test",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Hooks"
    }
  ]
});
formatter.scenario({
  "name": "valid login input",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Hooks"
    },
    {
      "name": "@f1"
    }
  ]
});
formatter.step({
  "name": "open website",
  "keyword": "Given "
});
formatter.match({
  "location": "Cucumber.open_website()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter valid input",
  "keyword": "When "
});
formatter.match({
  "location": "Cucumber.enter_valid_input()"
});
formatter.result({
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: MicrosoftEdge\u003d126.0.2592.87)\nBuild info: version: \u00274.4.0\u0027, revision: \u0027e5c75ed026a\u0027\nSystem info: host: \u0027LTIN410084\u0027, ip: \u002710.219.97.210\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002715.0.2\u0027\nDriver info: org.openqa.selenium.edge.EdgeDriver\nCommand: [b1b848d4ed2017b87b519ebbec849690, clickElement {id\u003df.142BA6415018A401DF96C5C56CD50E3A.d.35B4B44D47163E7EE7E4E5442EF35F99.e.86}]\nCapabilities {acceptInsecureCerts: false, browserName: MicrosoftEdge, browserVersion: 126.0.2592.87, fedcm:accounts: true, ms:edgeOptions: {debuggerAddress: localhost:49735}, msedge: {msedgedriverVersion: 126.0.2592.87 (883b9421f9ba..., userDataDir: C:\\WINDOWS\\SystemTemp\\scope...}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: WINDOWS, proxy: Proxy(), se:cdp: ws://localhost:49735/devtoo..., se:cdpVersion: 126.0.2592.87, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nElement: [[EdgeDriver: MicrosoftEdge on WINDOWS (b1b848d4ed2017b87b519ebbec849690)] -\u003e class name: uiU-ZX]\nSession ID: b1b848d4ed2017b87b519ebbec849690\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:64)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:200)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:133)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:53)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:184)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.invokeExecute(DriverCommandExecutor.java:167)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:142)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:547)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:257)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:78)\r\n\tat pages.Signin.validsignin(Signin.java:56)\r\n\tat step.Cucumber.enter_valid_input(Cucumber.java:39)\r\n\tat ✽.enter valid input(features/sign.feature:7)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "When "
});
formatter.match({
  "location": "Cucumber.click_on_login_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "login happens",
  "keyword": "Then "
});
formatter.match({
  "location": "Cucumber.login_happens()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "close browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Cucumber.close_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});