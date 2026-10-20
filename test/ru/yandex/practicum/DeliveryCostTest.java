package ru.yandex.practicum;

import ru.yandex.practicum.delivery.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DeliveryCostTest {

    StandardParcel standardParcel = new StandardParcel("Одежда", 2,"Санкт-Петербург", 5);
    FragileParcel fragileParcel = new FragileParcel("Посуда", 5,"Санкт-Петербург", 6);
    PerishableParcel perishableParcel = new PerishableParcel("Хлеб", 2,"Санкт-Петербург", 7, 3);
    ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(4);

    @Test
    public void shouldReturn4ForStandardParcel2kg() {
        assertEquals(4, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturn20ForFragileParcel5kg() {
        assertEquals(20, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturn6ForPerishableParcel2kg() {
        assertEquals(6, perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBeTrueForPerishableParcelIsExpired() {
        assertTrue(perishableParcel.isExpired(11));
    }

    @Test
    public void shouldBeFalseForPerishableParcelIsNotExpiredIn10currentDay() {
        assertFalse(perishableParcel.isExpired(10));
    }

    @Test
    public void shouldBeFalseForPerishableParcelIsNotExpiredIn9currentDay() {
        assertFalse(perishableParcel.isExpired(9));
    }

    @Test
    public void shouldBe1ParcelInBoxWhenWeightIsBelowLimit() {
        standardParcelBox.addParcel(standardParcel);
        assertEquals(1, standardParcelBox.getSize());
    }

    @Test
    public void shouldBe2ParcelInBoxWhenWeightIsEqualToLimit() {
        standardParcelBox.addParcel(standardParcel);
        standardParcelBox.addParcel(standardParcel);
        assertEquals(2, standardParcelBox.getSize());
    }

    @Test
    public void shouldNotAddParcelInBoxWhenWeightIsHigherLimit() {
        standardParcelBox.addParcel(standardParcel);
        standardParcelBox.addParcel(standardParcel);
        standardParcelBox.addParcel(standardParcel);
        assertEquals(2, standardParcelBox.getSize());
    }
}
