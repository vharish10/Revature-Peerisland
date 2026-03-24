import java.util.*;

public class MovieBooking {
    String customerName;
    String movieName;
    int tickets;
    boolean cancelled=false;
    double ticketPrice=250;
    static int availableSeats=5;

    public void booking(String customerName,String movieName,int tickets,double payment) throws InvalidCustomerNameException,InvalidMovieException,InvalidTicketCountException,InsufficientSeatsException,PaymentFailedException{
        double total=tickets*ticketPrice;

        if(customerName==null || customerName.trim().isEmpty()){
            throw new InvalidCustomerNameException("Customer Name cannot be empty");
        }

        if(!(movieName.equals("Leo") || movieName.equals("Vikram") || movieName.equals("Jailer"))){
            throw new InvalidMovieException("Movie Not available");
        }

        if(tickets<=0){
            throw new InvalidTicketCountException("Add some tickets");
        }

        if(tickets>availableSeats){
            throw new InsufficientSeatsException("Count exceeds the available Seats");
        }

        if(payment<total){
            throw new PaymentFailedException("Payment should be greater than the total");
        }

        this.customerName=customerName;
        this.movieName=movieName;
        this.tickets=tickets;
    }

    public void cancelBooking() throws CancellationNotAllowedException{
        if(cancelled){
            throw new CancellationNotAllowedException("Booking is already Cancelled");
        }
        cancelled=true;
        availableSeats+=tickets;
    }
}
