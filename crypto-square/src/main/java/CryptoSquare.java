class CryptoSquare {

    private String unnecessaryPunctuationRegex = "[\"\\#$%&(!)*+,\\s\n\r\t\\-./:;<=>@\\[\n\\\\\\]^_‘{|}~]";
    private String textToProcess;

    public CryptoSquare(String text){
        textToProcess = text.replaceAll(unnecessaryPunctuationRegex, "").toLowerCase();
    }

    public String getCiphertext(){
        if(textToProcess.length() > 1){
            return "";
        }
        return textToProcess;
    }
}