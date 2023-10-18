# engine.EasyRegex API Documentation

## Introduction

This documentation provides an overview of the engine.EasyRegex API (`engine.EasyRegex`) and a separate section on using the API with a sample code (`sample.ApiUsageSample`).  
The `engine.EasyRegex` package provides a simple Java API for working with regular expressions in a user-friendly manner. It allows you to easily generate and use regular expressions with specified start, any, and end patterns. Moreover users can test the regex patter they created is valid or not in order to be used further.
The usage sample demonstrates how to apply the API for different matching scenarios.

## Class: engine.EasyRegex

### Constructors

#### `engine.EasyRegex()`

- Initializes an `engine.EasyRegex` object with empty start, any, and end patterns.

### Properties

#### `startWithStr`

- Type: `String`
- Description: Represents the starting pattern of the regular expression.

#### `endWithStr`

- Type: `String`
- Description: Represents the ending pattern of the regular expression.

#### `anyStr`

- Type: `String`
- Description: Represents the any pattern within the regular expression.

### Methods

#### `setStartWithStr(String startWithStr)`

- Description: Sets the starting pattern of the regular expression.

#### `setEndWithStr(String endWithStr)`

- Description: Sets the ending pattern of the regular expression.

#### `setAnyStr(String anyStr)`

- Description: Sets the any pattern within the regular expression.

#### `printCurrentRegex()`

- Description: Prints the generated regular expression based on the set patterns.

#### `matchAll(String inputString)`

- Parameters:
    - `inputString`: Type `String` - The input string to match against.
- Returns: Type `boolean` - `true` if the input string matches the complete regular expression, `false` otherwise.

#### `matchAnyIndex(String inputString)`

- Parameters:
    - `inputString`: Type `String` - The input string to match against.
- Returns: Type `List<Integer>` - A list of indices where any pattern matches within the input string.

#### `matchAnyRaw(String inputString)`

- Parameters:
    - `inputString`: Type `String` - The input string to match against.
- Returns: Type `List<Integer>` - A list of indices where any pattern matches within the input string without quoting (for the situation where the input is an regular expression) .

#### `isRegexPatternValid(String inputRegex)`

- Parameters:
    - `inputRegex`: Type `String` - The input regex pattern to test valid or not.
- Returns: Type `boolean` - Validating regex patterns before using them in your code to avoid runtime errors caused by invalid patterns.

#### `removeExtraSpaces(String inputString)`

- Parameters:
    - `inputString`: Type `String` - The input string for removing space.
- Returns: Type `String` - Removing extra spaces and tabs from the input string that user can use it for create the right regex pattern.

#### `removeSpecialCharacters(String inputString)`

- Parameters:
    - `inputString`: Type `String` - The input string for removing special caharacters.
- Returns: Type `String` - removing special characters from the input string after resulting False by using `isRegexPatternValid(String: pattern)` that the String can be used to crerate your own right regx pattern

#### `matchSubstringWithPrintPosition(String inputString, String regexStr)`

- Parameters:
    - `inputString`: Type `String` - Input String for matching the regex pattern.
    - `regexStr`: Type `String`- Regex to be matched.
- Description: functionality involves string processing, and pattern matching using regular expressions, which take `inputString` and `regexStr`, and return a starting and ending position of the substring.additionally, error handling is implemented for invalid regex inputs. 

### Internal Methods

These methods are used internally for regex pattern generation.

#### `generateRegexPattern()`

- Description: Generates the raw regular pattern string based on the set patterns.

#### `generateRegexPatternRaw()`

- Description: Generates a raw regex pattern based on the any pattern.

#### `generateRegexPatternForAny()`

- Description: Generates a regex pattern for the any pattern, quoting special characters.

#### `generateRegexPatternForAll()`

- Description: Generates a complete regex pattern based on the set start, any, and end patterns.

## API Usage Sample

This class demonstrates the usage of the engine.EasyRegex API for creating and applying regular expressions in Java.

For each demo, the generated regular expression is printed, and the matching results for "Match All," "Match Any," and "Match Any Raw" are displayed.

Feel free to modify the patterns and input strings for further testing.

### Running the Sample

Ensure you have the engine.EasyRegex class available in your project, and then execute the `main` method in the sample.ApiUsageSample class.

```java
public class sample.ApiUsageSample {
    public static void main(String[] args) {
        // ... (rest of the code)
    }
}