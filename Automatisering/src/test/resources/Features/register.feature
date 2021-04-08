#Author: margret.magnusdottir@utb.ecutbildning.se

@tag
Feature: Register a new user
  In order to use the Mailchimp service I want to register a new user

  @tag1
  Scenario Outline: Register a new user
    Given I have opened the website in my browser
    * I have entered an "<email>" address
    * I have also entered a "<username>" 
    * I have also entered a password 
    When I press Sign up
    Then There should be a "<result>" on screen
    
     
   Examples: 
      |	email		|	username	 |  result    																																						|
      |	email		|	randomName |	Check your email  																																		|
      |	email		|	commonName |	Another user with this username already exists. Maybe it's your evil twin. Spooky.		|
      |	email		|	longName	 |	Enter a value less than 100 characters long																						|
      |	noEmail |	randomName |	Please enter a value 																																	|
      
      
      
      

