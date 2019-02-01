#Author: James S. Bonica jamesbonica@gmail.com
@EURO_20_Free_Delivery
Feature: 1001 EURO 20 for Free Delivery
  Description: 
  						As a marketing manager
  						I want the system to offer free delivery on orders above EUR 20
  						So I can entice customers to order more

  #@Scenario=1
  @Under_EURO_20
  Scenario: System displays free delivery reminder when a shopper clicks to add an item under EURO 20 to cart
    Given a shopper searches for the "Frazetta Calendar" in the top search bar
    When a shopper adds the item to the shopping cart
    Then the system must display the following message:
      """
      Bestel nog voor € 6,01 extra aan artikelen en je bestelling wordt gratis verzonden. 
      """

  #@Scenario=2
  @Over_EURO_20 @End_Feature_File
  Scenario: System display a free delivery charge message when a shopper clicks to add over EURO 20 in merchandise to cart
    Given a shopper searches for the "Frazetta Calendar" in the top search bar
    * a shopper increases the quantity of the item to 3
    When a shopper adds the item to the shopping cart
    Then the system must display the following message:
      """
      Bestel nu en je bestelling wordt gratis verzonden!
      """
