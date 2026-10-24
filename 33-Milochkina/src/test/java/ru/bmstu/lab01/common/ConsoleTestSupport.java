package ru.bmstu.lab01.common;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
/**
 * Подготавливает ввод программы и перехватывает её вывод для тестов
 */
public class ConsoleTestSupport {
    /**
     * Запускает программу с заданным вводом и возвращает её вывод
     * @param input - входные данные программы
     * @param program - действие для запуска программы
     * @return - текст, напечатанный программой
     */
    public static String runProgram(String input, Runnable program) {
        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (PrintStream testOutput = new PrintStream(output, true, StandardCharsets.UTF_8)) {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(testOutput);

            program.run();

            return output.toString(StandardCharsets.UTF_8);
        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}
