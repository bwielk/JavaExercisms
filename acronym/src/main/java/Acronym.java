import java.util.stream.Stream;

class Acronym {

    private String[] phrase;

    Acronym(String phrase) {
       this.phrase = phrase.replaceAll("[^a-zA-Z0-9\\d\\s-:]", "").replace("-", " ").split(" ");
    }

    String get() {
        return Stream.of(this.phrase)
                .filter(word -> !word.equals(""))
                .map(word -> word.toUpperCase().substring(0,1))
                .reduce("", String::concat);
    }
}
