API Documentation

Package: api-design-2023-jingwen-punam-shenghao

Class: UserInputRegex

Overview
The UserInputRegex class provides functionality to work with user input as a quoted regular expression pattern. It includes methods for creating a regex pattern from user input, checking if the pattern could be found in a given string, and handling potential errors in regex pattern syntax.

Helloworld is a Class with example of utilizing this API.

---

Constructors
#### UserInputRegex(String userInput)

Description: Constructs a UserInputRegex object with the provided user input treated as a quoted regex pattern.
Parameters:
    userInput (String): The user input to be treated as a quoted regex pattern.

---

Methods
#### matches(String userString): boolean

Description: Checks if the regex pattern (created from user input) could be found from a specified user input string. the input was quoted and will not accept any regex signs.
Parameters:
    userString (String): The string to check of any findings.
Returns: 
    true if the pattern matches any substring of the user's input, false otherwise.

#### getUserInput(): String

Description: Retrieves the quoted user input as a string.
Returns:
    The quoted version of user input.

#### setUserInput(String userInput): void

Description: Updates the user input, treated as a quoted regex pattern.
Parameters:
    userInput (String): The updated user input to be treated as a quoted regex pattern.

---

Notes
This class assumes that user input is intended to be treated as a literal string in regex patterns. The Pattern.quote method is used to ensure that special characters in the input are treated as literals.

Users should be aware of the limitations and capabilities of regular expressions when defining input patterns.
