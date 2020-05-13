import java.util.*;
import java.util.stream.Collectors;

class School {

    private List<Pupil> roster;

    public School(){
        this.roster = new LinkedList<>();
    }

    public void add(String name, Integer grade){
        Pupil newPupil = new Pupil(name, grade);
        this.roster.add(newPupil);
    }

    public List<String> roster(){
        applyRosterSorting();
        List<String> rosterNames = this.roster.stream().map(Pupil::getName).collect(Collectors.toList());
        return rosterNames;
    }

    public List<String> grade(Integer grade){
        applyRosterSorting();
        List<String> results = this.roster.stream()
                .filter(x -> x.getGrade() == grade)
                .map(Pupil::getName)
                .collect(Collectors.toList());
        return results;
    }

    private void applyRosterSorting(){
        /**
         * If users don't have the same grades, compare by grades, otherwise by names
         */
        Collections.sort(this.roster, (p1, p2) -> (p1.getGrade() != p2.getGrade())
                ? Integer.compare(p1.getGrade(), p2.getGrade()) : p1.getName().compareTo(p2.getName()));
    }
}
