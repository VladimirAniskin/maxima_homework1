package ru.maxima;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TVTransmission[] program = {new TVTransmission("Вести"),
                new TVTransmission("Я Легенда"),
                new TVTransmission("Паровозик ТИТИПО"),
                new TVTransmission("Очумелые ручки"),};
        TVTransmission[] program2 = {new TVTransmission("Зов джунглей"),
                new TVTransmission("Мститили"),
                new TVTransmission("Злой Я"),
                new TVTransmission("Играй гармонь")};
        Channel[] channels = {new Channel(1, "ОРТ", program),
                new Channel(2, "REN-TV", program2),
                new Channel(3, "НТВ", program),
                new Channel(4, "22", program2),
                new Channel(5, "5 Канал", program),
                new Channel(6, "Россия 1", program2),
                new Channel(7, "РБК", program),
                new Channel(8, "СТС", program2)};
        TV Channel = new TV(channels);
        System.out.println("Выберите способ управления телевизором " +
                "\nпутем текстовой записи одного из вариантов: " +
                "\n обычный пульт или приложение на телефоне");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        while (true) {
            if (a == "обычный пульт") {
                break;
            } else if (a == "приложение на телефоне") {
                break;
            } else {
                System.out.println("Что -то, где-то вы ввели не коректно повторите пожалуйста ввод");
                a = scanner.nextLine();
            }
            System.out.println("Вы выбрвли " + a);
            break;
        }
        System.out.println("Числа от 1 до 8 для переключения по номерам каналов" +
                "\n0 для переключения на следующий по порядку канал" +
                "\n-1 для переключения на предыдущий по порядку канал" +
                "\n-2 для переключения на предыдущий канал");
        PDU pdu = new PDU(Channel);
        pdu.povewerON();
    }
}