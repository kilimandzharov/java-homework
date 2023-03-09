package com.kirillmozharov.program;

import com.kirillmozharov.repository.UserRepository;

import java.io.IOException;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
      try {
          UserRepository userRepository = new UserRepository("https://jsonplaceholder.typicode.com/users");
          /**
           * 6.	Найти для каждого символа }, {, ], [ сколько раз он встречается в строке-поля класса,
           * вернув результат в виде HashMap<Character, Integer>
           */

//          System.out.println(hashMap.toString());
          HashMap<Character, Integer> count = userRepository.count();
          System.out.println(count);
      } catch (IOException e){
          System.out.println(e.getMessage());
      }

    }
}
