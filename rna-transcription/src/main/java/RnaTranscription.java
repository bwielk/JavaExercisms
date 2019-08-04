class RnaTranscription {

    String transcribe(String dnaStrand) {
        String[] proteins = dnaStrand.toUpperCase().split("");
        String result = "";
        for(int p=0; p<proteins.length; p++){
            switch (proteins[p]){
                case "G" :
                    result += "C";
                    break;
                case "C" :
                    result += "G";
                    break;
                case "T" :
                    result += "A";
                    break;
                case "A" :
                    result += "U";
                    break;
            }
        }
        return result;
    }
}
