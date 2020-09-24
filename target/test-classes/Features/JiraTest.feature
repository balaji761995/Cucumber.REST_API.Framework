Feature: JIRA Test

Scenario: Creating new JIRA issues 

Given Open the jira link and login with valid credentials to get session id
When Send the payload for creating issse with post request
Then Issue should be created successfully and response code is "200"

