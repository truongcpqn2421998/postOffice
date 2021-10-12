package model;

public class ElectricMeter {
    private int oldNum;
    private int newNum;
    private String apartmentNumber;

    public ElectricMeter(int oldNum, int newNum,String apartmentNumber) {
        this.oldNum = oldNum;
        this.newNum = newNum;
        this.apartmentNumber=apartmentNumber;
    }

    public int getOldNum() {
        return oldNum;
    }

    public void setOldNum(int oldNum) {
        this.oldNum = oldNum;
    }

    public int getNewNum() {
        return newNum;
    }

    public void setNewNum(int newNum) {
        this.newNum = newNum;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return "electricMeter{" +
                "oldNum=" + oldNum +
                ", newNum=" + newNum +
                '}';
    }
}
