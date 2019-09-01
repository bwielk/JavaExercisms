import java.util.*;
import java.util.stream.IntStream;

class ProteinTranslator {

    Map<List<String>, String> dictionaryOfProteins = new HashMap<>();

    private String[] methionine = new String[]{"AUG"};
    private String[] phenylanine = {"UUU", "UUC"};
    private String[] leucine = {"UUA", "UUG"};
    private String[] serine = {"UCU", "UCC", "UCA", "UCG"};
    private String[] tyrosine = {"UAU", "UAC"};
    private String[] cysteine = {"UGU", "UGC"};
    private String[] tryptophan = {"UGG"};
    private String[] stop = {"UAA", "UAG", "UGA"};

    private void populateDictionaryOfProteins(){
        dictionaryOfProteins.put(Arrays.asList(methionine), "Methionine");
        dictionaryOfProteins.put(Arrays.asList(phenylanine), "Phenylalanine");
        dictionaryOfProteins.put(Arrays.asList(leucine), "Leucine");
        dictionaryOfProteins.put(Arrays.asList(serine), "Serine");
        dictionaryOfProteins.put(Arrays.asList(tyrosine), "Tyrosine");
        dictionaryOfProteins.put(Arrays.asList(cysteine), "Cysteine");
        dictionaryOfProteins.put(Arrays.asList(tryptophan), "Tryptophan");
        dictionaryOfProteins.put(Arrays.asList(stop), "STOP");
    }

    List<String> translate(String rnaSequence){
        if(rnaSequence.length()%3 != 0){
            throw new IllegalArgumentException("The length of the string needs to be dividable by 3");
        }
        List<String> results = new ArrayList<>();
        List<String> proteinsInRnaSequence = new ArrayList<>();
        for(int start=0; start<rnaSequence.length(); start+=3){
            int end = start + 3;
            proteinsInRnaSequence.add(rnaSequence.substring(start, end));
        }
        for(String stopElement : Arrays.asList(stop)){
            if(proteinsInRnaSequence.contains(stopElement)){
                int indexOfElementStop = proteinsInRnaSequence.indexOf(stopElement);
                proteinsInRnaSequence = proteinsInRnaSequence.subList(0, indexOfElementStop);
                break;
            }
        }
        populateDictionaryOfProteins();
        for(String rnaSeq : proteinsInRnaSequence){
            for(List<String> listOfProteins : dictionaryOfProteins.keySet()){
                if(listOfProteins.contains(rnaSeq)){
                    String result = dictionaryOfProteins.get(listOfProteins);
                    results.add(result);
                }
            }
        }
        return results;
    }
}