package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private final String description;
    private final int weight;
    private final String deliveryAddress;
    private final int sendDay;
    private final int coefficient;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay, int coefficient) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
        this.coefficient = coefficient;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public int getSendDay() {
        return sendDay;
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
