API Documentation

Package: api

Class: UserInputRegex

Overview
The UserInputRegex class provides functionality to work with user input as a regular expression pattern. It includes methods for creating a regex pattern from user input, checking if the pattern matches the beginning of a given string, and handling potential errors in regex pattern syntax.

---

Constructors
#### UserInputRegex(String userInput)

Description: Constructs a UserInputRegex object with the provided user input treated as a regex pattern.
Parameters:
userInput (String): The user input to be treated as a regex pattern.

---

Methods
#### matchesBeginning(String userString): boolean

Description: Checks if the regex pattern (created from user input) matches the beginning of the specified user string.
Parameters:
userString (String): The string to check for a match at the beginning.
Returns: 
true if a match is found at the beginning, false otherwise.

#### getUserInput(): String

Description: Retrieves the user input treated as a regex pattern.
Returns:
The user input as a regex pattern.

#### setUserInput(String userInput): void

Description: Updates the user input, treating it as a regex pattern.
Parameters:
userInput (String): The new user input to be treated as a regex pattern.

---

Notes
This class assumes that user input is intended to be treated as a literal string in regex patterns. The Pattern.quote method is used to ensure that special characters in the input are treated as literals.

Users should be aware of the limitations and capabilities of regular expressions when defining input patterns.
