#Author: James S. Bonica jamesbonica@gmail.com
@Get_Book_by_ISBN
Feature: 1003 Get Book by ISBN
  Description: 
  						As a Google User
  						I want to be able to include an ISBN in a REST API
  						So I can return the book title associated with the ISBN

  Scenario: User calls web service to get a book by its ISBN
    Given a book exists with the ISBN of "9781451648546"
    When a user executes a REST Call by ISBN
    Then the response must return a 200 status code
    And the response must include the following:
      | totalItems |             1 |
      | kind       | books#volumes |
    And the response must include in any order:
      | items.volumeInfo.title     | Steve Jobs         |
      | items.volumeInfo.publisher | Simon and Schuster |
      | items.volumeInfo.pageCount |                630 |
