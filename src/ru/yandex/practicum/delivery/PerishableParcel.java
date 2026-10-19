package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private final int timeToLive;
    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay, 3);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        if ( (sendDay + timeToLive) >= currentDay) {
            return false;
        }
        return true;
    }
}
