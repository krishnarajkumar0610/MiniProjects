//Code contains booking the tickets,
// Display all the Customers who booked the tickets,
// Display the particular Token id Details
package trainreservation;

import java.util.ArrayList;
import java.util.Scanner;

class Train{
    Scanner sc = new Scanner(System.in);
    ArrayList<Train> list = new ArrayList<>();
    private static int tot_seats;
    private int seats;
    private String name;
    private int seat_price;
    private int tik_ID;
    private  int price;
    private static int ac=50;
    private boolean ac_Compartment;
    Train(){
        tot_seats=50;
        seat_price=70;
        tik_ID=1;
        ac_Compartment=false;
    }
    Train(int seats,String name,int tik_ID,int price){
        this.seats=seats;
        this.name=name;
        this.tik_ID=tik_ID;
        this.price=price;
    }
    Train(int seats,String name,int tik_ID,int price,boolean ac){
        this.seats=seats;
        this.name=name;
        this.tik_ID=tik_ID;
        this.price=price;
        this.ac_Compartment=ac;
    }
    String getName(){
        return name;
    }
    int getSeats(){
        return seats;
    }
    int getTik_ID(){
        return tik_ID;
    }
    int getPrice(){
        return price;
    }
    boolean getAc(){
        return ac_Compartment;
    }
    public String bookTickets(boolean ac){
        int seats=0;
        if(tot_seats!=0){
            System.out.print("Enter number of seats you need : ");
             seats=sc.nextInt();
            while(seats>tot_seats) {
                    System.out.println("Enter number of seats below : " + tot_seats);
                    seats = sc.nextInt();
            }
            tot_seats-=seats;
            System.out.print("Enter your name to confirm your seats : ");
            sc.nextLine();
            name=sc.nextLine();
            if(ac==true){
                price=(seats*seat_price)+(seats*Train.ac);
                Train t = new Train(seats,name,tik_ID,price,ac);
                tik_ID++;
                list.add(t);
            }else{
                price=seats*seat_price;
                Train t = new Train(seats,name,tik_ID,price);
                tik_ID++;
                list.add(t);
            }
            System.out.println("----------------------------------");
            return "Thanks you for booking sir.\nYour seats were booked\nTotal seats you booked are "+seats+" and its price is "+price;
        }
        System.out.println("----------------------------------");
        return "Sorry....seats are not available";
    }
    public void displayAllList(){
        if(list.isEmpty()){
            System.out.println("No tickets were booked to show the list");
            return;
        }
        for(Train t :list){
            System.out.println("*************************************************");
            System.out.println("Customer Ticket ID :"+t.getTik_ID());
            System.out.println("Customer Name :"+t.getName());
            System.out.println("Customer Booked seats :"+t.getSeats());
            System.out.println("AC Compartment : "+t.getAc());
            System.out.println("Total amount of booked seats :"+t.getPrice());
            System.out.println("*************************************************");
            System.out.println();
        }
    }
    public void display(int tik_id){
        boolean b = true;
        if(list.isEmpty()){
            System.out.println("No tickets were booked to show the list");
            return;
        }
        for(Train t :list){
            if (t.getTik_ID()==tik_id){
                System.out.println("*************************************************");
                System.out.println("Customer Ticket ID :"+t.getTik_ID());
                System.out.println("Customer Name :"+t.getName());
                System.out.println("Customer Booked Seats :"+t.getSeats());
                System.out.println("AC Compartment : "+t.getAc());
                System.out.println("Total amount of booked seats :"+t.getPrice());
                System.out.println("*************************************************");
                System.out.println();
                break;
            }
        }
        if(b){
            System.out.println("----------------------------------");
            System.out.println("Ticket ID "+tik_id+" is not Found");
            System.out.println("----------------------------------");
        }
    }
    public void showAvaiSeats(){
        if(tot_seats!=0){
            System.out.println("----------------------------------");
            System.out.println("Available seats in the compartment :"+tot_seats);
            System.out.println("----------------------------------");
        }
        else{
            System.out.println("----------------------------------");
            System.out.println("Sorry seats were not available...");
            System.out.println("----------------------------------");
        }
    }
}
public class BookTicket {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Train t = new Train();
        while (true){
            System.out.println("----------------------------------");
            System.out.println("1.Book Tickets");
            System.out.println("2.Display all list");
            System.out.println("3.Diplay particular customer detail");
            System.out.println("4.Show Available seats");
            System.out.println("----------------------------------");
            System.out.print("Select the option You need :");
            int opt = in.nextInt();
            switch(opt){
                case 1:
                    System.out.print("NEED AC OR NON-AC (Ac - true , Non-Ac - false) : ");
                    boolean ac = in.nextBoolean();
                    System.out.println(t.bookTickets(ac));
                    System.out.println("----------------------------------");
                    break;
                case 2:
                    t.displayAllList();
                    break;
                case 3:
                    System.out.print("Enter ticket ID to search the customer : ");
                    int tik_id = in.nextInt();
                    t.display(tik_id);
                    break;
                case 4:
                    t.showAvaiSeats();
                    break;
                default:
                    System.out.println("Select the correct option");
            }
        }
    }
}