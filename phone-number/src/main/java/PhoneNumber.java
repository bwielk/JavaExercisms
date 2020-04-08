/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PhoneNumber {

    private static String wrongLengthExceptionMessage = "incorrect number of digits";
    private static String moreThan11DigitsExceptionMessage = "more than 11 digits";
    private static String numberIs11DigitsButDoesNotStartWith1ExceptionMessage =
            "11 digits must start with 1";
    private static String illegalCharacterExceptionMessage =
            "letters not permitted";
    private static String illegalPunctuationExceptionMessage =
            "punctuations not permitted";
    private static String areaCodeStartsWithZeroExceptionMessage =
            "area code cannot start with zero";
    private static String areaCodeStartsWithOneExceptionMessage =
            "area code cannot start with one";
    private static String exchangeCodeStartsWithZeroExceptionMessage =
            "exchange code cannot start with zero";
    private static String exchangeCodeStartsWithOneExceptionMessage =
            "exchange code cannot start with one";

    private String phoneNumber;

    public PhoneNumber(String phoneNumber){
        if(!PhoneNumberChecker.checkHasNoLetters(phoneNumber)){
            throw new IllegalArgumentException(illegalCharacterExceptionMessage);
        }
        String phoneNumberToAssign = DigitExtractor.extractDigitsFromString(phoneNumber);
        if(phoneNumberToAssign.length() == 11 && phoneNumberToAssign.charAt(0) != '1'){
            throw new IllegalArgumentException(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);
        }
        if(phoneNumberToAssign.length() < 10){
            throw new IllegalArgumentException(wrongLengthExceptionMessage);
        }
        if(phoneNumberToAssign.length() > 11){
            throw new IllegalArgumentException(moreThan11DigitsExceptionMessage);
        }
        this.phoneNumber = phoneNumberToAssign;
    }

    public String getNumber(){
        String extractedDigits = DigitExtractor.extractDigitsFromString(this.phoneNumber);
        if(extractedDigits.length() == 11 && extractedDigits.charAt(0) == '1'){
            return extractedDigits.substring(1);
        }
        return String.join("", extractedDigits);
    }

}

class DigitExtractor{

    public static String extractDigitsFromString(String string){
        List<String> extractedDigits = Arrays.asList(string.split(""))
                .stream()
                .filter(x -> Character.isDigit(x.charAt(0)))
                .map(String::toString)
                .collect(Collectors.toList());
        return String.join("", extractedDigits);
    }
}

class PhoneNumberChecker{

    public static boolean checkHasNoLetters(String phoneNumber){
        for(int i = 0; i<phoneNumber.length(); i++){
            if(Character.isAlphabetic(phoneNumber.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
