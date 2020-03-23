import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class DnDCharacter {

    int ability() {
        return generateValue();
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10)/2d);
    }

    int getStrength() {
        return generateValue();
    }

    int getDexterity() {
        return generateValue();
    }

    int getConstitution() {
        return generateValue();
    }

    int getIntelligence() {
        return generateValue();
    }

    int getWisdom() {
        return generateValue();
    }

    int getCharisma() {
        return generateValue();
    }

    int getHitpoints() {
        return generateValue();
    }

    private int generateValue(){
        List<Integer> dice = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i<4; i++){
            dice.add(1 + random.nextInt(7 - 1 + 1));
        }
        Collections.sort(dice);
        dice.remove(0);
        return dice.stream().mapToInt(x -> x).sum();
    }
}
