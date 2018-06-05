
public class Employee implements Cloneable {
    private String name;
    private int salary;

    /**
     * This method is the constructor for Employee objects.
     *
     * @param name   Name we want to assign to this Employee object
     * @param salary Salary we want to assign to the Employee object.
     */
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    /*
     * This method returns the name of this Employee object.
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the salary of this Employee object.
     *
     * @return salary of employee.
     */
    public int getSalary() {
        return salary;
    }

    /**
     * This method sets/updates the name of this Employee object.
     *
     * @param name Name we wish to assign to this Employee object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method sets/updates the salary of this Employee object.
     *
     * @param salary Salary we wish to assign to the Employee object.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * This method determines whether an Object is equal to this
     * Employee.
     *
     * @param o Object we wish to compare to this Employee object
     * @return true or false whether the object parameter equals this
     *         employee.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Employee)) return false;

        Employee _o = (Employee)o;
        if (name.equals(_o.getName()) && _o.getSalary() == salary)
            return true;
        return false;
    }

    /**
     * This method overrides the default hashCode to depend on employee
     * name and salary.
     *
     * @return hash key.
     */
    @Override
    public int hashCode() {
        return 11 * name.hashCode() + 13 * new Double(salary).hashCode();
    }

    /**
     * This method returns the state of this Employee object.
     *
     * @return Information pertaining to employee.
     *
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Salary: " + salary + ", Class: " +
               getClass().getName();
    }

    /**
     * This method makes a deep copy of an Employee object.
     *
     * @return New Employee object.
     */
    @Override
    public Employee clone() {
        Employee clone = null;
        try {
            clone = (Employee)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
