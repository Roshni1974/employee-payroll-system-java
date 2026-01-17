package src;
import java.util.Scanner;
public class Main {
    public static void main(String[] a){
        Payrollservice payroll = new Payrollservice();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("--------Employee payroll system----");
            System.out.println("1.Add employee");
            System.out.println("2.mark attteandence");
            System.out.println("3.calculate salary");
            System.out.println("4.display all employees");
            System.out.println("5.salary report");
            System.out.println("6.payroll summary");
            System.out.println("7.update employee");
            System.out.println("8.delete employee");
            System.out.println("9.exit");
            System.out.println("enter your choice");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("enter employee id: ");
                    int id=sc.nextInt();
                    System.out.println("enter employee name: ");
                    sc.nextLine();
                    String name=sc.nextLine();
                    System.out.println("enter salary per day: ");
                    double salaryperday=sc.nextDouble();
                    if (salaryperday <= 0) {
                        System.out.println("Salary must be greater than zero.");
                        break;
}
                    Employee emp=new Employee(id,name,salaryperday);
                    payroll.addemployee(emp);

                    break;
                case 2:
                    System.out.println("enter employee id to mark attendance");
                    int attid=sc.nextInt();
                    payroll.markattendance(attid);
                    break;
                case 3:
                    System.out.println("enter employee id to calculate salary:");
                    int salid=sc.nextInt();
                    double totalsalary=payroll.calculatesalary(salid);
                    System.out.println("total salary :"+ totalsalary);
                    break;
                case 4:
                    payroll.displayAllEmployees();
                    break;
                case 5:
                    System.out.println("Enter employee ID:");
                    int rid = sc.nextInt();
                    payroll.displaySalaryReport(rid);
                    break;
                case 6:
                    payroll.payrollSummary();
                    break;
                case 7:
                    System.out.println("Enter employee ID to update:");
                    int uid = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.println("Enter new name:");
                    String newName = sc.nextLine();

                    System.out.println("Enter new salary per day:");
                    double newSalary = sc.nextDouble();

                    payroll.updateEmployee(uid, newName, newSalary);
                    break;
                case 8:
                    System.out.println("Enter employee ID to delete:");
                    int did = sc.nextInt();
                    payroll.deleteEmployee(did);
                    break;
                case 9:
                    payroll.saveToFile();
                    System.out.println("exiting program....");
                    sc.close();
                    return;
                


                default:
                    System.out.print("INvalid choice.try again");
            }
        }

    }
    

}
