import java.time.LocalDate;

public abstract class Staff {
    private int id;
    private String name;
    private int age;
    private double payRate;
    private LocalDate startDate;
    private Department department;
    private int dayOff;

    public Staff(int id, String name, int age, double payRate, LocalDate startDate, Department department, int dayOff){
        this.id = id;
        this.name = name;
        this.age = age;
        this.payRate = payRate;
        this.startDate = startDate;
        this.department = department;
        this.dayOff = dayOff;
    }

    public int getId(){
        return id;
    }

//    public void setId(int id){
//        this.id = id;
//    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public double getpayRate(){
        return payRate;
    }

    public void setpayRate(double payRate){
        this.payRate = payRate;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    public int getDayOff(){
        return dayOff;
    }

    public void setDayOff(int dayOff){
        this.dayOff = dayOff;
    }

    public abstract void displayInformation();
}
