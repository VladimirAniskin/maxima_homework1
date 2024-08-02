package ru.maxima;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.Scanner;

@AllArgsConstructor
@Setter
@Getter
public class PDU implements PDUControler {
    private TV Tv;
    private int condition;
    private int prevCondition;


    public PDU(TV Tv) {
        setTv(Tv);
        Random random = new Random();
        setCondition(random.nextInt(getTv().getChannels().length));
        setPrevCondition(getCondition());

    }

    public void povewerON() {
        System.out.println("Влючаем телевизор, начинает работать случайный канал");
        Scanner scanner = new Scanner(System.in);
        int in;
        int namber = 1;
        do {
            System.out.println("************************************************");
            System.out.println(getTv().getChannels()[getCondition()].getNomer());
            System.out.println(getTv().getChannels()[getCondition()].getNameCannal() + " " +
                    getTv().getChannels()[getCondition()].getTransmission()[namber].getProgramName());
            System.out.println("************************************************");
            System.out.print("Нажмите на кнопку:\n ");
            in = scanner.nextInt();
            if (in == 0 || in == -1) {
                switchingBetweenChannels(in);
            } else if (in == -2) {
                switchingBetweenTheLatter();
            } else if (in > 0) {
                switchinByNumbers(in);
            }
        } while (true);
    }

    @Override
    public void switchinByNumbers(int namber) {
        if (namber <= getTv().getChannels().length) {
            System.out.println("Перемещаемся на канал под номером " + namber);
            setPrevCondition(getCondition());
            setCondition(namber - 1);
        } else {
            System.out.println("Введен некорректный номер канала");
        }
    }

    @Override
    public void switchingBetweenChannels(int namber1) {
        if (namber1 == -1) {
            System.out.println("Перемещаемся на один канал назад");
            if (getCondition() == 0) {
                setPrevCondition(0);
                setCondition(getTv().getChannels().length - 1);
            } else {
                setPrevCondition(getCondition());
                setCondition(getCondition() - 1);
            }
        } else {
            System.out.println("Перемещаемся на один канал вперед");
            if (getCondition() == getTv().getChannels().length - 1) {
                setPrevCondition(getCondition());
                setCondition(0);
            } else {
                setPrevCondition(getCondition());
                setCondition(getCondition() + 1);
            }
        }

    }

    @Override
    public void switchingBetweenTheLatter() {
        System.out.println("Перемещаемся на предыдущий канал");
        int i = getPrevCondition();
        setPrevCondition(getCondition());
        setCondition(i);

    }
}