package src;

public class Employee {
    private int employeeid;
     private String name;
     private double salaryperday;
      private int attendence;

      

      public Employee(int employeeid, String name, double salaryperday, int attendence) {
    this.employeeid = employeeid;
    this.name = name;
    this.salaryperday = salaryperday;
    this.attendence = attendence;
}
     


         public Employee(int employeeid,String name,double salaryperday){
        this.employeeid=employeeid;
        this.name=name;
        this.salaryperday=salaryperday;
        this.attendence=0;
    }

      public int getemployeeid(){
        return employeeid;
      }
      public String getname(){
        return name;
      }
      public double getsalaryperday(){
        return salaryperday;
      }
      public int getattendence(){
        return attendence;
      }
      public void  setemployeeid(int employeeid){
        this.employeeid=employeeid;
      }

      public void setname(String name) {
        this.name = name;
    }

    public void setsalaryperday(double salaryperday) {
        this.salaryperday = salaryperday;
    }

    public void setattendence(int attendance) {
        this.attendence = attendance;
    }

 
}
