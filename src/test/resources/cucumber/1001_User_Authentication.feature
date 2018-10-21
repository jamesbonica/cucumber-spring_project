#Author: James S. Bonica
Feature: User Authentication
  Description: As a study administrator, I want OC to accept only valid login credentials from authorized users

  Scenario: OpenClinica shows an error message when a user enters invalid credentials
    When a user attempts to login using username "root"  with password "password"
    Then OC must return the error message
      """
      Your User Name and Password combination could not be found. Please try again. If you continue to have trouble, please click "Forgot Password" or contact the Administrator.
      """
