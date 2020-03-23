import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class DnDCharacter {

    private int modifier;
    private int strength;
    private int ability;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int charisma;
    private int wisdom;
    private int hitpoints;

    public DnDCharacter(){
        this.constitution = generateValue();
        this.modifier = modifier(constitution);
        this.strength = generateValue();
        this.ability = generateValue();
        this.dexterity = generateValue();
        this.intelligence = generateValue();
        this.charisma = generateValue();
        this.wisdom = generateValue();
        this.hitpoints = 10 + modifier;
    }


    int ability() {
        System.out.println("ABILITY = " +ability);
        return ability;
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10)/2d);
    }

    int getStrength() {
        System.out.println("STRENGTH = " +strength);
        return strength;
    }

    int getDexterity() {
        System.out.println("DEXTERITY = " +dexterity);
        return dexterity;
    }

    int getConstitution() {
        System.out.println("CONSTITUTION = " +constitution);
        return constitution;
    }

    int getIntelligence() {
        System.out.println("INTELLIGENCE = " +intelligence);
        return intelligence;
    }

    int getWisdom() {
        System.out.println("WISDOM = " +wisdom);
        return wisdom;
    }

    int getCharisma() {
        System.out.println("CHARISMA = " +charisma);
        return charisma;
    }

    int getHitpoints() {
        System.out.println("INTELLIGENCE = " +hitpoints);
        return hitpoints;
    }

    private int generateValue(){
        List<Integer> dice = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i<4; i++){
            dice.add(1 + random.nextInt(6 - 1 + 1));
        }
        Collections.sort(dice);
        dice.remove(0);
        return dice.stream().mapToInt(x -> x).sum();
    }
}
