import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PangramChecker {

    public boolean isPangram(String input) {
        List<String> alphabet = "abcdefghijklmnopqrstuvwxyz".chars().mapToObj(x -> Character.toString(x)).collect(Collectors.toList());
        List<String> charsInInput = Arrays.asList(input.toLowerCase().replace(" ", "").split(""));
        charsInInput = (charsInInput.stream().distinct().collect(Collectors.toList()).stream().filter(x -> alphabet.contains(x)).collect(Collectors.toList()));
        charsInInput.forEach(x -> {
            if(alphabet.contains(x)){
                alphabet.remove(x);
            }
        });
        return alphabet.isEmpty();
    }
}
