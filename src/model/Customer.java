package model;

public class Customer {
    private String name;
    private String apartmentNumber;
    private String code;

    public Customer() {
    }

    public Customer(String name, String apartmentNumber, String code) {
        this.name = name;
        this.apartmentNumber = apartmentNumber;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "customer{" +
                "name='" + name + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
