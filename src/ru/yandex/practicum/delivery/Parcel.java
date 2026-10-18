package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    String description;
    double weight;
    String deliveryAddress;
    int[] data = new int[3];

    public Parcel(String description, double weight, String deliveryAddress, int[] data) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.data = data;
    }
}
