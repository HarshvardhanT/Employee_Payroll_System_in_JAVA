import java.util.*;
abstract class Employee {
    private String name;
    private int id;
    
    public Employee(String name, int id){
        this.name=name;
        this.id=id;
    }

    public String getname(){
        return name;
    }

    public int getid(){
        return id;
    }

    public abstract double calculatesalary();

    @Override
    public String toString(){
        return "Employee[name="+name+", id = "+id+ ", salary= "+calculatesalary()+"]";
    }   
}

class fulltimeemloyee extends Employee{   
    private double monthlysalary;
    
    public fulltimeemloyee(String name, int id, double monthlysalary){
        super(name, id);
        this.monthlysalary=monthlysalary;
    }

    @Override
    public double calculatesalary(){
        return monthlysalary;
    } 
}

class parttimeemployee extends Employee{
    private int hourswork;
    private double hourlyrate;

    public parttimeemployee(String name, int id, int hourswork, double hourlyrate){
        super(name, id);
        this.hourswork=hourswork;
        this.hourlyrate=hourlyrate;
    }
    @Override
    public double calculatesalary(){
        return hourlyrate*hourswork;
    }
}

class payrollsystem{
    private ArrayList<Employee> employeelist;

    public payrollsystem(){
        employeelist=new ArrayList<>();
    }
    public void addemployee(Employee employee){
        employeelist.add(employee);
    }

    public void removeemloyee(int id){
        Employee employeetoremove=null;
        for(Employee employee: employeelist){
            if (employee.getid()==id){
                employeetoremove=employee;
                break;
            }
        }
        if(employeetoremove!=null){
            employeelist.remove(employeetoremove);
        }
    }

    public void displayemployees(){
        for(Employee employee: employeelist){
            System.out.println(employee);
        }
    }
}

public class main {
    public static void main(String args[]){
        payrollsystem payroll=new payrollsystem();
        fulltimeemloyee emp1=new fulltimeemloyee("vikas", 1, 70000.0);
        parttimeemployee emp2=new parttimeemployee("alexa", 2, 40, 100);

        payroll.addemployee(emp1);
        payroll.addemployee(emp2);
        System.out.println("Initial Employee Details: ");
        payroll.displayemployees();
        System.out.println("Removing Employee: ");
        payroll.removeemloyee(2);
        System.out.println("Remaining Employee details: ");
        payroll.displayemployees();
    }
    
}
