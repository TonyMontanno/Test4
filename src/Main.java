package Calculator;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<String> romans = List.of("N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C");
    List<String> arabian = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    int arab1 = 0;
    int arab2 = 0;


    public String calc(String inputString) {

        String[] a = inputString.split(" ");

        if (a.length != 3) {
            throw new RuntimeException("Одно из условий было не выполнено!Введите символы от 1 до 10");
        }

        if (romans.contains(a[0]) && romans.contains(a[2])) {
            for (int i = 1; i < 10; i++) {
                if (a[0].equals(romans.get(i))) {
                    arab1 = i; //
                }
            }
            for (int i = 1; i < 10; i++) {
                if (a[2].equals(romans.get(i))) {
                    arab2 = i; //
                }
            }

            int result = 0;

            switch (a[1]) {

                case "+":
                    result = arab1 + arab2;
                    break;
                case "-":
                    result = arab1 - arab2;
                    break;
                case "*":
                    result = arab1 * arab2;
                    break;
                case "/":
                    result = arab1 / arab2;
                    break;
                default:
                    throw new IllegalArgumentException("Неверный знак операции");

            }

            if (result < 1) {
                throw new RuntimeException("Результатом вычислений римских чисел могут быть только положительные числа!");
            }
            return romans.get(result);

        }
        if (arabian.contains(a[0]) && arabian.contains(a[2])) {
            int arabResult = 0;
            switch (a[1]) {   //Проверка на знаки
                case "+":
                    arabResult = Integer.parseInt(a[0]) + Integer.parseInt(a[2]);
                    break;
                case "-":
                    arabResult = Integer.parseInt(a[0]) - Integer.parseInt(a[2]);
                    break;
                case "*":
                    arabResult = Integer.parseInt(a[0]) * Integer.parseInt(a[2]);
                    break;
                case "/":
                    arabResult = Integer.parseInt(a[0]) / Integer.parseInt(a[2]);
                    break;
                default:
                    throw new IllegalArgumentException("Неверный знак операции");
            }

            return "" + arabResult;


        } else {

            throw new RuntimeException("Одно из условий было не выполнено! Вводите или арабские, или римские числа.");

        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(main.calc(input));
    }
}