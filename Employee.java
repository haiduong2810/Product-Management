import java.time.LocalDate;

public class Employee extends Staff implements ICalculator {
    private double overtime;

    public Employee(int id, String name, int age, double payRate, LocalDate startDate, Department department, int dayOff, double overtime){
        super(id, name, age, payRate, startDate, department, dayOff );
        this.overtime = overtime;
    }

    public double getOvertime(){
        return overtime;
    }

    public void setOvertime(double overtime){
        this.overtime = overtime;
    }

    @Override
    public double calculateSalary(){
        return getpayRate() * 3000000 + overtime * 200000;
    }

    @Override
    public void displayInformation(){
        System.out.println("Id: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Pay rate: " + getpayRate());
        System.out.println("Start date: " + getStartDate());
        System.out.println("Department: " + getDepartment().getNameDepartment());
        System.out.println("Day off: " + getDayOff());
        System.out.println("Overtime: " + getOvertime());
        System.out.print("Calculate salary: " + String.format("%,.0f", calculateSalary()));
        System.out.println();
    }
}
