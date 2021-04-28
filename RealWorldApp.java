import java.util.InputMismatchException;
import java.util.Scanner;

public class RealWorldApp 
{

    private String firstName, lastName;
    private String[] parentsNames;
    private int age;

    public RealWorldApp(String firstName, String lastName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFullName()
    {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public String printAllInfo()
    {
        return String.format("%s\n%s\n%s\n%d", this.firstName, this.lastName, this.getParents(), this.age);
    }

    public void setParentList(String[] parentList)
    {
        this.parentsNames = parentList;
    }

    public String getParents()
    {
        StringBuilder sb = new StringBuilder();
        for (String parent: this.parentsNames)
        {
            sb.append(parent + "\n");
        }
        return sb.toString();
    }

    public static void setParents(RealWorldApp person)
    {
        String[] parents = new String[2];
        int i = 0;
        while (true)
        {
            System.out.println("Please enter parent " + (i + 1));
            Scanner scan = new Scanner(System.in);
            try {
                parents[i] = scan.nextLine();
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Too many parents!");
                break;
            }
            i++;
        }
        person.setParentList(parents);
    }

    public static RealWorldApp createNewPerson()
    {
        System.out.println("Enter first name");
        Scanner scan1 = new Scanner(System.in);
        String firstName = scan1.nextLine();
        System.out.println("Enter last name");
        Scanner scan2 = new Scanner(System.in);
        String lastName = scan2.nextLine();
        System.out.println("Enter age");
        Scanner scan3 = new Scanner(System.in);
        int currentAge;
        try{
            currentAge = scan3.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You need to enter a number for the age value");
        } finally {
            currentAge = 0;
        }
        return new RealWorldApp(firstName, lastName, currentAge);
    }

    public static void main(String[] args)
    {
        RealWorldApp person = createNewPerson();
        setParents(person);
        System.out.println(person.printAllInfo());
    }
}
