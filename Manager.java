import java.time.LocalDate;

public class Manager extends Staff implements ICalculator{
    private String position;

    public Manager(int id, String name, int age, double payRate, LocalDate startDate, Department department, int dayOff, String position){
        super(id, name, age, payRate, startDate, department, dayOff );
        this.position = position;
    }

    public String getposition(){
        return position;
    }

    public void setposition(String position){
        this.position = position;
    }

    @Override
    public double calculateSalary(){
        if(position.equals("Business Leader")){
            return getpayRate() * 5000000 + 8000000;
        } else if(position.equals("Project Leader")){
            return getpayRate() * 5000000 + 5000000;
        } else if(position.equals("Technical Leader")){
            return getpayRate() * 5000000 + 6000000;
        } else return 0;
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
        System.out.println("Position: " + position);
        System.out.print("Calculate salary: " + String.format("%,.0f", calculateSalary()));
        System.out.println();
    }
}
