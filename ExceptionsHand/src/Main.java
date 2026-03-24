import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        MovieBooking book=new MovieBooking();

        try{
            System.out.println("Enter Customer Name");
            String customerName=scan.nextLine();

            System.out.println("Movie Name(Enter one among these(Leo/Vikram/Jailer))");
            String movieName=scan.nextLine();

            System.out.println("Enter the number of Tickets:");
            int tickets=scan.nextInt();

            System.out.println("Enter the Payment Amount");
            double payment=scan.nextDouble();
            book.booking(customerName,movieName,tickets,payment);

        }
        catch(InvalidCustomerNameException e){
            System.out.println(e.getMessage());
        }
        catch(InvalidMovieException e){
            System.out.println(e.getMessage());
        }
        catch(InvalidTicketCountException e){
            System.out.println(e.getMessage());
        }
        catch(InsufficientSeatsException e){
            System.out.println(e.getMessage());
        }
        catch(PaymentFailedException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Booking Done");
        }

        try{
            System.out.println("Do u want to cancel Booking?(yes/no)");
            scan.nextLine();
            String response=scan.nextLine();

            if(response.equalsIgnoreCase("yes")){
                book.cancelBooking();
            }
        }
        catch(CancellationNotAllowedException e){
            System.out.println(e.getMessage());
        }
    }
}