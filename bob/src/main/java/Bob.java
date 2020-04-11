class Bob{

    public String hey(String yourSay){
        if(yourSay.equals(yourSay.toUpperCase())){
            return "Whoa, chill out!";
        }
        if(yourSay.charAt(yourSay.length()-1) == '?'){
            return "Sure.";
        }
        return "Whatever.";
    }
}