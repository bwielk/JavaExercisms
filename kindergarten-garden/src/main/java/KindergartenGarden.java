import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class KindergartenGarden {

    private String[] namesOfChildren = new String[] {"Alice", "Bob", "Charlie", "David",
            "Eve", "Fred", "Ginny", "Harriet",
            "Ileana", "Joseph", "Kincaid", "Larry"};
    private String garden;

    KindergartenGarden(String garden) {
        this.garden = garden;
    }

    List<Plant> getPlantsOfStudent(String student) {
        List<String> studentsAsList = Arrays.asList(this.namesOfChildren);
        List<Plant> plantsToReturn = new ArrayList<>();
        String studentToSearch = StringUtils.capitalize(student.toLowerCase());
        Integer indexOfAStudentInTheList = studentsAsList.indexOf(studentToSearch);

        if(!studentsAsList.contains(student)) {
            throw new IllegalArgumentException("The student does NOT exist. Please select an existing student's name");
        }
        //build the rows based on the garden text
        List<String> rows = Arrays.asList(this.garden.split("\n"));
        /**
         * The formula for searching the plants of the students is
         * firstPlantInARow = studentIndex*2
         * secondPlantInARow = firstPlantInARow+1
         */

        Integer indexOfFirstPlantInARow = indexOfAStudentInTheList*2;
        Integer indexOfTheSecondPlantInARow = indexOfFirstPlantInARow+1;

        for(String row : rows){
            plantsToReturn.add(Plant.getPlant(row.charAt(indexOfAStudentInTheList)));
            plantsToReturn.add(Plant.getPlant(row.charAt(indexOfTheSecondPlantInARow)));
        }
        return plantsToReturn;
    }
}
