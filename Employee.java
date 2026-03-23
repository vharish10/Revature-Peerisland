import java.util.*;

public class Employee {
    private int employeeId;
    private String employeeName;
    private double basicSalary;
    private double allowance;
    private float taxPercentage;

    public Employee(int employeeId,String employeeName,double basicSalary,double allowance,float taxPercentage){
        this.employeeId=employeeId;
        setEmployeeName(employeeName);
        setBasicSalary(basicSalary);
        this.allowance=allowance;
        setTaxPercentage(taxPercentage);
    }

    public int getEmployeeeID(){
        return employeeId;
    }

    public void setEmployeeName(String employeeName) {
        if(employeeName==null || employeeName.equals(" ")) {
            System.out.println("Enter some Name");
        }
        else{
            this.employeeName=employeeName;
        }
    }

    public String getEmployeeName(){
        return employeeName;
    }

    public void setBasicSalary(double basicSalary) {
        if(basicSalary<0){
            System.out.println("Enter valid Salary:");
        }
        else{
            this.basicSalary = basicSalary;
        }
    }

    public double getBasicSalary(){
        return basicSalary;
    }

    public void setTaxPercentage(float taxPercentage){
        if(taxPercentage<0 || taxPercentage>30){
            System.out.println("Enter valid Tax Percentage");
        }
        else{
            this.taxPercentage=taxPercentage;
        }
    }

    public float getTaxPercentage() {
        return taxPercentage;
    }

    public double grossSalary(){
        return getBasicSalary()+allowance;
    }

    public double taxAmount(){
        return grossSalary()*getTaxPercentage()/100;
    }

    public double netSalary(){
        return grossSalary()-taxAmount();
    }

    public void displaySalarySlip() {
        System.out.println("Employee ID: " + getEmployeeeID());
        System.out.println("Employee Name: " + getEmployeeName());
        System.out.println("Basic Salary: " + getBasicSalary());
        System.out.println("Allowance: " + allowance);
        System.out.println("Gross Salary: " + grossSalary());
        System.out.println("Tax Amount: " + taxAmount());
        System.out.println("Net Salary: " + netSalary());
    }
}
