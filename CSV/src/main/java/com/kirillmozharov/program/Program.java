package com.kirillmozharov.program;

import com.kirillmozharov.model.Student;
import com.kirillmozharov.repository.StudentsRepository;

import java.io.IOException;

/**
 * @author mozharovkv
 */
public class Program {
    public static void main(String[] args) {
        StudentsRepository repository = new StudentsRepository();
        repository.add(new Student("Кирилл", "Можаров",2,new int[]{4,4,4,5}));
        repository.add(new Student("Семен", "Можаров",2,new int[]{2,2,3,2}));
        repository.add(new Student("Игорь", "Можаров",2,new int[]{5,5,5,5}));
        try {
            repository.save("out.txt");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        try {
            StudentsRepository rep = new StudentsRepository("out.txt");
            System.out.println(rep.toString());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
