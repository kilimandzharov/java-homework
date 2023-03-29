package com.kirillmozharov.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public abstract class LogicElement {
    boolean[] entries;


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

    public int getLength() {
        return this.entries.length;
    }

    protected abstract boolean operation(boolean firstArg, boolean secondArg);

    public boolean result() {
        boolean currentVal = this.operation(entries[0], entries[1]);
        for (int i = 2; i < entries.length; i++) {
            currentVal = this.operation(currentVal, entries[i]);
        }
        return currentVal;
    }

    private boolean[] join(boolean[] a, boolean[] b) {
        boolean[] c = new boolean[a.length + b.length];

        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);

        return c;
    }

    private String getName(String name) {
        switch (name) {
            case "And":
                return "com.kirillmozharov.model.And";
            case "Or":
                return "com.kirillmozharov.model.Or";
            case "Xor":
                return "com.kirillmozharov.model.Xor";
        }
        return "";
    }

    public LogicElement union(LogicElement logicElement) throws ClassCastException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (this.getClass() != logicElement.getClass()) {
            throw new ClassCastException();
        }
        int newLength = this.getLength() + logicElement.getLength();
        Class resultClass = Class.forName(this.getName(this.getClass().getSimpleName()));
        Class cls[] = new Class[]{Integer.class};
        Constructor resultClassConstructor = resultClass.getConstructor(cls);
        LogicElement result = (LogicElement) resultClassConstructor.newInstance(newLength);
        System.out.println(result.entries.length);
        return result;
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
                "entries=" + Arrays.toString(entries) +
                '}';
    }
}
