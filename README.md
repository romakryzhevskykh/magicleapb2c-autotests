TEMPLATE TESTS AUTOMATION PROJECT

#project configuration:
1. create package /src/main/resources/META-INF (in .gitignore)
2. create properties files in META-INF package:
    1) META-INF/production.properties
    2) META-INF/stage.properties
with following params and own credentials for prod and stage environment:
    - hybris stage/prod credentials
      1. hybris.backoffice.url=http://projectname-stage.zaelab.com/backoffice
      2. hybris.backoffice.username=backofficestageuser
      3. hybris.backoffice.password=backofficestageuserpassword

    - site stage/prod credentials
      1. com.template.template.url=http://com.template.template-stage.com
      2. com.template.template.username=templateusername
      3. com.template.template.password=templatepassword

    - in project root file src/test/resources/test_xmls/tests.xml find and set environment `<parameter name="environment" value="%s"/>:`
      1. stage or
      2. production


#dependencies:
- download and set up Maven
- download and move geckodriver to /usr/bin/ (for Mac OS or configure path-es in Windows)
- download and move(unzip) chromedriver to /usr/bin/ (for Mac OS or configure path-es in Windows)
- pom.xml - file with plugins and dependencies

#for tests run:
- from commandline: _mvn clean test site jetty:run_
    1) clean - delete old compiled code and artifacts
    2) test - compile and run tests
    3) site - build report
    4) jetty:run - run a local web server so that you can view the report in the browser
- also you can run commands separately 
    1) _mvn clean test_  - clean and run 
    2) _mvn site_  - generate report
    3) _mvn jetty:run_  - run a local web server
- then you can open report in your browser by link "http://localhost:8080/"
- by default Spring will run stage profile with stage properties, to run other(f.e. production) profiles, use additional command:
    - -Dspring.profiles.active=production :
        - _mvn clean test site jetty:run -Dspring.profiles.active=environmentToUse_
    


