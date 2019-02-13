# TEMPLATE TESTS AUTOMATION PROJECT

## Project configuration

1. create package `/src/main/resources/META-INF` (in `.gitignore`)

2. create properties files with project settings and credentials in `META-INF` package:
    1) `META-INF/dev.properties`
    2) `META-INF/stage.properties `
    3) fill them with following params and own credentials for prod and stage environment:
      - hybris stage/dev credentials:
      
           ```properties
           #for example
           com.tdsc.backoffice.login.url=http://projectname-stage.zaelab.com/backoffice
           com.tdsc.backoffice.username=
           com.tdsc.backoffice.password=
           ```
           
      - storefront stage/dev credentials:
      
           ```properties
           # for example
           com.tdsc.storefront.base.url=http://com.template.template-stage.com
           com.tdsc.storefront.username=
           com.tdsc.storefront.password=
           ``` 
            
3. create properties file for Selenium grid server
    1) `META-INF/selenium_grid.properties`
    2) fill it with remote selenium server grid hub address
    
        ```properties
        # for example
        hub.url=http://localhost:4444/wd/hub
        # or leave it empty if grid server is not set
        hub.url= 
        ```
          
4. in project `pom.xml` file find and set **active/default** environment profile `default.active.environment.profile`
      1. **stage** or
      2. **dev**
      
5. create `.gitignore` file and fill it with:

    ```.git
    .gitignore
    .idea/
    .target/
    src/test/resources/META-INF
    target
    etc.
    ```

## Dependencies

- download and set up Maven
- download and move **geckodriver** to `/usr/bin/` (for Mac OS or configure path-es in Windows)
- download and move(unzip) **hromedriver** to `/usr/bin/` (for Mac OS or configure path-es in Windows)
- `pom.xml` - file with plugins and dependencies

## For tests run

- from commandline: `mvn clean test site jetty:run`
    1) **clean** - delete old compiled code and artifacts
    2) **test** - compile and run tests
    3) **site** - build report
    4) **jetty:run** - run a local web server so that you can view the report in the browser
- also you can run commands separately 
    1) `mvn clean test`  - clean and run 
    2) `mvn site`  - generate report
    3) `mvn jetty:run`  - run a local web server
    4) `-Djetty.port=xxxx` - to run jetty on another(default 8080) port
- then you can open report in your browser by link [http://localhost:8080/](http://localhost:8080/)
- by default Spring will run stage profile with stage properties, to run other(f.e. production) profiles, use additional command - **`-Dspring.profiles.active=production`** :
	```bash
	mvn clean test site jetty:run -Dspring.profiles.active=environmentToUse
    ```
- To launch by tags:
    -Dcucumber.options="--tags @TagName"

## Run single scenario via Intellij IDEA
> Make sure that you removed all the old run configurations
1. Open `Run \ Debug` configuration window (`Run -> Edit Configurations...`)
2. Open `Defaults` configurations and open `Cucumber java` configuration
3. Fill the `Main class:` field with `com.tdsc.cucumber.runners.CucumberTestNGIdeaRunner`
4. Add new environment variable `spring.profiles.active=dev` (or whatever you want)
5. Save

Now you can run single scenario via context menu (right-click -> run)