package com.kirillmozharov.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class NumberCalculator {
    private int[] dataA;
    private int[] massPositive;
    private int[] massNegative;

    public NumberCalculator() {
    }

    /**
     * 1.	Создать базовый класс NumberCalculator, который имеет поля: массивы целых чисел с названиями
     * соответственно dataA, massPositive и massNegative, конструктор принимает на вход число n – размер массивов.
     * Конструктор должен заполнить случайными числами в диапазоне от -100 до 100 только второй и третий массивы.
     * Второй массив заполняется только положительными числами, третий – отрицательными
     * @param n
     */
    public NumberCalculator(int n) {
        this.dataA = new int[n];
        this.massNegative = Arrays.stream(new int[n]).map(x -> {
            double random = -(Math.random() * 99 + 1);
            return (int) random;
        }).toArray();
        this.massPositive = Arrays.stream(new int[n]).map(x -> {
            double random = Math.random() * 99 + 1;
            return (int) random;
        }).toArray();
    }

    /**
     * 2.	Реализовать метод fill, который принимает на вход переменное количество аргументов типа int и производит
     * заполнение первого массива. Корректно обработать ситуацию, когда размер переданного массива окажется
     * меньше размера исходного
     * @param ints
     */
    public void fill(int... ints) {
        if (ints.length < this.dataA.length){
            throw new IllegalArgumentException("Array must be the same size as dataA");
        }
        this.dataA = Arrays.copyOf(ints, this.dataA.length);
    }

    /**
     * 3.	Написать метод, который производит операцию над двумя целыми числами, которая пока что не определена,
     * но вскоре будет реализована в наследниках класса
     * @param a
     * @param b
     * @return
     */
    protected abstract int operation(int a, int b);

    /**
     * 4.	Написать метод result, который применяет операцию для всех элементов первого массива
     * @return
     */
    public int result() {
        return Arrays.stream(this.dataA).reduce(this::operation).orElse(0);
    }

    /**
     * 5.	Написать метод, который возвращает объект такого же типа, как и объект, для которого будет вызван метод,
     * используя динамическую идентификацию типа через getClass() и getConstructor(), подавая в качестве аргумента конструктора длину массива, увеличенную вдвое
     * @return
     */
    public NumberCalculator getObject() {
       try {
           return this.getClass().getConstructor(int.class)
                   .newInstance(this.dataA.length * 2);
       } catch (Exception ignored){
           return null;
       }
    }

    /**
     * 6.	Написать метод, который будет динамически определять и получать массивы и данные из них, которые
     * сохранены в полях, начинающихся с названия mass
     * @return
     */
    public List<int[]> getListArray() {
        try {
            List<Field> fields = Arrays.stream(NumberCalculator.class.getDeclaredFields()).filter(field -> field.getName().startsWith("mass")).toList();
            List<int[]> result = new ArrayList<>();
            for (Field field : fields) {
                result.add((int[]) field.get(this));
            }
            return result;
        } catch (Exception e){
            return null;
        }
    }

    /**
     * 9.	Используя динамическую идентификацию типов,
     * написать метод, который вызывает только геттеры, начинающиеся с названия getMass
     */
    public List<int[]> invokeGetMass() {
        try {
            List<int[]> result = new ArrayList<>();
            Method[] methods = NumberCalculator.class.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().startsWith("getMass")) {
                    result.add((int[]) method.invoke(this));
                }
            }
            return result;
        } catch (Exception ignored){
            return null;
        }
    }

    public int[] getDataA() {
        return Arrays.copyOf(dataA, dataA.length);
    }

    public int[] getMassPositive() {
        return Arrays.copyOf(massPositive, massPositive.length);
    }

    public int[] getMassNegative() {
        return Arrays.copyOf(massNegative, massNegative.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberCalculator that = (NumberCalculator) o;
        return Arrays.equals(dataA, that.dataA) && Arrays.equals(massPositive, that.massPositive) && Arrays.equals(massNegative, that.massNegative);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(dataA);
        result = 31 * result + Arrays.hashCode(massPositive);
        result = 31 * result + Arrays.hashCode(massNegative);
        return result;
    }

    @Override
    public String toString() {
        return "NumberCalculator{" +
                "dataA=" + Arrays.toString(dataA) +
                ", massPositive=" + Arrays.toString(massPositive) +
                ", massNegative=" + Arrays.toString(massNegative) +
                '}';
    }
}
