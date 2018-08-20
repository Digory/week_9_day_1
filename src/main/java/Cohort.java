import java.util.*;

public class Cohort {
    private static ArrayList<Student> students = createStudentList();

    private static ArrayList createStudentList(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Digory"));
        students.add(new Student("Wigory"));
        students.add(new Student("Pigory"));
        students.add(new Student("Ligory"));
        students.add(new Student("Migory"));
        students.add(new Student("Qigory"));
        students.add(new Student("Zigory"));
        students.add(new Student("Kigory"));
        students.add(new Student("Jigory"));
        students.add(new Student("Gigory"));
        students.add(new Student("Figory"));
        students.add(new Student("Tigory"));
        students.add(new Student("Bigory"));
        students.add(new Student("Higory"));
        students.add(new Student("Rigory"));
        students.add(new Student("Sigory"));
        students.add(new Student("Vigory"));
        students.add(new Student("Yigory"));
        students.add(new Student("Xigory"));
        students.add(new Student("David Attenborough"));
        Collections.shuffle(students);
        return students;
    }

    public static ArrayList getAllStudents(){
        return students;
    }

    public static Student getOneStudent(){
        return students.get(new Random().nextInt(students.size()));
    }

    public static ArrayList getTwoStudents(){
        return getGroupOfThisSize(2);
    }

    public static ArrayList getGroupOfThisSize(int size){
        ArrayList<Student> allStudents = createStudentList();
        ArrayList<Student> results = new ArrayList<>();
        for(int i = 0; i < size; i++){
            results.add(allStudents.remove(0));
        }
        return results;
    }

    public static HashMap getAllPairs(){
        HashMap<String, ArrayList<Student>> results = new HashMap<>();
        ArrayList<Student> allStudents = createStudentList();
        int counter = 1;
        while(allStudents.size() >= 2){
            ArrayList<Student> singlePair = new ArrayList<>();
            singlePair.add(allStudents.remove(0));
            singlePair.add(allStudents.remove(0));
            results.put("a"+Integer.toString(counter), singlePair);
            counter++;
        }
        return results;
    }

    public static HashMap getAllGroupsOfThisSize(int size){
        HashMap<String, ArrayList<Student>> results = new HashMap<>();
        ArrayList<Student> allStudents = createStudentList();
        int counter = 1;
        while(allStudents.size() >= 2){
            ArrayList<Student> group = new ArrayList<>();
            for(int i = 0; i < size; i++){
                group.add(allStudents.remove(0));
            }
            results.put("group-"+Integer.toString(counter), group);
            counter++;
        };
        return results;
    }

}