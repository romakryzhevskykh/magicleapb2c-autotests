SARNOVA TEST AUTOMATION PROJECT

#project configuration:
1. create package /src/main/resources/META-INF (in .gitignore)
2. create properties files with project settings and credentials in META-INF package:
    1) META-INF/dev.properties
    2) META-INF/stage.properties 
    3) fill them with following params and own credentials for dev and stage environments:

      - hybris stage/dev credentials
          1. com.sarnova.backoffice.login.url=https://10.1.0.174:9002/backoffice/ `for example`
          2.
          3. com.sarnova.backoffice.admin.username=admin
          4. com.sarnova.backoffice.admin.password=nimda
          5. com.sarnova.backoffice.admin.cockpit.name=backoffice
          6. com.sarnova.backoffice.admin.cockpit.role=admin
    
      - storefront stage/dev credentials
          1. com.sarnova.storefront.base.url=https://10.1.0.174:9002/boundtree/en/USD/ `for example`
          2.
          3. com.sarnova.storefront.shopper.username=test.automation.regular.b2b.customer@sarnova.com
          4. com.sarnova.storefront.shopper.password=test.automation.regular.b2b.customer
          5. com.sarnova.storefront.shopper.cockpit.name=storefront
          6. com.sarnova.storefront.shopper.cockpit.role=shopper
          7.
          8. com.sarnova.storefront.guest.username=
          9. com.sarnova.storefront.guest.password=
          10. com.sarnova.storefront.guest.cockpit.name=storefront
          11. com.sarnova.storefront.guest.cockpit.role=guest
          
3. create properties file for Selenium grid server
    1) META-INF/selenium_grid.properties
    2) fill it with remote selenium server grid hub address
          1. hub.url=http://localhost:4444/wd/hub `for example`
          2. hub.url= `or leave it empty if grid server is not set`
          
4. in project pom.xml file find and set active/default environment profile `default.active.environment.profile`
      1. stage or
      2. dev
5. create ".gitignore" file and fill it with:
    .gitignore
    .idea/
    src/test/resources/META-INF
    target
    `etc.`


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
        - _mvn clean test site jetty:run -Dspring.profiles.active=environmentToUse