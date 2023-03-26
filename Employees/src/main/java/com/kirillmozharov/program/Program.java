package com.kirillmozharov.program;

import com.kirillmozharov.repository.Repository;
import com.kirillmozharov.utils.SortType;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            Repository repository = new Repository("input.txt");
            repository.save("output.txt", SortType.BY_FULL_NAME);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
