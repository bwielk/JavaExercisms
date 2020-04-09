class RunLengthEncoding{

    public String encode(String stringToEncode){
        StringBuilder result = new StringBuilder();
        if(stringToEncode.equals(result.toString())){
            return result.toString();
        }
        char currentChar = stringToEncode.charAt(0);
        int charCounter = 0;
        for(int i=0; i<stringToEncode.length(); i++){
            if(currentChar == stringToEncode.charAt(i)){
                charCounter++;
            }else{
                if(charCounter > 1){
                    result.append(charCounter);
                }
                result.append((currentChar));
                currentChar = stringToEncode.charAt(i);
                charCounter = 1;
            }
            //when looping ends, we need to do the latest processed encoding to the result string
            if(i == stringToEncode.length()-1){
                if(charCounter > 1){
                    result.append(charCounter);
                }
                result.append((currentChar));
            }
        }
        return result.toString();
    }

    public String decode(String stringToDecode){
        String result = "";
        String amountOfChars = "";
        if(stringToDecode.equals(result)){
            return result;
        }
        for(int i=0; i<stringToDecode.length(); i++){
            if(Character.isDigit(stringToDecode.charAt(i))){
                amountOfChars += stringToDecode.charAt(i);
            }else{
                if(amountOfChars.isEmpty()){
                    result += stringToDecode.charAt(i);
                }else{
                    //attach the char x times
                    for(int j=0; j<Integer.parseInt(amountOfChars); j++){
                        result += stringToDecode.charAt(i);
                    }
                }
                amountOfChars = "";
            }
        }
        return result;
    }
}