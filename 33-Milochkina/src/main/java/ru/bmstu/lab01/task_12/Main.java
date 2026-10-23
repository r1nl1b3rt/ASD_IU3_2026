package ru.bmstu.lab01.task_12;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 12. Найти индексы i < j элементов с заданной суммой.
 * Выбрать наименьший i, затем наименьший j.
 * Если пары нет, вывести -1 -1.
 */
public class Main {
    /**
     * Считывает массив и сумму, выводит индексы выбранной пары
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        long targetSum = scanner.nextLong();

        ArrayIo.printArray(findPairIndices(numbers, targetSum));
    }
    /**
     * Ищет пару, используя таблицу ближайших индексов справа
     * @param numbers - массив целых чисел
     * @param targetSum - требуемая сумма
     * @return - выбранные индексы или массив {-1, -1}, если пары нет
     */
    public static int[] findPairIndices(int[] numbers, long targetSum) {
        Map<Long, Integer> indicesToRight = new HashMap<>();
        int[] result = {-1, -1};

        for (int index = numbers.length - 1; index >= 0; index--) {
            long complement = targetSum - numbers[index];
            Integer secondIndex = indicesToRight.get(complement);

            if (secondIndex != null) {
                result[0] = index;
                result[1] = secondIndex;
            }

            indicesToRight.put((long) numbers[index], index);
        }

        return result;
    }
}
