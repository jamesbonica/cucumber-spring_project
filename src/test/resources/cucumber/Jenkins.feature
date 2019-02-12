#Author: jamesbonica@gmail.com

Feature: Demo Karate against Jenkins

Scenario: Verify that Jenkins is up and running

Given url 'http://jamesbonica.com/jenkins/api/json?pretty=true'
When method get
Then status 400
And match response.jobs[*].name contains ['AWS-XebiaLabs-demo']