package ru.yandex.practicum.delivery;

public abstract class Parcel {
    protected final String description;
    protected final int weight;
    protected final String deliveryAddress;
    protected final int sendDay;
    protected final int coefficient;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay, int coefficient) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
        this.coefficient = coefficient;
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public int calculateDeliveryCost() {
        return weight * coefficient;
    }
}
