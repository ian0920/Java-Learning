public class Employee extends Worker {

    private long employeeId;
    private String hireDate;

    public Employee (String name, String birthDate,long employeeId, String hireDate){
        super(name, birthDate);
        this.hireDate = hireDate;
        this.employeeId = employeeId;

    }
}
