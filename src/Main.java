import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество измерений: ");
        int n = sc.nextInt();
        Random random = new Random();
        List<Double> currents = new ArrayList<>(); // Список для хранения измерений тока
        List<Double> voltages = new ArrayList<>(); // Список для хранения измерений напряжения

        for (int i = 0; i < n; i++) {
            currents.add(random.nextDouble() * 100 + 1); // случайный ток
            voltages.add(random.nextDouble() * 10 + 1); // случайное напряжение
        }


        double resistance = calculateResistance(currents, voltages);
        System.out.println("Значения измерений I: " + currents);
        System.out.println("Значения измерений U: " + voltages);
        System.out.println("Рассчитанное R: " + resistance);
    }

    public static double calculateResistance(List<Double> currents, List<Double> voltages) {
        double sumIU = 0;
        double sumISquared = 0;

        for (int i = 0; i < currents.size(); i++) {
            double I = currents.get(i);
            double U = voltages.get(i);
            sumIU += I * U;
            sumISquared += I * I;
        }

        if (sumISquared == 0) {
            throw new ArithmeticException("Сумма квадратов токов равна нулю.");
        }
        return sumIU / sumISquared;
    }
}
