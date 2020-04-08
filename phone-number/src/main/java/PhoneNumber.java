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

    private String phoneNumber;

    public PhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getNumber(){
        List<String> extractedDigits = Arrays.asList(this.phoneNumber.split(""))
                .stream()
                .filter(x -> Character.isDigit(x.charAt(0)))
                .map(String::toString)
                .collect(Collectors.toList());
        return String.join("", extractedDigits);
    }

}
