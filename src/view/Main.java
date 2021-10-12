package view;
import manager.ManagerBill;
import model.Customer;
import model.ElectricMeter;
import model.Receipt;

import java.util.Scanner;
public class Main {
    static ManagerBill postOffice=new ManagerBill();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        while (choice!=0){
            System.out.println("-----MENU-----");
            System.out.println("1.Add a new Guest");
            System.out.println("2.Remove Guest");
            System.out.println("3.Add new Electric Meter");
            System.out.println("4.Update a Electric Meter");
            System.out.println("5.Remove a Electric Meter");
            System.out.println("6.Create a new Bill");
            System.out.println("7.Calculate the amount to be paid");
            System.out.println("0.Exit");
            System.out.println("Enter choice:");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    addGuest();
                    break;
                case 2:
                    removeGuest();
                    break;
                case 3:
                    addElectricMeter();
                    break;
                case 4:
                    updateElectricMeter();
                    break;
                case 5:
                    removeElectric();
                    break;
                case 6:
                    createBill();
                    break;
                case 7:
                    householdBilling();
                    break;
            }
        }
    }


    public static void addGuest(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter New Guest:");
        System.out.println("Enter guest's name");
        String name=scanner.nextLine();
        System.out.println("Enter guest's apartmentNumber");
        String apartmentNum=scanner.nextLine();
        System.out.println("Enter guest's code");
        String code=scanner.nextLine();
        postOffice.getCustomerList().add(new Customer(name,apartmentNum,code));
    }


        public static Customer checkCustomer(){
        Scanner scanner=new Scanner(System.in);
        Customer check =null;
        String numHome;
        do {
            System.out.println("Enter household number:");
            numHome=scanner.nextLine();
            check=postOffice.findCustomer(numHome);
            if(check==null){
                System.out.println("Error");
            }
        }while (check==null);
        return check;
    }


    public static void removeGuest(){
        Customer check=checkCustomer();
        postOffice.getCustomerList().remove(check);
    }


    public static void addElectricMeter(){
        Scanner scanner=new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);
        System.out.println("Enter Electric Meter:");
        System.out.println("Enter old number:");
        int oldNum=scanner.nextInt();
        System.out.println("Enter new number:;");
        int newNum=scanner.nextInt();
        System.out.println("Enter ApartmentNumber:");
        String numHome=scanner1.nextLine();
        postOffice.getElectricMeterList().add(new ElectricMeter(oldNum,newNum,numHome));
    }


    public static ElectricMeter updateElectricMeter(){
        Scanner scanner=new Scanner(System.in);
        ElectricMeter check=checkElectricMeter();
        check.setOldNum(check.getNewNum());
        System.out.println("Update new number:");
        int newNum=scanner.nextInt();
        check.setNewNum(newNum);
        return check;
    }


    public static ElectricMeter checkElectricMeter(){
        Scanner scanner=new Scanner(System.in);
        ElectricMeter check =null;
        String numHome;
        do {
            System.out.println("Enter household number:");
            numHome=scanner.nextLine();
            check=postOffice.findElectricMeter(numHome);
            if(check==null){
                System.out.println("Error");
            }
        }while (check==null);
        return check;
    }


    public static void removeElectric(){
        ElectricMeter check=checkElectricMeter();
        postOffice.getElectricMeterList().remove(check);
    }


    public static Receipt createBill(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Apartment Number:");
        String check=scanner.nextLine();
        if(postOffice.findCustomer(check)!=null&postOffice.findElectricMeter(check)!=null){
            Receipt newReceipt=new Receipt(postOffice.findCustomer(check),postOffice.findElectricMeter(check));
            postOffice.getReceiptList().add(newReceipt);
            return newReceipt;
        }
        return null;
    }


    public static void householdBilling(){
        Scanner scanner=new Scanner(System.in);
        Receipt check=null;
        String numHome;
        do {
            System.out.println("Enter household number:");
            numHome=scanner.nextLine();
            check=postOffice.findReceipt(numHome);
            if(check==null){
                System.out.println("err");
            }
        }while (check==null);
        System.out.println(postOffice.numberCustomerPaid(check));
    }
}
