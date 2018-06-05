import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        // Create Employee object
        Employee one = new Employee("Kane", 50000);
        System.out.println("Employee name:   " + one.getName());
        System.out.println("Employee salary: " + one.getSalary());
        System.out.println("Object class:    " + one.getClass());
        System.out.println(one);
        System.out.println();

        // Clone Employee object and change fields
        Employee two = one.clone();
        two.setName("Jinyi");
        two.setSalary(60000);
        System.out.println("Employee name:   " + two.getName());
        System.out.println("Employee salary: " + two.getSalary());
        System.out.println("Object class:    " + two.getClass());
        System.out.println(two);
        System.out.println();

        // Print fields of original object to show they didn't change
        System.out.println("Employee name:   " + one.getName());
        System.out.println("Employee salary: " + one.getSalary());
        System.out.println("Object class:    " + one.getClass());
        System.out.println(one);
        System.out.println();

        // Create a Manager object
        String pattern = "dd-MMM-yyyy";
        String hired = "03-Jun-1999";
        DateTimeFormatter form = DateTimeFormatter.ofPattern(pattern);
        LocalDate hireDate = LocalDate.parse(hired, form);
        Manager first = new Manager("Wanger", 75000, hireDate);

        System.out.println("Manager name:      " + first.getName());
        System.out.println("Manager salary:    " + first.getSalary());
        System.out.println("Manager hire date: " + first.getDate());
        System.out.println("Object class:      " + first.getClass());
        System.out.println(first);
        System.out.println();

        Employee man = first;
        System.out.println("Manager name:      " + man.getName());
        System.out.println("Manager salary:    " + man.getSalary());
        System.out.println("Object class:      " + man.getClass());
        System.out.println(man);
        System.out.println();

        // Test cloning
        Employee cloneA = new Employee("Chump", 60000);
        Employee cloneB = cloneA.clone();
        Manager manCloneA = new Manager("Chump", 60000, hireDate);
        Manager manCloneB = manCloneA.clone();

        if (cloneA.equals(cloneB))
            System.out.println("Word up homey");

        if (cloneA.equals(manCloneA))
            System.out.println("Word to the mutha");

        if (cloneA instanceof Manager)
            System.out.println("Employee is instanceof Manager");
        if (manCloneA instanceof Employee)
            System.out.println("Manager is instanceof Employee");

        if (cloneA.getName().equals(cloneB.getName()))
            System.out.println("Names match");
        if (cloneA.getName() == cloneB.getName())
            System.out.println("Names match 2");

        System.out.println();
        System.out.println("MangerA name:      " + manCloneA.getName());
        System.out.println("MangerA salary:    " + manCloneA.getSalary());
        System.out.println("MangerA hire date: " + manCloneA.getDate());

        System.out.println();
        System.out.println("MangerB name:      " + manCloneB.getName());
        System.out.println("MangerB salary:    " + manCloneB.getSalary());
        System.out.println("MangerB hire date: " + manCloneB.getDate());

        hired = "10-Jun-1999";
        form = DateTimeFormatter.ofPattern(pattern);
        hireDate = LocalDate.parse(hired, form);
        manCloneB.setName("Cunt");
        manCloneB.setSalary(10000);
        manCloneB.setDate(hireDate);

        hired = "10-Jun-2200";
        form = DateTimeFormatter.ofPattern(pattern);
        hireDate = LocalDate.parse(hired, form);
        manCloneA.setDate(hireDate);

        System.out.println();
        System.out.println("MangerA name:      " + manCloneA.getName());
        System.out.println("MangerA salary:    " + manCloneA.getSalary());
        System.out.println("MangerA hire date: " + manCloneA.getDate());

        System.out.println();
        System.out.println("MangerB name:      " + manCloneB.getName());
        System.out.println("MangerB salary:    " + manCloneB.getSalary());
        System.out.println("MangerB hire date: " + manCloneB.getDate());

    }
}
