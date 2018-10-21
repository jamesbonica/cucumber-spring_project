#Author: James S. Bonica
Feature: User Authentication
  Description: As a study administrator, I want OC to accept only valid login credentials from authorized users

  @Initialize
  Scenario: Initialize host domain for testing
    Given there is a study that uses the following variables:
      | studyName                            | studyManager | studyOid   |
      | Study 1001: User Authentication Test | 01_manager   | S_01_AUTOM |

  @Scenario=test
  Scenario: Root user executes API
 #   Given the OC root user is initialized
    * the OC root user retrieve the API Key via an API
#    * the OC root user creates a study via an API

  @Scenario=1 @OC-1001
  Scenario Outline: OpenClinica shows an error message when a user enters invalid credentials
    When a user attempts to login using username "<username>"  with password "<password>"
    Then OC must return the error message
      """
      Your User Name and Password combination could not be found. Please try again. If you continue to have trouble, please click "Forgot Password" or contact the Administrator.
      """

    Examples: 
      | username | password |
      | root     | wrong    |
      |          | password |
