package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{
    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay, 4);
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + getDescription() + " изменила местоположение на " + newLocation);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + getDescription() + " обернута в защитную пленку");
        super.packageItem();
    }
}
