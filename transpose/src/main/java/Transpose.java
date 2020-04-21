class Transpose{

    public String transpose(String input){
        String result = "";
        char[] splitInput = input.toCharArray();
        if(!input.contains("\n")){
            for(int c=0; c<input.length();c++){
                result+=splitInput[c];
                if(c<input.length()-1){
                    result+="\n";
                }
            }
        }
        return result;
    }
}
