#Author: margret.magnusdottir@utb.ecutbildning.se

@tag
Feature: Register a new user
  In order to use the Mailchimp service I want to register a new user

  @tag1
  Scenario Outline: Register a new user
    Given I have opened the website in my browser
    * I have entered an "<email>" address
    * I have also entered a "<user>" name 
    * I have also entered a "<password>" 
    When I press Sign up
    Then There should be a "<message>" on screen
    
    
    
   Examples: 
      |	email	|	username	| password	|  message    |
      |	email	|		name		|	password	| check mail  |
      |	email	|	sameName	|	password	|	user exists	|
      |	email	|	longName	| password	|	longNameFail|
      |	      |		name		|	password	|	noMailFail 	|
      
      
      
      

