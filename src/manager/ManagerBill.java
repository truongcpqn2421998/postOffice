package manager;

import model.Customer;
import model.ElectricMeter;
import model.Receipt;

import java.util.ArrayList;
import java.util.List;

public class ManagerBill {
    List<Receipt> receiptList=new ArrayList<>();
    List<Customer> customerList= new ArrayList<>();
    List<ElectricMeter>electricMeterList= new ArrayList<>();

    public ManagerBill() {
    }

    public ManagerBill(List<Receipt> receiptList, List<Customer> customerList, List<ElectricMeter> electricMeterList) {
        this.receiptList = receiptList;
        this.customerList = customerList;
        this.electricMeterList = electricMeterList;
    }

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public void setReceiptList(List<Receipt> receiptList) {
        this.receiptList = receiptList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<ElectricMeter> getElectricMeterList() {
        return electricMeterList;
    }

    public void setElectricMeterList(List<ElectricMeter> electricMeterList) {
        this.electricMeterList = electricMeterList;
    }
    public Customer findCustomer(String customer){
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getApartmentNumber().equals(customer)){
                return customerList.get(i);
            }
        }
        return null;
    }
    public ElectricMeter findElectricMeter(String electricMeter){
        for (int i = 0; i < electricMeterList.size(); i++) {
            if (electricMeterList.get(i).getApartmentNumber().equals(electricMeter)){
                return electricMeterList.get(i);
            }
        }
        return null;
    }

    public Receipt findReceipt(String apartmentNumber){
        for (int i = receiptList.size()-1; i >=0; i--) {
            if(receiptList.get(i).getCustomer().getApartmentNumber().equals(apartmentNumber)){
                return receiptList.get(i);
            }
        }
        return null;
    }
    public int numberCustomerPaid(Receipt receipt){
        return receipt.getPrice();
    }
}
