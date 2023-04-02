package com.kirillmozharov.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public abstract class LogicElement {
    private boolean[] entries;


    public LogicElement(int n) {
        boolean[] entries = new boolean[n];
        for (int i = 0; i < n; i++) {
            entries[i] = false;
        }
        this.entries = entries;
    }

    public boolean[] getEntries() {
        return entries;
    }

    public void setEntries(boolean[] entries) {
        this.entries = entries;
    }

    public void fill(boolean... booleans) throws IllegalArgumentException {
        if (booleans.length < this.entries.length) {
            throw new IllegalArgumentException();
        }
        System.arraycopy(booleans, 0, this.entries, 0, booleans.length);
    }

    /**
     * Возвращает количество входов
     * @return
     */
    public int getLength() {
        return this.entries.length;
    }

    /**
     * Делает логическую операцию между двумя элементами
     * @param firstArg
     * @param secondArg
     * @return
     */
    protected abstract boolean operation(boolean firstArg, boolean secondArg);

    /**
     * Делает логическую операцию со всеми входами
     * @return
     */
    public boolean result() {
        boolean currentVal = entries[0];
        for (int i = 1; i < entries.length; i++) {
            currentVal = this.operation(currentVal, entries[i]);
        }
        return currentVal;
    }

    /**
     * Объединяет два логических элемента в 1
     * @param logicElement
     * @return
     * @throws ClassCastException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public LogicElement union(LogicElement logicElement){
        if (this.getClass() != logicElement.getClass()) {
            throw new ClassCastException("...."); //TODO message
        }
        try {
            LogicElement result = this.getClass().getConstructor(int.class).
                    newInstance(this.getLength() + logicElement.getLength());
            System.arraycopy(this.entries, 0, result.entries, 0, this.entries.length);
            System.arraycopy(b, 0, c, a.length, b.length);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogicElement that = (LogicElement) o;
        return Arrays.equals(entries, that.entries);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(entries);
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "entries=" + Arrays.toString(entries) + //TODO доделать
                '}';
    }
}
