/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mirea.kt.example.randompotok;

/**
 *
 * @author home
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Randompotok {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // Создаем и запускаем поток для генерации чисел
        Thread generateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    numbers.add(random.nextInt(1000));
                }
                System.out.println("Махнич Григорий Витальевич В5 ПР1.14");
                System.out.println("Сгенерированные числа: " + numbers);
            }
        });
        generateThread.start();

        // Создаем и запускаем поток для сортировки чисел
        Thread sortThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Ждем окончания генерации чисел
                try {
                    generateThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Collections.sort(numbers);
                System.out.println("Отсортированные числа: " + numbers);
            }
        });
        sortThread.start();
    }
}