package com.kirillmozharov.program;

import com.kirillmozharov.repository.Repository;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        Repository repository = new Repository();
        /**
         * Генерация файла
         */
        //TODO вынети в конструктор репозитория
        for (int i = 0; i < 10000; i++) {
            int random = (int) (Math.random() * 1000);
            repository.add(Integer.toString(random));
        }
        try {
            repository.save("out.txt");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        /**
         * Нахождение максимума
         */
        try {
            Repository secondRep = new Repository("out.txt");
            System.out.println(secondRep.findMax());
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }


    }
}
