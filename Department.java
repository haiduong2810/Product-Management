public class Department {
    private int idDepartment;
    private String nameDepartment;
    private  int staffNum;

    public Department(int idDepartment, String nameDepartment, int staffNum){
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
        this.staffNum = staffNum;
    }

    public int getIdDepartment(){
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public int getstaffNum() {
        return staffNum;
    }

    public void setstaffNum(int staffNum) {
        this.staffNum = staffNum;
    }

    public String toString(){
        return "ID Department: " + idDepartment + "\n" + "Name Department: " + nameDepartment + "\n" + "Number of staff: " + staffNum + "\n";
    }
}
