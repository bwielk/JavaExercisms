class Acronym {

    private String[] phrase;

    Acronym(String phrase) {
       this.phrase = phrase.replaceAll("[^a-zA-Z0-9\\d\\s-:]", "").replace("-", " ").split(" ");
    }

    String get() {
        String acronym = "";
        for(int word=0; word<phrase.length; word++){
            if(!this.phrase[word].equals("")){
                acronym += this.phrase[word].toUpperCase().charAt(0);
            }
        }
        return acronym;
    }
}
