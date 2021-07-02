import java.util.Comparator;

public class NameComparator implements Comparator<Student>{  
    
    @Override//Compare by name.
    public int compare(Student st1, Student st2){
        //returns negative value if st2 is before st1, and positive if after.
        return st1.getName().compareTo(st2.getName());
    }  

}
   