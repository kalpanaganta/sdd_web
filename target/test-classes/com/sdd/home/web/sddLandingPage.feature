@featureId=SDDWEB @jiraid=SDD-01  @WebUI
Feature: SDD Home Page
  As a Shop Runner User
  I Should able to login into Shop Runner Home Page and Validate Same Day Delivery Header

  @acceptance @auto @jiraid=23456 @smoke
  Scenario Outline: Validate Same Day Delivery Landing Page
    Given User open's Google Chrome browser and enters "shoprunner.com"
    And User validate "SHOPRUNNER" header on landing page
    And User clicks on "Login" button on Landing Page
    And User validate "SHOPRUNNER" header on login page
    And User validate "Log in to ShopRunner to continue" text on login page
    And User enters "<Email>" and "<Password>"
    And User clicks on "Im Not Robot" check box
   And User clicks on "Log In" button
#    And User validate "Search Box" header on after login
#    And User clicks on "User Profile" button on home page
  # And User clicks on "Log Out" button to sign off

    Examples:
      | Email                          | Password |
      | shoprunner_sdd_poc@yopmail.com | Sddpoc@1 |


