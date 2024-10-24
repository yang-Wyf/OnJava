package testCode;

public class Person extends AbstractPerson{
    private String firstName;
    private String lastName;
    private int age;
    private int ID;

    @Override
    public int getId() {
        return 0;
    }
    @Override
    public void setId(int id) {
    }

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    @Override
    public void show() {
    }

    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}


}
