public class RechargePlan {

    int planId;
    String planName;
    int validityDays;
    double price;

    RechargePlan(int planId,String planName,int validityDays,double price){
        this.planId=planId;
        this.planName=planName;
        this.validityDays=validityDays;
        this.price=price;
    }

    RechargePlan(RechargePlan r){
        this.planId=r.planId;
        this.planName=r.planName;
        this.validityDays=r.validityDays;
        this.price=r.price;
    }

    public void displayPlanDetails(){
        System.out.println("PLan ID:"+planId);
        System.out.println("PLan Name:"+planName);
        System.out.println("PLan Validity:"+validityDays);
        System.out.println("PLan price:"+price);
    }
}
