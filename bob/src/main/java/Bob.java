class Bob{

    public String hey(String yourSay){
        String unnecessaryPunctuationFree = yourSay.replaceAll(
                "[\"\\#$%&()*+,\n\r\t" +
                        "\\-./:;<=>@\\[\n" +
                        "\\\\\\]^_‘{|}~]", "")
                .trim();
        if(unnecessaryPunctuationFree.replaceAll(" ", "").isEmpty()){
            return "Fine. Be that way!";
        }
        if(unnecessaryPunctuationFree.equals(unnecessaryPunctuationFree.toUpperCase())
                && unnecessaryPunctuationFree.charAt(unnecessaryPunctuationFree.length()-1) == '?'){
            return "Calm down, I know what I'm doing!";
        }
        if(unnecessaryPunctuationFree.charAt(unnecessaryPunctuationFree.length()-1) == '?'){
            return "Sure.";
        }
        if(unnecessaryPunctuationFree.equals(unnecessaryPunctuationFree.toUpperCase())){
            return "Whoa, chill out!";
        }
        return "Whatever.";
    }
}