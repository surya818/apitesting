<b>
This Project aims to create a testing framework for RESTful APIs.
Code consists of reusable components that could be used to write tests. I used the framework to test openweather api.
</b>

<b>
Pre-requisites:
</b>
1. Java installed ans setup complete
2. maven installed, able to run (mvn -version) command

<b>Steps to run the tests:</b>
1. Clone the repository. (git clone git@github.com:surya818/apitesting.git)
2. cd apitesting
3. Run tests using Maven: (mvn test)

<b>Note</b>: If you're behind a corporate firewall, use the http_proxy with maven command as below.
mvn test -Dhttp.proxyHost=<proxy.xyz.com> -Dhttp.proxyPort=8080 -Dhttps.proxyHost=<proxy.xyz.com> -Dhttps.proxyPort=8080

<b>Technology/Tools used:</b>

1. Java - For Programming
2. sun-jersey - Library for REST API accessing functionality. We used the jersey-client as our API client.
3. simple-json - Library used to deal with json responses, in obtaining and parsing the api responses.
4. TestNG - Test framework

<b>Package information:</b>

1. framework: This package has code that accesses the API programatically and get the API responses
2. data: This package consists of code that transforms API response into Java objects like Maps and pojos
3. framework.utils: This package houses classes that provide additional utlities like Logging, handling properties etc.
4. pojos: This package has pojo classes
5. tests: Has TestNG tests that access the functionality of different classes from above and validate OpenWeather API Test scenarios.

<b>Additional Notes:</b>

a. None of the configuration is hard-coded in the code files. All the server related information is mantained inside a properties file
b. Test data is handled separately in the properties file

  
