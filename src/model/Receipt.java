package model;

public class Receipt {
    private Customer customer;
    private ElectricMeter electricMeter;

    public Receipt(Customer customer, ElectricMeter electricMeter) {
        this.customer = customer;
        this.electricMeter = electricMeter;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ElectricMeter getElectricMeter() {
        return electricMeter;
    }

    public void setElectricMeter(ElectricMeter electricMeter) {
        this.electricMeter = electricMeter;
    }

    public int getPrice(){
        return ((electricMeter.getNewNum()- getElectricMeter().getOldNum())* 750);
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "customer=" + customer +
                ", electricMeter=" + electricMeter +
                '}'+" \n paid: "+getPrice();
    }
}
