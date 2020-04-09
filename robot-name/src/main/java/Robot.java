import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Robot {

    private static List<String> existingNames;

    Robot() {
        existingNames = new ArrayList<>();
    }

    public String getName() {
        String newName = generateName();
        while(new RobotNameDuplicationChecker().exists(newName)){
            newName = generateName();
        }
        existingNames.add(newName);
        return newName;
    }

    public void reset() {

    }

    private String generateName(){
        return (RandomLetterGenerator.getLetter() +
                RandomLetterGenerator.getLetter() +
                RandomDigitGenerator.getDigit() +
                RandomDigitGenerator.getDigit() +
                RandomDigitGenerator.getDigit()).toUpperCase();
    }

    class RobotNameDuplicationChecker{

        public boolean exists(String name){
            return existingNames.contains(name);
        }
    }

}

class RandomLetterGenerator{

    public static char[] alphabet = new char[26];

    public static String getLetter() {
        for(int i = 0; i < 26; i++){
            alphabet[i] = (char) ('a' + i);
        }
        return Character.toString(alphabet[new Random().nextInt((25-0)+1)+0]);
    }
}

class RandomDigitGenerator{

    public static int getDigit() {
        return new Random().nextInt((9-0)+1)+0;
    }
}
