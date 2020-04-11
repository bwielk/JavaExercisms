class Bob{

    public String hey(String yourSay){
        String unnecessaryPunctuationFree = yourSay.replaceAll(
                "[\"\\#$%&()*+,\n\r\t" +
                        "\\-./:;<=>@\\[\n" +
                        "\\\\\\]^_‘{|}~]", "")
                .replaceAll(" ", "")
                .trim();
        if(unnecessaryPunctuationFree.isEmpty()){
            return "Fine. Be that way!";
        }
        if(unnecessaryPunctuationFree.matches("[0-9]+")){//digits w/o q mark
            return "Whatever.";
        }
        if(unnecessaryPunctuationFree.charAt(unnecessaryPunctuationFree.length()-1) == '?'){
            if(!unnecessaryPunctuationFree.equals(unnecessaryPunctuationFree.toUpperCase())//uppercase with q mark
            || unnecessaryPunctuationFree.matches("[0-9]+\\?")//digits with a question mark at the end
            || (unnecessaryPunctuationFree.charAt(0) == '?' && unnecessaryPunctuationFree.length() == 1)){ //special chars (punctuation) cleared off at the very beginning
                return "Sure.";
            }else {
                return "Calm down, I know what I'm doing!";
            }
        }
        if(unnecessaryPunctuationFree.equals(unnecessaryPunctuationFree.toUpperCase())){
            return "Whoa, chill out!";
        }
        return "Whatever.";
    }
}