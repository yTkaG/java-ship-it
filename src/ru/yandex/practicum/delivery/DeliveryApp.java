package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackablePacels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    status();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Трекинг посылки");
        System.out.println("0 — Завершить");
    }


    private static void addParcel() {
        System.out.println("Какой тип посылки вы хотите отправить? \n" +
                "1.Обычная \n" +
                "2.Хрупкая \n" +
                "3.Скоропртящуюся");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) { // обычная посылка
            System.out.println("Укажите описание, вес, адрес и день отправки, через Enter");

            String description = scanner.nextLine();
            int weight = Integer.parseInt(scanner.nextLine());
            String deliveryAddress = scanner.nextLine();
            int sendDay = Integer.parseInt(scanner.nextLine());

            StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(standardParcel);
            return;

        } else if (choice == 2) { // хрупкая посылка
            System.out.println("Укажите описание, вес, адрес и день отправки, через Enter");

            String description = scanner.nextLine();
            int weight = Integer.parseInt(scanner.nextLine());
            String deliveryAddress = scanner.nextLine();
            int sendDay = Integer.parseInt(scanner.nextLine());

            FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(fragileParcel);
            trackablePacels.add(fragileParcel);
            return;

        } else if (choice == 3) { // скоропортящаяся посылка
            System.out.println("Укажите описание, вес, адрес, день отправки и срок годности через Enter");

            String description = scanner.nextLine();
            int weight = Integer.parseInt(scanner.nextLine());
            String deliveryAddress = scanner.nextLine();
            int sendDay = Integer.parseInt(scanner.nextLine());
            int timeToLive = Integer.parseInt(scanner.nextLine());

            PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
            allParcels.add(perishableParcel);
            return;
        }
        System.out.println("Неверный выбор.");
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        for (Parcel parcel : allParcels) {
            System.out.println("Стоимость посылки " + parcel.calculateDeliveryCost());
        }
    }

    private static void status() {
        System.out.println("Введите новую локацию");
        String newLocation = scanner.nextLine();
        for (Trackable parcel : trackablePacels) {
            parcel.reportStatus(newLocation);
        }
    }

}

