* Selenium WebDriver(Java) test automation project for testing various Atlassian Jira features:\
  -- login\
  -- logout\
  -- browse projects / issues\
  -- create / edit issues\
  -- validate the Glass Documentation's content belongs to a given project
  
* Automated tests are based on previously written manual test cases (a few included in a separate folder)

* Project's main goal was:\
  -- use advanced testing techniques like Page Object Model with Page Factory and Ajax Element Locator Factory patterns\
  -- to separate Selenium methods and logic from the test cases\
  -- use "future-proof", stable locators (mostly xpath)\
  -- use several Data Driven Testing techniques in the test cases as data sources\
  -- create easy to understand test cases with clear assertations

* Overall test results:\
  -- number of tests: 41\
  -- tests passed: 29\
  -- tests failed: 12\
  -- running time: 19m40s
