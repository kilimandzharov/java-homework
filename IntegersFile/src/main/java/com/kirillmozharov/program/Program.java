package com.kirillmozharov.program;

import com.kirillmozharov.repository.IntegersRepository;

import java.io.IOException;

/**
 * @author mozharovkv
 */
public class Program {
    public static void main(String[] args) {
       /* try {
            IntegersRepository repository = new IntegersRepository("input.txt");
            System.out.println(repository);
            repository.add(777);
            repository.add(797);
            repository.add(77);
            repository.add(7);
            repository.deleteSameDigitsNumbers();
            try {
                repository.save("out.txt");
            } catch (IOException e){}

            System.out.println(repository);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }*/
        IntegersRepository repository = new IntegersRepository();
        repository.add(111);
        repository.add(111);
        repository.add(111);
        repository.add(1);
        repository.add(1);
        System.out.println(repository.countMaxInARow());
    }
}
