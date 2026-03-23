import java.util.*;

public class Main {
    public static void main(String[] args){
        RechargePlan r=new RechargePlan(23,"UNLIMITED",84,859);
        System.out.println("Plan 1");
        r.displayPlanDetails();
        RechargePlan r2=new RechargePlan(r);
        System.out.println("Copy Constructor:");
        r2.displayPlanDetails();
        r2.planId=25;
        r2.price=799;
        System.out.println("After Modification");
        r2.displayPlanDetails();
    }
}