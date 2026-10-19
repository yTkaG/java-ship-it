package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private List<T> parcels = new ArrayList<>();
    private final int maxWeight;
    private int weight = 0;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T newParcel) {
        if(newParcel.getWeight() + weight > maxWeight) {
            System.out.println("Превышен грузовой лимит, посылка не добавлена");
            return;
        }
        parcels.add(newParcel);
        weight = weight + newParcel.getWeight();
        System.out.println("Посылка добавлена в коробку");
    }

    public void getAllParcels() {
        System.out.println("Посылки в коробке:");
        for (T parcel : parcels) {
            System.out.println(parcel.getDescription());
        }
    }
}
