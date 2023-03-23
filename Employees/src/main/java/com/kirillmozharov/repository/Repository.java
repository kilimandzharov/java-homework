package com.kirillmozharov.repository;

import com.kirillmozharov.model.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Repository {
    HashMap<Integer, ArrayList<Employee>> employeesMap;

    public Repository(String source) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] vals = line.split(";");
                int departmentCode = Integer.parseInt(vals[2]);
                Employee employee = new Employee(vals[0], vals[1], departmentCode, Double.parseDouble(vals[3]));
                ArrayList<Employee> employees = employeesMap.getOrDefault(departmentCode, new ArrayList<>());
                employees.add(employee);
                employeesMap.put(departmentCode, employees);
            }
        }
    }

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

    public HashMap<Integer, ArrayList<Employee>> getCoolestEmployees() {
        HashMap<Integer, ArrayList<Employee>> result = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : this.employeesMap.entrySet()) {
            ArrayList<Employee> employees = integerArrayListEntry.getValue();
            ArrayList<Employee> bestByDepartment = new ArrayList<>();
            double bestScore = 0.0;
            for (Employee employee : employees) {
                if (employee.getRating() > bestScore) {
                    bestScore = employee.getRating();
                }
            }
            for (Employee employee : employees) {
                if (employee.getRating() == bestScore) {
                    bestByDepartment.add(employee);
                }
            }
            result.put(integerArrayListEntry.getKey(), bestByDepartment);

        }

        return result;
    }

    public HashMap<Integer, Double> getAverageScores() {
        HashMap<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<Employee>> employeeItem : employeesMap.entrySet()) {
            ArrayList<Employee> employees = employeeItem.getValue();
            double sum = 0.0;
            for (Employee employee : employees) {
                sum += employee.getRating();
            }

            result.put(employeeItem.getKey(), sum / employees.size());
        }
        return result;
    }

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

    public Double getMaxScoresSubCoolestEmployees() {
        ArrayList<Employee> bestOfAll = this.getCoolestEmployeesAll();
        double max = 0.0;
        for (Employee employee : bestOfAll) {
            if (employee.getRating() > max) {
                max = employee.getRating();
            }
        }
        return max;
    }

    public HashMap<Integer, ArrayList<Employee>> getSubCoolestEmployees() {
        HashMap<Integer, Double> maxScores = this.getMaxScores();
        HashMap<Integer, ArrayList<Employee>> result = new HashMap<>();
        ArrayList<Employee> subBesEmployeesAll = new ArrayList<>();
        double globalMax = 0;
        double secGlobalMax = 0;
        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : this.employeesMap.entrySet()) {
            ArrayList<Employee> subBestEmployeesByDepartment = new ArrayList<>();
            double localMax = maxScores.get(integerArrayListEntry.getKey());
            double secLocalMax = 0;
            for (Employee employee : integerArrayListEntry.getValue()) {
                if (employee.getRating() > secLocalMax && employee.getRating() < localMax) {
                    localMax = employee.getRating();
                }
                if (employee.getRating() > secGlobalMax && employee.getRating() < globalMax) {
                    secGlobalMax = globalMax;
                    globalMax = employee.getRating();
                }
            }

            for (Employee employee : integerArrayListEntry.getValue()) {
                if (employee.getRating() == secLocalMax) {
                    subBestEmployeesByDepartment.add(employee);
                }
            }
            result.put(integerArrayListEntry.getKey(), subBestEmployeesByDepartment);
        }

        for (Map.Entry<Integer, ArrayList<Employee>> integerArrayListEntry : this.employeesMap.entrySet()) {
            for (Employee employee : integerArrayListEntry.getValue()) {
                if (employee.getRating() == secGlobalMax) {
                    subBesEmployeesAll.add(employee);
                }
            }
        }
        result.put(-1, subBesEmployeesAll);
        return result;
    }

    public ArrayList<Integer> getMaxCountDepartments() {
        int maxSize = 0;
        ArrayList<Integer> result = new ArrayList<>();
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

        result.sort(null);
        return result;

    }

    public ArrayList<Integer> getMinCountDepartments() {
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
        return result;
    }

    public ArrayList<Integer> departmentCoolestEmployees() {
        HashSet<Integer> departmentsWithBestSet = new HashSet<>();
        ArrayList<Employee> employees = this.getCoolestEmployeesAll();
        for (Employee employee : employees) {
            departmentsWithBestSet.add(employee.getDepartmentCode());
        }
        ArrayList<Integer> result = new ArrayList<>(departmentsWithBestSet);
        result.sort(null);
        return result;
    }

}
