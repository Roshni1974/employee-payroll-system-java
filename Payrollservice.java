package src;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileWriter;


public class Payrollservice {
   private ArrayList<Employee> employees;
   public Payrollservice(){
    employees=new ArrayList<>();
    loadFromFile();
   }
   public void addemployee(Employee employee){
            if (findemployeeid(employee.getemployeeid()) != null) {
                     System.out.println("Employee ID already exists.");
                        return;
            }
                        
                          employees.add(employee);
                        System.out.println("Employee added successfully.");
   }



   public Employee findemployeeid(int id){
      for(int i=0;i<employees.size();i++){
         Employee employee=employees.get(i);
         if(employee.getemployeeid()==id){
            return employee;
         }
      }
      return null;

   }
  public void markattendance(int id){
    Employee employee = findemployeeid(id);

    if(employee == null){
        System.out.println("Employee not found");
        return;
    }

    if(employee.getattendence() >= 30){
        System.out.println("Attendance limit reached for this employee.");
        return;
    }

    int currentatte = employee.getattendence();
    employee.setattendence(currentatte + 1);
    System.out.println("Attendance marked for employee id: " + id);
}

   public double calculatesalary(int id){
      Employee employee=findemployeeid(id);
      if(employee!=null){
         double salaryperday=employee.getsalaryperday();
         int attendance=employee.getattendence();
         return salaryperday*attendance;
      }
      else{
         System.out.println("EMployee not found");
         return 0;
      }
   }

   public void loadFromFile() {

    try {
        BufferedReader br = new BufferedReader(new FileReader("src/employees.txt"));
        String line;

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);
            String name = data[1];
            double salaryPerDay = Double.parseDouble(data[2]);
            int attendance = Integer.parseInt(data[3]);

            Employee emp = new Employee(id, name, salaryPerDay, attendance);
            employees.add(emp);
        }

        br.close();
        System.out.println("Employees loaded from file.");

    } catch (Exception e) {
        System.out.println("employees.txt not found. Starting fresh.");
    }
}
public void saveToFile() {
    try {
        FileWriter fw = new FileWriter("src/employees.txt");

        for (Employee emp : employees) {
            fw.write(
                emp.getemployeeid() + "," +
                emp.getname() + "," +
                emp.getsalaryperday() + "," +
                emp.getattendence() + "\n"
            );
        }

        fw.close();
        System.out.println("Employees saved to file.");

    } catch (Exception e) {
        System.out.println("Error saving employees.");
    }
}

public void displayAllEmployees() {

    if (employees.isEmpty()) {
        System.out.println("No employees to display.");
        return;
    }

    System.out.println("\nID\tName\tSalary/Day\tAttendance");
    System.out.println("--------------------------------------");

    for (int i = 0; i < employees.size(); i++) {
        Employee emp = employees.get(i);

        System.out.println(
            emp.getemployeeid() + "\t" +
            emp.getname() + "\t" +
            emp.getsalaryperday() + "\t\t" +
            emp.getattendence()
        );
    }
}
public void displaySalaryReport(int id) {
    Employee emp = findemployeeid(id);

    if (emp == null) {
        System.out.println("Employee not found.");
        return;
    }

    double totalSalary = emp.getsalaryperday() * emp.getattendence();

    System.out.println("\n--- Salary Report ---");
    System.out.println("Employee ID   : " + emp.getemployeeid());
    System.out.println("Name          : " + emp.getname());
    System.out.println("Attendance    : " + emp.getattendence());
    System.out.println("Salary / Day  : " + emp.getsalaryperday());
    System.out.println("Total Salary  : " + totalSalary);
}

public void payrollSummary() {

    double totalPayout = 0;

    for (int i = 0; i < employees.size(); i++) {
        Employee emp = employees.get(i);
        totalPayout += emp.getsalaryperday() * emp.getattendence();
    }

    System.out.println("\n--- Company Payroll Summary ---");
    System.out.println("Total Employees : " + employees.size());
    System.out.println("Total Payout    : " + totalPayout);
}
public void updateEmployee(int id, String newName, double newSalary) {

    Employee emp = findemployeeid(id);

    if (emp == null) {
        System.out.println("Employee not found.");
        return;
    }

    if (newSalary <= 0) {
        System.out.println("Salary must be greater than zero.");
        return;
    }

    emp.setname(newName);
    emp.setsalaryperday(newSalary);

    System.out.println("Employee updated successfully.");
}
public void deleteEmployee(int id) {

    Employee emp = findemployeeid(id);

    if (emp == null) {
        System.out.println("Employee not found.");
        return;
    }

    employees.remove(emp);
    System.out.println("Employee deleted successfully.");
}






}
