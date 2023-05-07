package com.kirillmozharov.repository;

import com.kirillmozharov.factory.AbstractElementFactory;
import com.kirillmozharov.model.LogicElement;
import com.kirillmozharov.model.SimpleElementFactory;
import com.kirillmozharov.util.ElementEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ElementRepository {
    private List<LogicElement> elements = new ArrayList<>();

    public List<LogicElement> getElements() {
        return elements;
    }

    /**
     * 3.	В конструкторе класса произвести загрузку логических элементов из .csv файла в поле класса.
     * При чтении и заполнении данными списка использовать рациональные алгоритмы, а так же весь реализованный
     * функционал ранее. При реализации пользоваться аргументом-словарем фабрик
     * @param filename
     */
    public ElementRepository(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] vals = line.split(";");
                LogicElement logicElement = SimpleElementFactory.getInstance(ElementEnum.valueOf(vals[0]), vals.length - 1);
                this.fillAndAdd(logicElement, Arrays.copyOfRange(vals, 1, vals.length));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException ignored) {
        }
    }

    /**
     * 5.	Написать перегрузку конструктора, который принимает на вход имя файла csv, где располагаются записи
     * логических элементов, и производит заполнение списка логических элементов, не используя словарь фабрик,
     * а используя простую фабрику
     * @param filename
     * @param factoryMap
     */
    public ElementRepository(String filename, Map<ElementEnum, AbstractElementFactory> factoryMap) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] vals = line.split(";");
                LogicElement logicElement = factoryMap.get(ElementEnum.valueOf(vals[0])).getInstance(vals.length - 1);
                this.fillAndAdd(logicElement, Arrays.copyOfRange(vals, 1, vals.length));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException ignored) {
        }
    }

    private void fillAndAdd(LogicElement logicElement, String[] vals) {
        if (logicElement != null) {
            boolean[] entries = new boolean[vals.length];
            for (int i = 0; i < vals.length; i++) {
                entries[i] = Boolean.parseBoolean(vals[i]);
            }
            logicElement.fill(entries);
            this.elements.add(logicElement);
        }
    }

    /**
     * 1.	В классе-репозитории реализовать метод sort, который принимает на вход реализацию интерфейса Comparator
     * и производит сортировку списка данным объектом, если он не null, или же методом compareTo в противном случае
     * @param logicElementComparator
     */
    public void sort(Comparator<LogicElement> logicElementComparator) {
        this.elements.sort(logicElementComparator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementRepository that = (ElementRepository) o;
        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    /**
     * 7.	Реализовать метод toString, выводящий данные из списка, каждый логический элемент должен выводиться с
     * новой строки
     * @return
     */
    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (LogicElement element : this.elements) {
            stringJoiner.add(element.toString());
        }
        return stringJoiner.toString();
    }
}
