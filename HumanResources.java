import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HumanResources {
    static Scanner input = new Scanner(System.in);
    static int numChoice;
    static ArrayList<Employee> listE = new ArrayList<Employee>();
    static ArrayList<Manager> listM = new ArrayList<Manager>();
    static ArrayList<Department> listD = new ArrayList<Department>();


    public static void main(String[] args) {

//        Danh sách Deparment
        listD.add(new Department(28, "Business", 3));
        listD.add(new Department(10, "Project", 2));
        listD.add(new Department(2003, "Technical", 2));

//        Danh sach Employee
        listE.add(new Employee(1, "Manh", 18, 5, LocalDate.of(2021, 10, 21), listD.get(0), 0, 5));
        listE.add(new Employee(2, "Minh", 18, 4, LocalDate.of(2021, 8, 11), listD.get(1), 1, 4));
        listE.add(new Employee(3, "Hau", 18, 3, LocalDate.of(2021, 9, 1), listD.get(2), 2, 3));
        listE.add(new Employee(4, "Tung", 18, 3.5, LocalDate.of(2021, 5, 30), listD.get(0), 1, 4));

//        Danh sách Manager
        listM.add(new Manager(5, "Duong", 18, 6, LocalDate.of(2021, 10, 28), listD.get(0), 0, "Business Leader"));
        listM.add(new Manager(6, "Bom", 18, 5, LocalDate.of(2022, 10, 28), listD.get(1), 0, "Project Leader"));
        listM.add(new Manager(7, "Hong", 18, 4, LocalDate.of(2022, 1, 8), listD.get(2), 1, "Technical Leader"));

        begin();
        perform();

    }

    //    Phần mở đầu chương trình
    public static void begin() {
        System.out.println("Wellcome to Human Resources management program !!!!");
        System.out.println();
    }

    //    Xác định lựa chọn mà người dùng muốn làm
    public static int getChoice() {

        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
        System.out.println("2. Hiển thị các bộ phận trong công ty");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
        System.out.println("4. Thêm nhân viên mới vào công ty");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
        System.out.println("6. Hiển thị bảng lương của nhân viên  theo thứ tự tăng dần");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
        System.out.println("8. Thoát chương trình");

//        Kiểm tra số mà người dùng nhập có phù hợp hay không
        do {
            System.out.print("Hãy chọn việc muốn làm (Nhập số tương ứng để thực hiện việc muốn làm!): ");
            if (input.hasNextInt()) {
                numChoice = input.nextInt();
                System.out.println();
                if (numChoice > 8 || numChoice < 1) {
                    System.out.println("Hãy nhập số trong khoảng yêu cầu (1 - 8)!");
                } else {
                    return numChoice;
                }
            } else {
                System.out.println("Chỉ được phép nhập số!");
                input.next();
            }
        } while (true);
    }

    //    Thực hiện lựa chọn của người dùng
    public static void perform() {

        boolean checkLoopPerfrom = true;
        do {

            int choice = getChoice();

//     Hiển thị danh sách nhân viên hiện có trong công ti
            if (choice == 1) {
                for (int i = 0; i < listE.size(); i++) {
                    System.out.println((i + 1) + ".");
                    listE.get(i).displayInformation();
                    System.out.println();
                }
                for (int i = 0; i < listM.size(); i++) {
                    System.out.println((i + 1 + listE.size()) + ".");
                    listM.get(i).displayInformation();
                    System.out.println();
                }
            }
//        Hiển thị các bộ phận trong công ti
            else if (choice == 2) {
                for (int i = 0; i < listD.size(); i++) {
                    System.out.println((i + 1) + ".");
                    System.out.println(listD.get(i).toString());
                }
            }
//        Hiển thị nhân viên theo từng bộ phận
            else if (choice == 3) {
                int console = 0;
                boolean checkConsole = true;
                System.out.println("Hiển thị nhân viên theo bộ phân: ");
                System.out.println("1.Business");
                System.out.println("2.Project");
                System.out.println("3.Technical");
                do {
                    System.out.print("Nhap so thich hop de hien thi:  ");
                    if (input.hasNextInt()) {
                        console = input.nextInt();
                        if (console < 1 || console > 3) {
                            System.out.println("Hãy nhập số thích hợp(1 - 3)");
                        } else {
                            checkConsole = false;
                        }
                    } else {
                        System.out.println("Chỉ được phép nhập số!");
                        input.next();
                    }
                } while (checkConsole);

                for (Employee employee : listE) {
                    if (employee.getDepartment().equals(listD.get(console - 1))) {
                        employee.displayInformation();
                        System.out.println();
                    }
                }
                for (Manager manager : listM) {
                    if (manager.getDepartment().equals(listD.get(console - 1))) {
                        manager.displayInformation();
                        System.out.println();
                    }
                }

            }
//       Thêm nhân viên vào công ti
            else if (choice == 4) {
                int number;

//            Kiểm tra người dùng muốn thêm nhân viên gì
                System.out.println("1. Thêm nhân viên thông thường");
                System.out.println("2. Thêm nhân viên là cấp quản lý (có thêm chức vụ)");
                do {
                    System.out.print("Hãy chọn số thích hợp để thêm nhân viên: ");
                    if (input.hasNextInt()) {
                        number = input.nextInt();
                        System.out.println();
                        if (number < 1 || number > 2) {
                            System.out.println("Hãy nhập số trong khoảng yêu cầu (1 or 2)!");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Chỉ được phép nhập số!");
                        input.next();
                    }
                } while (true);


                System.out.println("Hãy điền thông tin  nhân viên");

//            Người dùng nhập id của nhân viên mới
                int id = 0;
                boolean checkId = true;
                do {
                    System.out.print("Id: ");
                    if (input.hasNextInt()) {
                        id = input.nextInt();
                        boolean check1 = false;
                        if (id <= 0) {
                            System.out.println("Id không hợp lệ(đi từ 1 trở đi!)");
                        } else {
                            for (Employee employee : listE) {
                                if (id == employee.getId()) {
                                    System.out.println("ID này đã tồn tại");
                                    check1 = true;
                                }
                            }
                            boolean check2 = false;
                            for (Manager manager : listM) {
                                if (id == manager.getId()) {
                                    System.out.println("ID này đã tồn tại");
                                    check2 = true;
                                }
                            }
                            if (!check1 && !check2) {
                                checkId = false;
                            }
                        }
                    } else {
                        System.out.println("Chỉ được phép nhập số!");
                        input.next();
                    }
                } while (checkId);

//            Người dùng nhập tên của nhân viên mới
                System.out.print("Name: ");
                input.nextLine();
                String name = input.nextLine();

//            Người dùng nhập tuổi của nhân viên mới
                int age = 0;
                boolean checkAge = true;
                do {
                    System.out.print("Age: ");
                    if (input.hasNextInt()) {
                        age = input.nextInt();
                        if (age < 0) {
                            System.out.println("Tuổi không âm!");
                        } else if (age > 70) {
                            System.out.println("Vượt quá tuổi lao động!");
                        } else {
                            checkAge = false;
                        }
                    } else {
                        System.out.println("Chỉ được phép nhập số!");
                        input.next();
                    }
                } while (checkAge);

//                Người dùng nhập hệ số lương  của nhân viên mới
                double payRate = 0;
                boolean checkPayRate = true;
                do {
                    System.out.print("Pay rate: ");
                    if (input.hasNextDouble()) {
                        payRate = input.nextDouble();
                        if (payRate < 0) {
                            System.out.println("Hệ số lương không am");
                        } else {
                            checkPayRate = false;
                        }
                    } else {
                        System.out.println("Chỉ được phép nhập số!");
                        input.next();
                    }
                } while (checkPayRate);

//                Người dùng nhập ngày bắt đầu vô làm của nhân viên mới
                String date = "";
                boolean checkDate = true;
                do {
                    System.out.print("Start date(dd/mm/yyyy): ");
                    if (input.hasNext()) {
                        date = input.next();
                        Pattern patternDate = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|20)\\d\\d)$");
                        if (patternDate.matcher(date).matches()) {
                            checkDate = false;
                        } else {
                            System.out.println("Start date co dang dd/mm/yyyy");
                        }
                    }
                } while (checkDate);
                LocalDate startDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

//                Người dùng chọn bộ phận mà nhân mới làm
                Department nameDeparment;
                int choiceNameDeparment = 0;
                boolean checkNameDeparment = true;
                System.out.println("Hãy chọn bộ phận của nhân viên");
                System.out.println("1.Business");
                System.out.println("2.Project");
                System.out.println("3.Technical");
                do {
                    System.out.print("Deparment: ");
                    if (input.hasNextInt()) {
                        choiceNameDeparment = input.nextInt();
                        if (choiceNameDeparment < 1 || choiceNameDeparment > 3) {
                            System.out.println("Hãy nhập số thích hợp(1 - 3)");
                        } else {
                            checkNameDeparment = false;
                        }
                    } else {
                        System.out.println("Chỉ được phép nhập số!");
                        input.next();
                    }
                } while (checkNameDeparment);
                if (choiceNameDeparment == 1) {
                    nameDeparment = listD.get(0);
                } else if (choiceNameDeparment == 2) {
                    nameDeparment = listD.get(1);
                } else {
                    nameDeparment = listD.get(2);
                }
                nameDeparment.setstaffNum(nameDeparment.getstaffNum() + 1);

//                Số ngày nghỉ phép của nhân viên
                int dayoff = 0;
                boolean checkDayOff = true;
                do {
                    System.out.print("Day off: ");
                    if (input.hasNextInt()) {
                        dayoff = input.nextInt();
                        if (dayoff < 0) {
                            System.out.println("Số ngày nghỉ không âm");
                        } else {
                            checkDayOff = false;
                        }
                    } else {
                        System.out.println("Chỉ được phép nhập số!");
                        input.next();
                    }
                } while (checkDayOff);

//          Thêm nhân viên thường
                if (number == 1) {
                    double overTime = 0;
                    boolean checkOverTime = true;
                    do {
                        System.out.print("Over time: ");
                        if (input.hasNextDouble()) {
                            overTime = input.nextDouble();
                            if (overTime < 0) {
                                System.out.println("Số gio lam them không âm");
                            } else {
                                checkOverTime = false;
                            }
                        } else {
                            System.out.println("Chỉ được phép nhập số!");
                            input.next();
                        }
                    } while (checkOverTime);

                    listE.add(new Employee(id, name, age, payRate, startDate, nameDeparment, dayoff, overTime));
                }

//            Thêm nhân viên cấp quản lý
                if (number == 2) {
                    String position;
                    boolean checkPosition = true;
                    int choicePosition = 0;
                    System.out.println("Chọn chức danh của Manager");
                    System.out.println("1.Business Leader");
                    System.out.println("2.Project Leader");
                    System.out.println("3.Technical Leader");
                    do {
                        System.out.print("Position: ");
                        if (input.hasNextInt()) {
                            choicePosition = input.nextInt();
                            if (choicePosition < 1 || choicePosition > 3) {
                                System.out.println("Hãy nhập số thích hợp(1 - 3)");
                            } else {
                                checkPosition = false;
                            }
                        } else {
                            System.out.println("Chỉ được phép nhập số!");
                            input.next();
                        }
                    } while (checkPosition);

                    if (choicePosition == 1) {
                        position = "Business Leader";
                    } else if (choicePosition == 2) {
                        position = "Project Leader";
                    } else {
                        position = "Technical Leader";
                    }

                    listM.add(new Manager(id, name, age, payRate, startDate, nameDeparment, dayoff, position));
                }

            }
//        Tìm nhân viên có trong danh sách công ti
            else if (choice == 5) {
                int numSearch;
                System.out.println("1. Tìm nhân viên theo tên");
                System.out.println("2. Tìm nhân viên theo mã nhân viên");
                do {
                    System.out.print("Hãy chọn số thích hợp để thêm nhân viên ");
                    if (input.hasNextInt()) {
                        numSearch = input.nextInt();
                        System.out.println();
                        if (numSearch < 1 || numSearch > 2) {
                            System.out.println("Hãy nhập số trong khoảng yêu cầu (1 - 2)!");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Chỉ được phép nhập số!");
                        input.next();
                    }
                } while (true);

//            Tìm nhân viên theo Id
                if (numSearch == 1) {
                    int idSearch;
                    boolean checkIdSearch = true;
                    do {
                        System.out.print("Hãy nhập Id: ");
                        if (input.hasNextInt()) {
                            idSearch = input.nextInt();
                            if (idSearch < 0) {
                                System.out.println("Id khong am");
                            } else {
                                System.out.println("Danh sach Employee");
                                boolean timkiem1 = false;
                                for (Employee employee : listE) {
                                    if (idSearch == employee.getId()) {
                                        employee.displayInformation();
                                        System.out.println();
                                        timkiem1 = true;
                                        break;
                                    }
                                }
                                if (!timkiem1) {
                                    System.out.println("Nhân viên có Id là " + idSearch + " không có trong dsnh sách Employee");
                                }
                                System.out.println();
                                System.out.println("Danh sach Manager");
                                boolean timkiem2 = false;
                                for (Manager manager : listM) {
                                    if (idSearch == manager.getId()) {
                                        manager.displayInformation();
                                        System.out.println();
                                        timkiem2 = true;
                                        break;
                                    }
                                }
                                if (!timkiem2) {
                                    System.out.println("Nhân viên có Id là " + idSearch + " không có trong danh sách  Manager");

                                }
                                checkIdSearch = false;
                            }
                        } else {
                            System.out.println("Chỉ được phép nhập số!");
                            input.next();
                        }
                    } while (checkIdSearch);
                }

//            Tìm nhân viên theo tên
                if (numSearch == 2) {
                    System.out.print("Hãy nhập tên mà bạn muốn tìm: ");
                    input.nextLine();
                    String nameSreach = input.nextLine().toLowerCase();

                    System.out.println("Danh sach Employee");
                    boolean kiemtra1 = false;
                    for (Employee employee : listE) {
                        if (employee.getName().toLowerCase().contains(nameSreach)) {
                            employee.displayInformation();
                            kiemtra1 = true;
                        }
                    }
                    if (!kiemtra1) {
                        System.out.println("Nhân viên có tên là " + nameSreach + " không có trong danh sách Employee");
                    }
                    System.out.println();
                    System.out.println("Danh sach Mannager");
                    boolean kiemtra2 = false;
                    for (Manager manager : listM) {
                        if (manager.getName().toLowerCase().contains(nameSreach)) {
                            manager.displayInformation();
                            kiemtra2 = true;
                        }
                    }
                    if (!kiemtra2) {
                        System.out.println("Nhân viên có tên là " + nameSreach + " không có trong danh sách Manager");
                    }

                }

            }
//        Sắp xep bảng lương của nhân viên theo thứ tự tăng dần
            else if (choice == 6) {
                System.out.println("danh sach Employee: ");
                ArrayList<Employee> list = new ArrayList<Employee>(listE);
                list.sort(Comparator.comparingDouble(Employee::calculateSalary));
                for (Employee employee : list) {
                    employee.displayInformation();
                    System.out.println();
                }

                System.out.println("danh sach Manager: ");
                ArrayList<Manager> list1 = new ArrayList<Manager>(listM);
                list1.sort(Comparator.comparingDouble(Manager::calculateSalary));
                for (Manager manager : list1) {
                    manager.displayInformation();
                    System.out.println();
                }
            }
//        Sắp xếp bảng lương của nhân viên theo thứ tự giảm dần
            else if (choice == 7) {
                System.out.println("danh sach Employee: ");
                ArrayList<Employee> list = new ArrayList<Employee>(listE);
                list.sort(Comparator.comparingDouble(Employee::calculateSalary).reversed());
                for (Employee employee : list) {
                    employee.displayInformation();
                    System.out.println();
                }

                System.out.println("danh sach Manager: ");
                ArrayList<Manager> list1 = new ArrayList<Manager>(listM);
                list1.sort(Comparator.comparingDouble(Manager::calculateSalary).reversed());
                for (Manager manager : list1) {
                    manager.displayInformation();
                    System.out.println();
                }
            }
//        Thoát chương trình
            else {
                System.out.println("Goodbye");
            }

//        Cho phép người dùng chạy tiếp chương trình nếu muốn
            System.out.print("Bạn muốn thực hiện tiếp chương trình không(y / n): ");
            String answer = input.next().toLowerCase();
            System.out.println();
            if (!answer.equals("y")) {
                checkLoopPerfrom = false;
            }
        } while (checkLoopPerfrom);

    }
}
