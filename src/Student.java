public class Student{

    //Default Constructor
    public Student(){
        this.name = "Not Entered";
        this.address = "Not Entered";
        this.GPA = 0.0;
    }
    //Parameterized Constructor
    public Student(String name, String address, double GPA){
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    //Variables defined by Assignment.
    private String name;
    private String address;
    private double GPA;

    //Getters
    public String getName(){return name;}
    public double getGPA(){return GPA;}
    public String getAddress(){return address;}

    //Setters
    public void setGPA(double GPA) {this.GPA = GPA;}
    public void setAddress(String address){this.address = address;}
    public void setName(String name) {this.name = name;}
    
    //Overrides toString for output to file.
    @Override
    public String toString() {
        return (getName() + ", " + getAddress() + ", " + getGPA() + "\n");
    }
}
