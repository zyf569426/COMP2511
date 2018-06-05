import java.time.LocalDate;

public class Manager extends Employee {
    private LocalDate hireDate;

    /**
     * Constructor for Manager objects.
     *
     * @param name     Name of the manager
     * @param salary   Salary of the manager
     * @param hireDate Date manager was hired.
     */
    public Manager(String name, int salary, LocalDate hireDate) {
        super(name, salary);
        this.hireDate = hireDate;
    }

    /**
     * This method gets the name of this manager.
     *
     * @return name of manager
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * This method gets the salary of this manager.
     *
     * @return salary of manager.
     */
    @Override
    public int getSalary() {
        return super.getSalary();
    }

    /**
     * This method gets the date this manager was hired.
     *
     * @return Date manager was hired.
     */
    public LocalDate getDate() {
        return hireDate;
    }

    /**
     * This method sets/updates the name of this manager.
     *
     * @param name Name of the manager.
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * This method sets/updates the salary of a manager.
     *
     * @param salary Salary of the manager.
     */
    @Override
    public void setSalary(int salary) {
        super.setSalary(salary);
    }

    /**
     * This method sets/updates the date this manager was hired.
     *
     * @param hireDate Date manager was hired.
     */
    public void setDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * This method determines whether a given Object is equal to this
     * Manager object based on name, salary and date of hire.
     *
     * @param o Object we are comparing this Manager to
     * @return true of false depending on equivalence between parameter
     *         Object and this Manager.
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Manager _o = (Manager)o;
        if (hireDate.equals(_o.getDate()))
            return true;
        return false;
    }

    /**
     * This method calculates a hash key for a Manager object based on
     * the name, salary and hire date of a manager.
     *
     * @return hash key.
     */
    @Override
    public int hashCode() {
        return super.hashCode() + 17 * hireDate.hashCode();
    }

    /**
     * This method returns the state of this Manager object.
     *
     * @return Information pertaining to manager in String format.
     */
    @Override
    public String toString() {
        return super.toString() + ", Hire date: " + hireDate;
    }

    /**
     * This method makes a deep copy of a Manager object. Since
     * the name is of String format we do not clone it.
     *
     * @return New Manager object.
     */
    @Override
    public Manager clone() {
        Manager clone = (Manager)super.clone();
        return clone;
    }

}
