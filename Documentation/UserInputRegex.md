# Class: UserInputRegex

## Overview
The UserInputRegex class provides functionality to work with user input as a regular expression pattern. It includes methods for returning the regex pattern from original word when creat the object, checking if the orginal word match the text. Moreover, you can creat a regex pattern by user choice.

---

### Constructors: UserInputRegex(String userInput)

Description: Constructs a UserInputRegex object with the provided user input as orginal word.


###Methods
>##### justMatches(): Boolean

Description: Checks if the orginal word (created from user input) matches the text in which user want to search
Returns: ture if find the orignal word in the text, vice versa.

>##### getUserInput(): String

Description: Retrieves the orginal word (user input).
Returns:
the orginal word

>##### setUserInput(String: newWord):  void

Description: Updates the original word 
Parameters: String
Return: void

>##### createYourRegexPattern():  String

Description: Allows the user to create complex regular expressions based on their input for starting, middle, and ending substrings without creating the object. It ensures thatregular expression pattern of user input is constructed correctly.   

Return: A String that is built accordinly by your preference

>Example: String yourOwnRegex=UserInputRegexcreateYourRegexPattern();

<br>

>##### isRegexPatternValid(String: pattern) : Boolean

Description: Validating regex patterns before using them in your code to avoid runtime errors caused by invalid patterns. 
Return: Boolean
