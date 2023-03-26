package com.kirillmozharov.repository;

import com.kirillmozharov.model.Employee;
import com.kirillmozharov.utils.SortType;

import java.io.*;
import java.util.*;

public class Repository {
    private HashMap<Integer, ArrayList<Employee>> employeesMap = new HashMap<>();

    public Repository(String source) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            while (bufferedReader.ready()) {
                try {
                    String line = bufferedReader.readLine();
                    String[] vals = line.split(";");
                    int departmentCode = Integer.parseInt(vals[2]);
                    Employee employee = new Employee(vals[0], vals[1], departmentCode, Double.parseDouble(vals[3]));
                    ArrayList<Employee> employees = employeesMap.getOrDefault(departmentCode, new ArrayList<>());
                    employees.add(employee);
                    employeesMap.put(departmentCode, employees);
                }  catch (RuntimeException ignored) {}
            }
        }
    }

    public void save(String source, SortType sortType) throws IOException {
        ArrayList<Employee> result = this.sort(sortType);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(source))) {
            bufferedWriter.write("Фамилия;Имя;номер;рейтинг");
            for (Employee employee : result) {
                bufferedWriter.write(employee.toCSV());
                bufferedWriter.write("\n");
            }
        }
    }

    /**
     * getMaxScores
     * Вернуть рейтинг самых успешных сотрудников в каждом отделе
     *
     * @return
     */
    public HashMap<Integer, Double> getMaxScores() {
        HashMap<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<Employee>> employeeItem : employeesMap.entrySet()) {
            ArrayList<Employee> employees = employeeItem.getValue();
            double max = 0.0;
            for (Employee employee : employees) {
                if (employee.getRating() > max) {
                    max = employee.getRating();
                }
            }
            result.put(employeeItem.getKey(), max);
        }
        return result;
    }

    /**
     * getCoolestEmployees
     * Определить самых успешных сотрудников по каждому отделу
     *
     * @return
     */
    public HashMap<Integer, ArrayList<Employee>> getCoolestEmployees() {
        HashMap<Integer, ArrayList<Employee>> result = new HashMap<>();
        //TODO тут вызвать прошлый метод
        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : this.employeesMap.entrySet()) {
            ArrayList<Employee> employees = integerArrayListEntry.getValue();
            ArrayList<Employee> bestByDepartment = new ArrayList<>();
            double bestScore = ;
            for (Employee employee : employees) {
                if (employee.getRating() == bestScore) {
                    bestByDepartment.add(employee);
                }
            }
            result.put(integerArrayListEntry.getKey(), bestByDepartment);

        }

        return result;
    }

    /**
     * getAverageScores
     * Вернуть в виде коллекции средний рейтинг сотрудников по каждому отделу
     *
     * @return
     */
    public HashMap<Integer, Double> getAverageScores() {
        HashMap<Integer, Double> result = new HashMap<>();
        double allSum = 0;
        int allSize = 0;
        for (Map.Entry<Integer, ArrayList<Employee>> employeeItem : employeesMap.entrySet()) {
            ArrayList<Employee> employees = employeeItem.getValue();
            double sum = 0.0;
            for (Employee employee : employees) {
                sum += employee.getRating();
            }

            result.put(employeeItem.getKey(), sum / employees.size());
            allSum += sum;
            allSize += employees.size();
        }
        result.put(-1, allSum / allSize);
        return result;
    }

    /**
     * getCountCoolestEmployees
     * Определить количество самых успешных сотрудников по каждому отделу
     *
     * @return
     */
    public HashMap<Integer, Integer> getCountCoolestEmployees() {
        HashMap<Integer, Integer> result = new HashMap<>();
        HashMap<Integer, ArrayList<Employee>> coolestEmployees = this.getCoolestEmployees();
        for (Map.Entry<Integer, ArrayList<Employee>> employeeItem : coolestEmployees.entrySet()) {
            ArrayList<Employee> bestOnes = employeeItem.getValue();
            int counter = bestOnes.size();
            result.put(employeeItem.getKey(), counter);
        }
        return result;
    }

    /**
     * getCoolestEmployeesAll
     * Определить самых успешных сотрудников по всем отделам
     *
     * @return
     */
    public ArrayList<Employee> getCoolestEmployeesAll() {
        ArrayList<Employee> result = new ArrayList<>();
        HashMap<Integer, Double> coolestScores = this.getMaxScores();
        double coolestScore = 0.0;
        for (Map.Entry<Integer, Double> integerDoubleEntry : coolestScores.entrySet()) {
            if (integerDoubleEntry.getValue() > coolestScore) {
                coolestScore = integerDoubleEntry.getValue();
            }
        }
        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : this.employeesMap.entrySet()) {
            ArrayList<Employee> employees = integerArrayListEntry.getValue();
            for (Employee employee : employees) {
                if (employee.getRating() == coolestScore) {
                    result.add(employee);
                }
            }
        }
        return result;
    }

    /**
     * getMaxScoresSubCoolestEmployees
     * Определить рейтинг сотрудников, не ставших самыми успешными, но следующих сразу
     * же после успешных по каждому отделу и по всем отделам, написав только один метод
     *
     * @return
     */
    public HashMap<Integer, Double> getMaxScoresSubCoolestEmployees() {
        /*if (employee.getRating() > secLocalMax && employee.getRating() < localMax) {
            localMax = employee.getRating();
        }
        if (employee.getRating() > secGlobalMax && employee.getRating() < globalMax) {
            secGlobalMax = globalMax;
            globalMax = employee.getRating();
        }*/

        /*for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : this.employeesMap.entrySet()) {
            for (Employee employee : integerArrayListEntry.getValue()) {
                if (employee.getRating() == secGlobalMax) {
                    subBesEmployeesAll.add(employee);
                }
            }
        }
        result.put(-1, subBesEmployeesAll);*/
    }

    /**
     * getSubCoolestEmployees
     * Определить сотрудников, не ставших самыми успешными, но следующих
     * сразу же после успешных по каждому отделу
     *
     * @return
     */
    public HashMap<Integer, ArrayList<Employee>> getSubCoolestEmployees() {
        HashMap<Integer, ArrayList<Employee>> result = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : this.employeesMap.entrySet()) {
            ArrayList<Employee> subBestEmployeesByDepartment = new ArrayList<>();
            double secLocalMax = ;
            for (Employee employee : integerArrayListEntry.getValue()) {
                if (employee.getRating() == secLocalMax) {
                    subBestEmployeesByDepartment.add(employee);
                }
            }
            result.put(integerArrayListEntry.getKey(), subBestEmployeesByDepartment);
        }
        return result;
    }

    /**
     * getMaxCountDepartments
     * Вернуть в порядке возрастания номера департаментов,
     * где работает больше всего сотрудников
     *
     * @return
     */
    public HashSet<Integer> getMaxCountDepartments() {
        int maxSize = 0;
        HashSet<Integer> result = new HashSet<>();
        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : this.employeesMap.entrySet()) {
            int localSize = integerArrayListEntry.getValue().size();
            if (localSize > maxSize) {
                maxSize = localSize;
            }
        }
        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : this.employeesMap.entrySet()) {
            int localSize = integerArrayListEntry.getValue().size();
            if (localSize == maxSize) {
                result.add(integerArrayListEntry.getKey());
            }
        }

        return result;

    }

    /**
     * getMinCountDepartments
     * Вернуть в порядке возрастания номера департаментов,
     * где работает меньше всего сотрудников
     *
     * @return
     */
    public HashSet<Integer> getMinCountDepartments() {
        int minSize = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : this.employeesMap.entrySet()) {
            int localSize = integerArrayListEntry.getValue().size();
            if (localSize < minSize) {
                minSize = localSize;
            }
        }
        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : this.employeesMap.entrySet()) {
            int localSize = integerArrayListEntry.getValue().size();
            if (localSize == minSize) {
                result.add(integerArrayListEntry.getKey());
            }
        }
        result.sort(null);
        return result; //TODO без сортировки
    }

    /**
     * departmentCoolestEmployees
     * Вычислить номера департаментов в порядке возрастания, в которых есть хотя бы один сотрудник,
     * ставший самым успешным по всем департаментам
     *
     * @return
     */
    public HashSet<Integer> departmentCoolestEmployees() {
        HashSet<Integer> departmentsWithBestSet = new HashSet<>();
        ArrayList<Employee> employees = this.getCoolestEmployeesAll();
        for (Employee employee : employees) {
            departmentsWithBestSet.add(employee.getDepartmentCode());
        }
        return departmentsWithBestSet;
    }

    /**
     * •	sort
     * Отсортировать коллекцию сотрудников по фамилии, при равенстве фамилии по имени
     * •	sort
     * Отсортировать коллекцию сотрудников:
     * •	По убыванию рейтинга
     * •	При равных значениях рейтинга - по фамилии в лексикографическом порядке
     * •	При совпадении рейтинга и фамилии - по имени в лексикографическом порядке
     * Объединить сортировки из 12 и 13 пунктов в единый метод, используя перечисления(enums)
     *
     * @param flag
     */
    public ArrayList<Employee> sort(SortType flag) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : this.employeesMap.entrySet()) {
            result.addAll(integerArrayListEntry.getValue());
        }
        switch (flag) {
            case BY_FULL_NAME: {
                result.sort(null);
                break;
            }
            case BY_DESC_RATING_AND_FULL_NAME: {
                result.sort(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        if (Double.compare(o1.getRating(), o2.getRating()) != 0) {
                            return -Double.compare(o1.getRating(), o2.getRating());
                        }
                        return o1.compareTo(o2);
                    }
                });
                break;
            }
        }
        return result;
    }

    /**
     * greatAverageScoreDepartments
     * Вычислить в порядке возрастания номера департаментов, средний рейтинг сотрудников которых выше,
     * чем средний рейтинг всех сотрудников в компании. То есть необходимо вычислить средний рейтинг для
     * каждого департамента отдельно и средний рейтинг по всем департаментам вместе взятых.
     * Модернизировать метод из п. 4 таким образом, чтобы он возвращал среднее не только по отделам,
     * но и по департаментам
     *
     * @return
     */
    public HashSet<Integer> greatAverageScoreDepartments() {
        HashMap<Integer, Double> averageScores = this.getAverageScores();
        HashSet<Integer> result = new HashSet<>();
        Double commonAvgRating = averageScores.get(-1);
        for (Map.Entry<Integer, Double> integerDoubleEntry : averageScores.entrySet()) {
            if (integerDoubleEntry.getValue() > commonAvgRating) {
                result.add(integerDoubleEntry.getKey());
            }
        }
        return result;
    }

    /**
     * Вычислить в порядке возрастания номера департаментов,
     * средний рейтинг сотрудников которых максимален
     *
     * @return
     */
    public HashSet<Integer> maxAverageScoreDepartments() {
        HashMap<Integer, Double> averageScores = this.getAverageScores();
        HashSet<Integer> result = new HashSet<>();
        double maxAvg = 0;
        for (Map.Entry<Integer, Double> integerDoubleEntry : averageScores.entrySet()) {
            if (integerDoubleEntry.getValue() > maxAvg) {
                maxAvg = integerDoubleEntry.getKey();
            }
        }

        for (Map.Entry<Integer, Double> integerDoubleEntry : averageScores.entrySet()) {
            if (integerDoubleEntry.getValue() == maxAvg) {
                result.add(integerDoubleEntry.getKey());
            }
        }

        return result;
    }

    /**
     * sortByAverageScores
     * Вернуть номера департаментов в порядке убывания среднего рейтинга сотрудников,
     * работающих в этих департаментах. Если в двух департаментах имеется одинаковый
     * средний рейтинг сотрудников, то их номера выводятся в порядке возрастания номера департамента
     *
     * @return
     */
    public ArrayList<Integer> sortByAverageScores() {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Map.Entry<Integer, Double>> entryArrayList = new ArrayList<>(this.getAverageScores().entrySet());
        entryArrayList.sort(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                if (Double.compare(o1.getValue(), o2.getValue()) != 0) {
                    return -Double.compare(o1.getValue(), o2.getValue());
                }
                return Integer.compare(o1.getKey(), o2.getKey());
            }
        });
        for (Map.Entry<Integer, Double> integerDoubleEntry : entryArrayList) {
            result.add(integerDoubleEntry.getKey());
        }
        Integer valueToRemove = -1;
        result.remove(valueToRemove);

        return result;
    }

    /**
     * sortByCountEmployees
     * Вернуть номера департаментов в порядке убывания количества сотрудников, работающих в этих департаментах.
     * Если в двух департаментах работает одинаковое количество сотрудников, то их номера выводятся в порядке
     * возрастания номера департамента
     *
     * @return
     */
    public ArrayList<Integer> sortByCountEmployees() {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Map.Entry<Integer, ArrayList<Employee>>> entryArrayList =
                new ArrayList<>(this.employeesMap.entrySet());
        entryArrayList.sort(new Comparator<Map.Entry<Integer, ArrayList<Employee>>>() {
            @Override
            public int compare(Map.Entry<Integer, ArrayList<Employee>> o1, Map.Entry<Integer, ArrayList<Employee>> o2) {
                if (o1.getValue().size() != o2.getValue().size()) {
                    return -Integer.compare(o1.getValue().size(), o2.getValue().size());
                }
                return Integer.compare(o1.getKey(), o2.getKey());
            }
        });
        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : entryArrayList) {
            result.add(integerArrayListEntry.getKey());
        }
        return result;
    }

    /**
     * maxCountCoolestEmployeeDepartments
     * Вернуть в порядке возрастания номера департаментов,
     * из которых наибольшее количество сотрудников стало самыми успешными
     *
     * @return
     */
    public HashSet<Integer> maxCountCoolestEmployeeDepartments() {
        HashSet<Integer> result = new HashSet<>();
        int maxCoolestEmps = 0;
        List<Map.Entry<Integer, ArrayList<Employee>>> entrySet = new ArrayList<>(this.getCoolestEmployees().entrySet());
        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : entrySet) {
            if (integerArrayListEntry.getValue().size() > maxCoolestEmps) {
                maxCoolestEmps = integerArrayListEntry.getValue().size();
            }
        }
        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : entrySet) {
            if (integerArrayListEntry.getValue().size() == maxCoolestEmps) {
                result.add(integerArrayListEntry.getValue().size());
            }
        }

        return result;
    }
}