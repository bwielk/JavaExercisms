class ReverseString {

    String reverse(String inputString) {
        String result = "";
        char[] inputStringArray = inputString.toCharArray();
        for (int character = inputStringArray.length-1; character >= 0; character--) {
            result += inputStringArray[character];
        }
        return result;
    }
}