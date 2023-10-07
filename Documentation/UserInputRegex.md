# Class: UserInputRegex

## Overview
The UserInputRegex class provides functionality to work with user input as a regular expression pattern. It includes methods for returning the regex pattern from original word when creat the object, checking if the orginal word match the text. It supports user to trim the string and creat a regex pattern by user choice.

---

### Constructors: UserInputRegex(String userInput)

Description: Constructs a UserInputRegex object with the provided user input as orginal word.


### Methods
>##### justMatches(): Boolean

Description: Checks if the orginal word (created from user input) matches the text in which user want to search<br>
Returns: ture if find the orignal word in the text, vice versa.

>##### getUserInput(): String

Description: Retrieves the orginal word (user input).<br>
Returns: the orginal word

>##### setUserInput(String: newWord):  void

Description: Updates the original word <br>
Parameters: String<br>
Return: void

>##### createYourRegexPattern():  String

Description: Allows the user to create complex regular expressions based on their input for starting, middle, and ending substrings without creating the object. It ensures thatregular expression pattern of user input is constructed correctly.<br>

Return: A String that is built accordinly by your preference

>Example: String yourOwnRegex=UserInputRegexcreateYourRegexPattern();

<br>

>##### isRegexPatternValid(String: pattern) : Boolean

Description: Validating regex patterns before using them in your code to avoid runtime errors caused by invalid patterns.<br> 
Return: Boolean


>##### RemoveExtraSpaces(String input): String
Description: Removing extra spaces and tabs from the input string,so the user can use it for create the right regex pattern <br>
Return: String


>##### removeSpecialCharacters(String input): String
Description: removing special characters from the input string after resulting False by using `isRegexPatternValid(String: pattern)`, then the String can be used to crerate your own right regx pattern<br> 
Return: String
