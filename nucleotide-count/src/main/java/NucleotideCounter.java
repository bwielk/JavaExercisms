import java.util.*;

class NucleotideCounter{

    private String dna;
    private Map<Character, Integer> nucleotideCounter = new HashMap<>();

    public NucleotideCounter(String dna){
        this.nucleotideCounter.put('A', 0);
        this.nucleotideCounter.put('C', 0);
        this.nucleotideCounter.put('G', 0);
        this.nucleotideCounter.put('T', 0);
        if(isDnaValid(dna)){
            this.dna = dna;
        }

    }

    public Map<Character, Integer> nucleotideCounts(){
        for(int i=0; i<dna.length(); i++){
            Character currentChar = dna.charAt(i);
            if(nucleotideCounter.keySet().contains(currentChar)){
                nucleotideCounter.put(currentChar, nucleotideCounter.get(currentChar)+1);
            }else{
                nucleotideCounter.put(currentChar, 1);
            }
        }
        return nucleotideCounter;
    }

    private boolean isDnaValid(String dnaToCheck) {
        List<Character> acceptedNucleotides = new ArrayList<>(this.nucleotideCounter.keySet());
        for(int i=0; i<dnaToCheck.length(); i++){
            Character currentCharToCheck = dnaToCheck.charAt(i);
            if(!acceptedNucleotides.contains(currentCharToCheck)){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}