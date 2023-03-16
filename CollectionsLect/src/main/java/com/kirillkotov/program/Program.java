package com.kirillkotov.program;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        //Списки
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(10);
        arrayList1.add(12);
        arrayList1.add(13);
        arrayList1.add(1, 100);
        System.out.println("ArrayList1 After add");
        System.out.println(arrayList1);

        int res1 = arrayList1.get(0);
        System.out.println("\nGet from ArrayList1 0 index");
        System.out.println(res1);

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(10);
        arrayList2.addAll(arrayList1);
        System.out.println("\nArrayList2 After add all");
        System.out.println(arrayList2);

        System.out.println("\nArrayList1 After add all by index");
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        arrayList3.add(1000);
        arrayList3.add(2000);
        arrayList3.add(2000);
        arrayList3.add(3000);
        arrayList1.addAll(2, arrayList3);
        System.out.println(arrayList1);

        arrayList2.clear();
        System.out.println("\nArrayList2 After clear");
        System.out.println(arrayList2);

        boolean contains = arrayList1.contains(1000);
        System.out.println("\nContains 1000 in ArrayList1");
        System.out.println(contains);

        boolean equals = arrayList1.equals(arrayList2);
        System.out.println("\nArrayList1 == ArrayList2 ?");
        System.out.println(equals);

        int index1 = arrayList1.indexOf(1000);
        System.out.println("\nFirst Index of 1000 in ArrayList1");
        System.out.println(index1);

        arrayList1.add(1000);
        int index2 = arrayList1.lastIndexOf(1000);
        System.out.println("\nLast Index of 1000 in ArrayList1");
        System.out.println(index2);

        Integer rem = 1000;
        System.out.println("\nArrayList1 before remove 1000");
        System.out.println(arrayList1);
        boolean remove = arrayList1.remove(rem);
        System.out.println("ArrayList1 after remove first 1000");
        System.out.println(arrayList1);
        System.out.println("Result of remove 1000 is");
        System.out.println(remove);

        int remInd = 1;
        System.out.println("\nArrayList1 before remove element from 1 index");
        System.out.println(arrayList1);
        Integer remValue = arrayList1.remove(remInd);
        System.out.println("ArrayList1 after remove element from 1 index");
        System.out.println(arrayList1);
        System.out.println("Removed value is");
        System.out.println(remValue);

        ArrayList<Integer> removedArrayList = new ArrayList<>();
        removedArrayList.add(10);
        removedArrayList.add(2000);
        removedArrayList.add(13);
        System.out.println("\nArrayList1 before remove element from 1 index");
        System.out.println(arrayList1);
        arrayList1.removeAll(removedArrayList);
        System.out.println("ArrayList1 after remove collection from its");
        System.out.println(arrayList1);

        boolean empty = arrayList1.isEmpty();
        System.out.println("\nArrayList1 is empty?");
        System.out.println(empty);

        ArrayList<Integer> arrayList4 = new ArrayList<>();
        arrayList4.add(3000);
        arrayList4.add(1000);
        System.out.println("\nArrayList1 before retain");
        System.out.println(arrayList1);
        arrayList1.retainAll(arrayList4);
        System.out.println("ArrayList1 after retain");
        System.out.println(arrayList1);

        arrayList1.set(0, -2);
        System.out.println("\nArrayList1 after change element of 0 index");
        System.out.println(arrayList1);

        int size = arrayList1.size();
        System.out.println("\nArrayList1 size");
        System.out.println(size);

        arrayList1.add(5);
        arrayList1.add(2);
        arrayList1.add(7);
        arrayList1.add(7);
        arrayList1.add(4);
        System.out.println("\nArrayList1 before sort");
        System.out.println(arrayList1);
        arrayList1.sort(null);
        System.out.println("ArrayList1 after sort");
        System.out.println(arrayList1);

        System.out.println("\nArrayList1 before sort by Comparator");
        System.out.println(arrayList1);
        arrayList1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println("ArrayList1 after sort by Comparator");
        System.out.println(arrayList1);

        List<Integer> integersRes = arrayList1.subList(2, 4);
        System.out.println("\nResult of sub list from 2 to 4 indexes");
        System.out.println(integersRes);

        ArrayList<Integer> containsArrayList = new ArrayList<>();
        containsArrayList.add(1000);
        containsArrayList.add(-2);
        containsArrayList.add(7);
        containsArrayList.add(4);
        containsArrayList.add(5);
        containsArrayList.add(2);
        boolean b = arrayList1.containsAll(containsArrayList);
        System.out.println("\nArrayList1 before check contains");
        System.out.println(arrayList1);
        System.out.println("ContainsArrayList before check contains");
        System.out.println(containsArrayList);
        System.out.println("ContainsArrayList is all in ArrayList1 ?");
        System.out.println(b);

        Integer[] integers = arrayList1.toArray(new Integer[0]);
        System.out.println("\nArrayList1 to Integer Array");
        System.out.println(Arrays.toString(integers));

        ArrayList<Integer> arrayList = new ArrayList<>(100);
        System.out.println("\nArrayList with 100 reserved items, but its size is 0");
        System.out.println(arrayList);

        ArrayList<Integer> arrayListFromOther = new ArrayList<>(arrayList1);
        System.out.println("\nArrayListFromOther from ArrayList1(copy)");
        System.out.println(arrayListFromOther);

        Integer[] mass = {2, 4, 6};
        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(mass));
        System.out.println("\nArray to ArrayList");
        System.out.println(integerArrayList);

        LinkedList<Integer> linkedList = new LinkedList<>();
        /*TODO LinkedList имеет такой же набор методов, что указан выше,
           самостоятельно произвести вызов каждого
           такого метода для ArrayList, убедиться в правильности работы*/
        System.out.println("\n------------------------------------------------");
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.add(10);
        linkedList1.add(12);
        linkedList1.add(13);
        linkedList1.add(1, 100);
        System.out.println("ArrayList1 After add");
        System.out.println(arrayList1);

        int result1 = linkedList1.get(0);
        System.out.println("\nGet from ArrayList1 0 index");
        System.out.println(result1);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(10);
        linkedList2.addAll(linkedList1);
        System.out.println("\nArrayList2 After add all");
        System.out.println(linkedList2);

        System.out.println("\nArrayList1 After add all by index");
        LinkedList<Integer> linkedList3 = new LinkedList<>();
        linkedList3.add(1000);
        linkedList3.add(2000);
        linkedList3.add(2000);
        linkedList3.add(3000);
        linkedList1.addAll(2, linkedList3);
        System.out.println(linkedList3);

        arrayList2.clear();
        System.out.println("\nArrayList2 After clear");
        System.out.println(linkedList2);

        boolean contains1 = linkedList1.contains(1000);
        System.out.println("\nContains 1000 in ArrayList1");
        System.out.println(contains1);

        boolean equals1 = linkedList1.equals(linkedList1);
        System.out.println("\nArrayList1 == ArrayList2 ?");
        System.out.println(equals1);

        int index11 = linkedList1.indexOf(1000);
        System.out.println("\nFirst Index of 1000 in ArrayList1");
        System.out.println(index11);

        linkedList1.add(1000);
        int index22 = linkedList1.lastIndexOf(1000);
        System.out.println("\nLast Index of 1000 in ArrayList1");
        System.out.println(index22);

        Integer remm = 1000;
        System.out.println("\nArrayList1 before remove 1000");
        System.out.println(linkedList1);
        boolean removem = linkedList1.remove(remm);
        System.out.println("ArrayList1 after remove first 1000");
        System.out.println(arrayList1);
        System.out.println("Result of remove 1000 is");
        System.out.println(removem);

        int remInd1 = 1;
        System.out.println("\nArrayList1 before remove element from 1 index");
        System.out.println(linkedList1);
        Integer remValue1 = linkedList1.remove(remInd1);
        System.out.println("ArrayList1 after remove element from 1 index");
        System.out.println(linkedList1);
        System.out.println("Removed value is");
        System.out.println(remValue1);

        LinkedList<Integer> removedLinkedList = new LinkedList<>();
        removedLinkedList.add(10);
        removedLinkedList.add(2000);
        removedLinkedList.add(13);
        System.out.println("\nArrayList1 before remove element from 1 index");
        System.out.println(removedLinkedList);
        arrayList1.removeAll(removedLinkedList);
        System.out.println("ArrayList1 after remove collection from its");
        System.out.println(arrayList1);

        boolean empty1 = linkedList1.isEmpty();
        System.out.println("\nArrayList1 is empty?");
        System.out.println(empty1);

        LinkedList<Integer> linkedList4 = new LinkedList<>();
        linkedList4.add(3000);
        linkedList4.add(1000);
        System.out.println("\nArrayList1 before retain");
        System.out.println(linkedList1);
        arrayList1.retainAll(linkedList4);
        System.out.println("ArrayList1 after retain");
        System.out.println(linkedList1);

        linkedList1.set(0, -2);
        System.out.println("\nArrayList1 after change element of 0 index");
        System.out.println(linkedList1);

        int size1 = linkedList1.size();
        System.out.println("\nArrayList1 size");
        System.out.println(size1);

        linkedList1.add(2);
        linkedList1.add(7);
        linkedList1.add(7);
        linkedList1.add(4);
        linkedList1.add(5);
        System.out.println("\nArrayList1 before sort");
        System.out.println(linkedList1);
        linkedList1.sort(null);
        System.out.println("ArrayList1 after sort");
        System.out.println(linkedList1);

        System.out.println("\nArrayList1 before sort by Comparator");
        System.out.println(linkedList1);
        linkedList1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println("ArrayList1 after sort by Comparator");
        System.out.println(arrayList1);

        List<Integer> integersRes1 = linkedList1.subList(2, 4);
        System.out.println("\nResult of sub list from 2 to 4 indexes");
        System.out.println(integersRes1);

        List<Integer> containsLinkedList = new LinkedList<>();
        containsLinkedList.add(1000);
        containsLinkedList.add(-2);
        containsLinkedList.add(7);
        containsLinkedList.add(4);
        containsLinkedList.add(5);
        containsLinkedList.add(2);
        boolean b1 = arrayList1.containsAll(containsLinkedList);
        System.out.println("\nArrayList1 before check contains");
        System.out.println(arrayList1);
        System.out.println("ContainsArrayList before check contains");
        System.out.println(containsArrayList);
        System.out.println("ContainsArrayList is all in ArrayList1 ?");
        System.out.println(b1);

        Integer[] integers1 = linkedList.toArray(new Integer[0]);
        System.out.println("\nArrayList1 to Integer Array");
        System.out.println(Arrays.toString(integers1));

        List<Integer> linkedListFromOther = new LinkedList<>(arrayList1);
        System.out.println("\nArrayListFromOther from ArrayList1(copy)");
        System.out.println(linkedListFromOther);

        Integer[] mass1 = {2, 4, 6};
        LinkedList<Integer> integerLinkedList = new LinkedList<>(Arrays.asList(mass1));
        System.out.println("\nArray to ArrayList");
        System.out.println(integerLinkedList);

        System.out.println("-------------------------------------------------\n");

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        //Множества
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(8);
        hashSet.add(9);
        hashSet.add(9);
        hashSet.add(1);
        System.out.println("HashSet after add");
        System.out.println(hashSet);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(9);
        linkedHashSet.add(9);
        linkedHashSet.add(7);
        linkedHashSet.add(1);
        System.out.println("\nLinkedHashSet after add");
        System.out.println(linkedHashSet);

        System.out.println("\nIterate for-each HashSet");
        for(int val : hashSet){
            System.out.println(val);
        }

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("b");
        treeSet.add("a");
        treeSet.add("c");
        treeSet.add("a");
        treeSet.add("e");
        System.out.println("\nTreeSet after add");
        System.out.println(treeSet);

        TreeSet<String> treeSetComparator = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        treeSetComparator.add("b");
        treeSetComparator.add("a");
        treeSetComparator.add("c");
        treeSetComparator.add("a");
        treeSetComparator.add("e");
        System.out.println("\nTreeSet with Comparator after add");
        System.out.println(treeSetComparator);

        /*TODO HashSet, LinkedHashSet и TreeSet имют такой же
           набор методов и конструкторов, что и у списков,
           ЗА ИСКЛЮЧЕНИЕМ методов работы с индексамм!!!
           самостоятельно произвести вызов каждого
           такого метода для HashSet, убедиться в правильности работы*/
        System.out.println("\n------------------------------------------------");

        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet1.add(1);
        hashSet1.contains(1);
        hashSet1.equals(hashSet2);
        hashSet1.remove(1);
        hashSet1.clear();
        hashSet1.isEmpty();
        hashSet1.removeAll(arrayList1);
        hashSet1.size();
        hashSet1.containsAll(arrayList1);
        Integer[] intarr = hashSet1.toArray(new Integer[0]);
        HashSet<Integer> some = new HashSet<>(arrayList1);

        System.out.println("-------------------------------------------------\n");

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        Set<Integer> set3 = new TreeSet<>();

        //Словари
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("qwe", 1);
        hashMap.put("qwe", 2);
        hashMap.put("tt", 1);
        hashMap.put("yui", 100);
        System.out.println("\nHashMap after add");
        System.out.println(hashMap);

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("qwe", 1);
        linkedHashMap.put("qwe", 2);
        linkedHashMap.put("tt", 1);
        linkedHashMap.put("yui", 100);
        System.out.println("\nLinkedHashMap after add");
        System.out.println(linkedHashMap);

        Integer qwe = hashMap.getOrDefault("qwe", -1);
        System.out.println("\nGet value by key from HashMap. Key exists");
        System.out.println(qwe);

        Integer qer = hashMap.getOrDefault("qer", -1);
        System.out.println("\nGet value by key from HashMap. Key not exists");
        System.out.println(qer);

        linkedHashMap.clear();
        System.out.println("\nLinkedHashMap after clear");
        System.out.println(linkedHashMap);

        boolean resContainsKey = hashMap.containsKey("qwe");
        System.out.println("\nKey qwe exists in HashMap");
        System.out.println(resContainsKey);

        boolean resContainsValue = hashMap.containsValue(100);
        System.out.println("\nValue 100 exists in HashMap");
        System.out.println(resContainsValue);

        boolean resEmpty = hashMap.isEmpty();
        System.out.println("\nHashMap is empty ?");
        System.out.println(resEmpty);

        Integer removeValueByKeyResult = hashMap.remove("qwe");
        System.out.println("\nHashMap after remove value by key qwe");
        System.out.println(hashMap);
        System.out.println("Removed value is");
        System.out.println(removeValueByKeyResult);

        int size13 = hashMap.size();
        System.out.println("Count pairs in HashMap is");
        System.out.println(size13);

        Set<String> strings = hashMap.keySet();
        System.out.println("\nSet of keys in HashMap");
        System.out.println(strings);

        Collection<Integer> values = hashMap.values();
        System.out.println("\nCollection of values in HashMap");
        System.out.println(values);

        System.out.println("\nIterate HashMap");
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for(var pair : entries){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        //Мульти-словарь
        /*
        Input
        6
        qwe 1
        ttt 2
        qwe 4
        ttt 4
        tt 4
        ttt 10
        Output
        {tt=[4], ttt=[2, 4, 10], qwe=[1, 4]}
         */
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String key = scanner.next();
            int value = scanner.nextInt();
            ArrayList<Integer> list = map.getOrDefault(key, new ArrayList<>());
            list.add(value);
            map.put(key, list);
        }
        System.out.println("MultiMap");
        System.out.println(map);

        //Сортировки
        ArrayList<Integer> sorted1 = new ArrayList<>(hashSet);
        sorted1.sort(null);
        LinkedHashSet<Integer> sortedHashSet = new LinkedHashSet<>(sorted1);
        System.out.println("\nSorted HashSet");
        System.out.println(sortedHashSet);

        ArrayList<Map.Entry<String, Integer>> sorted2 = new ArrayList<>(hashMap.entrySet());
        sorted2.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println("\nArrayList of sorted Entries");
        System.out.println(sorted2);
        LinkedHashMap<String, Integer> newHash = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : sorted2) {
            newHash.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }

        //TODO преобразовать данный список пар в новый словарь, сохранив порядок после сортировки

        ArrayList<Map.Entry<String, ArrayList<Integer>>> sorted3 = new ArrayList<>(map.entrySet());
        sorted3.sort(new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<Integer>> o1, Map.Entry<String, ArrayList<Integer>> o2) {
                return Integer.compare(o1.getValue().size(), o2.getValue().size());
            }
        });
        System.out.println("\nArrayList of sorted Entries MultiMap by Values size");
        System.out.println(sorted3);

        //TODO преобразовать данный список пар в новый словарь, сохранив порядок после сортировки
    }
}
