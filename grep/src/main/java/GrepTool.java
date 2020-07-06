import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class GrepTool {

    private List<String> availableFlags = new ArrayList<>();

    public GrepTool(){
        availableFlags.addAll(Arrays.asList("-n", "-i", "-v", "-l", "-x"));
    }

    public String grep(String word, List<String> flags, List<String> files){
        String result = "";
        if(!flags.isEmpty() && !availableFlags.containsAll(flags)){
            throw new IllegalArgumentException("One of the flags is incorrect. Please enter a correct flag");
        }
        for(String file : files){
            List<String> linesOfText = readFile(file);
            if(flags.isEmpty()){
                for(int i=0; i<linesOfText.size(); i++){
                    if(linesOfText.get(i).contains(word)){
                        if(!result.isEmpty()){
                            result+="\n";
                        }
                        result+= linesOfText.get(i);
                    }
                }
            }//line order
            if(flags.contains("-n")){
                for(int i=0; i<linesOfText.size(); i++){
                    if(linesOfText.get(i).contains(word)){
                        if(!result.isEmpty()){
                            result+="\n";
                        }
                        result+= String.format("%s:%s",i+1, linesOfText.get(i));
                    }
                }
            }//case insensitive
            if(flags.contains("-i")){
                for(int i=0; i<linesOfText.size(); i++){
                    if(linesOfText.get(i).toLowerCase().contains(word.toLowerCase())){
                        if(!result.isEmpty()){
                            result+="\n";
                        }
                        result+=linesOfText.get(i);
                    }
                }
            }//file name
            if(flags.contains("-l")){
                for(int i=0; i<linesOfText.size(); i++){
                    if(linesOfText.get(i).contains(word)){
                        result+=file;
                    }
                }
            }//exact word match
            if(flags.contains("-x")){
                for(int i=0; i<linesOfText.size(); i++){
                    if(linesOfText.get(i).equals(word)){
                        result+=linesOfText.get(i);
                    }
                }
            }//invert
            if(flags.contains("-v")){
                for(int i=0; i<linesOfText.size(); i++){
                    if(!linesOfText.get(i).contains(word)){
                        if(!result.isEmpty()){
                            result+="\n";
                        }
                        result+=linesOfText.get(i);
                    }
                }
            }
        }
        return result;
    }

    private List<String> readFile(String fileName){
        List<String> readFile = new ArrayList<>();
        try{
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                readFile.add(line);
            }
            fileReader.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return readFile;
    }

}
