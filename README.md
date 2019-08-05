# E2E Openwethermap Scenarios

The main motive of this project is to Automate the E2E UI scenarios and API's using Selenium/BDD/Java framework. In this Example I have taken UI scenarios from https://openweathermap.org, API scenarios from https://openweathermap.org/current and Automated the GET operation. 

## Installation

Operating System:

`Ubuntu 18.04`

Editor:

`IntelliJ IDEA Version: 2019.2 : https://www.jetbrains.com/idea/download/#section=linux`

JDK:

`at least version 1.8.0_212`

Running test:

`Go to your project directory from terminal and hit following command and enjoy testing`

`mvn -Dtest=testrunner test`

Maven dependencies:

'<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.10.0</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>info.cukes</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>1.2.5</version>
    </dependency>
    <dependency>
        <groupId>info.cukes</groupId>
        <artifactId>cucumber-jvm-deps</artifactId>
        <version>1.0.5</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>info.cukes</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>1.2.5</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>com.vimalselvam</groupId>
        <artifactId>cucumber-extentsreport</artifactId>
        <version>3.0.2</version>
    </dependency>
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>3.1.2</version>
    </dependency>
        <dependency>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-install-plugin</artifactId>
            <version>2.4</version>
            <type>maven-plugin</type>
        </dependency>
        <dependency>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-deploy-plugin</artifactId>
            <version>2.7</version>
            <type>maven-plugin</type>
        </dependency>
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20180813</version>
        </dependency>
        </dependencies>`
        
## Report Generation

Report for the above execution gets generated in /target/cucumber-reports/report.html where you can see the web based report of the execution of the feature file.

## Usage example

- *.feature - All feature files under feature folder contain the different scenarios which we can perform for the perticular request.
- *.configs - All configuration files. Example : to store API end point urls.
- testrunner.java - Used to run all the feature files at once

## Meta

Your Name – @sanamulla - sanamulla2009@gmail.com
