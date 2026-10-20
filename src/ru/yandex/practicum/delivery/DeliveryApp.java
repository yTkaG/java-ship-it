package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackablePacels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(15);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(10);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(5);
    private static String description;
    private static int weight;
    private static String deliveryAddress;
    private static int sendDay;

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
                case 5:
                    printAllParсels();
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
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }


    private static void addParcel() {
        System.out.println("Какой тип посылки вы хотите отправить? \n" +
                "1.Обычная \n" +
                "2.Хрупкая \n" +
                "3.Скоропртящуюся");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1: // обычная посылка
                writeParcel();

                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);

                allParcels.add(standardParcel);
                standardParcelBox.addParcel(standardParcel);
                break;

            case 2: // хрупкая посылка
                writeParcel();

                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);

                allParcels.add(fragileParcel);
                trackablePacels.add(fragileParcel);
                fragileParcelBox.addParcel(fragileParcel);
                break;

            case 3:  // скоропортящаяся посылка
                writeParcel();

                System.out.println("Укажите срок годности");

                int timeToLive = Integer.parseInt(scanner.nextLine());

                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress,
                    sendDay, timeToLive);

                allParcels.add(perishableParcel);
                perishableParcelBox.addParcel(perishableParcel);
                break;

            default:
                System.out.println("Неверный выбор типа посылки.");
        }
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int sum = 0;

        for (Parcel parcel : allParcels) {
            sum = sum + parcel.calculateDeliveryCost() ;
        }
        System.out.println("Общая стоимость всех доставок - " + sum);
    }

    private static void status() {
        System.out.println("Введите новую локацию");
        String newLocation = scanner.nextLine();
        for (Trackable parcel : trackablePacels) {
            parcel.reportStatus(newLocation);
        }
    }

    private static void writeParcel() {
        System.out.println("Укажите описание, вес, адрес и день отправки, через Enter");

        description = scanner.nextLine();
        weight = Integer.parseInt(scanner.nextLine());
        deliveryAddress = scanner.nextLine();
        sendDay = Integer.parseInt(scanner.nextLine());
    }

    private static void printAllParсels() {
        System.out.println("Выберите тип коробки:\n" +
                " 1. Обычная\n" +
                " 2. Хрупкая\n" +
                " 3. Скоропортящиеся");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                standardParcelBox.getAllParcels();
                break;
            case 2:
                fragileParcelBox.getAllParcels();
                break;
            case 3:
                perishableParcelBox.getAllParcels();
                break;
            default:
                System.out.println("Неверный тип коробки");
        }
    }
}

