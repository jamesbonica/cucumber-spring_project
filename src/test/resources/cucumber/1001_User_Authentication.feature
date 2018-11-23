#Author: James S. Bonica
Feature: 1001 User Authentication
  Description: As a study administrator, I want OC to accept only valid login credentials from authorized users

  @Initialize
  Scenario: Initialize host domain for testing
    Given there is a study that uses the following variables:
      | studyId       | studyName                            | studyOid   |
      | 02_Automation | Study 1002: User Authentication Test | S_02_AUTOM |

  @Scenario=test
  Scenario: Create Base State
    Given the OC Root User generates an API Key

  #   * the OC Root User creates a study via REST API
  #  * the OC Root User creates the following users via REST API
  #    | username | fName    | lName     | email         | study_name                           | role_name         | user_type               |
  #    | 01_ds1   | Donnie   | Smacko    | test@test.com | Study 1001: User Authentication Test | Data Specialist   | user                    |
  #    | 01_ds2   | Dora     | Satchmo   | test@test.com | Study 1001: User Authentication Test | Data Specialist   | user                    |
  #    | 01_dm1   | Dandy    | Mentallo  | test@test.com | Study 1001: User Authentication Test | Data Manager      | business administrator  |
  #    | 01_dep1  | Dingy    | Pantalone | test@test.com | Study 1001: User Authentication Test | Data Entry Person | business administrator  |
  #    | 01_sd1   | Symbiote | Didactic  | test@test.com | Study 1001: User Authentication Test | Study Director    | technical administrator |
 # @Scenario=1 
  @OC-1001
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
      
  # @Scenario=2
  @OC-1001 @End_Feature_File
  Scenario: OpenClinica shows an error message when a user enters invalid username
    When a user attempts to login using username "boot"  with password "password"
    Then OC must return the error message
      """
      Your User Name and Password combination could not be found. Please try again. If you continue to have trouble, please click "Forgot Password" or contact the Administrator.
      """
