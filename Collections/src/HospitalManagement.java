import java.util.*;

public class HospitalManagement {
    public static void main(String[] args){
        List<String> names=new ArrayList<>();
        names.add("Harish");
        names.add("Aashwik");
        names.add("Abhishek");
        names.add("Grsh");
        names.add("Giri");
        names.add("kavinya");
        names.add("Abhishek");

        System.out.println("Patients:"+names);
        names.add(1,"Harsh");
        System.out.println("Appointments after emergency"+names);
        System.out.println("Updating appointments:"+names.set(2,"Ashish"));
        System.out.println("Removing a cancelled Appointment:"+names.remove(7));

        System.out.println("Is Grsh Appointment Scheduled Today:"+names.contains("Grsh"));
        System.out.println("Total Appointments:"+names.size());
        System.out.println("First Index of Abhishek:"+names.indexOf("Abhishek"));
        System.out.println("First Index of Abhishek:"+names.lastIndexOf("Abhishek"));

        names.clear();
        System.out.println("Appointments Pending:"+names.size());
    }
}
