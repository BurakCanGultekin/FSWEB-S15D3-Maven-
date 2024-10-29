package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    private static Map<Integer, Employee> uniqueMap;
    private static List<Employee> duplicateList;

    public static void main(String[] args) {

        List<Employee> emplooyeList = new LinkedList();
        Employee employee = new Employee(1, "burak","gultekin");
        Employee employee2 = new Employee(2, "gurkan","gultekin");
        Employee employee3 = new Employee(1, "ahmet","yılmaz");
        Employee employee4 = new Employee(3, "veli","kara");
        Employee employee5 = new Employee(4, "mehmet","aydin");
        emplooyeList.add(employee);
        emplooyeList.add(employee2);
        emplooyeList.add(employee3);
        emplooyeList.add(employee4);
        emplooyeList.add(employee5);
        emplooyeList.add(employee2);
        emplooyeList.add(employee);

        System.out.println("duplicates : " + findDuplicates(emplooyeList));
        System.out.println("uniques : " + findUniques(emplooyeList));
        System.out.println("onlyUniques : " + removeDuplicates(emplooyeList));
        System.out.println("**************************");

        Map<String, Integer> test = WordCounter.calculatedWord();
        for(Map.Entry<String, Integer> entry : test.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
    public static List<Employee> findDuplicates (List<Employee> list){
        uniqueMap = new HashMap<>();
        duplicateList = new LinkedList<>();
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee == null){
                System.out.println("Null");
                continue;
            }
            if(uniqueMap.containsKey(employee.getId())){
                duplicateList.add(employee);
            }
            else {
                uniqueMap.put(employee.getId(),employee);
            }
        }
        return duplicateList;
    }
    public static Map<Integer, Employee> findUniques (List<Employee> list){
        uniqueMap = new HashMap<>();
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee == null){
                System.out.println("Null");
                continue;
            }
            if(!uniqueMap.containsKey(employee.getId())){
                uniqueMap.put(employee.getId(),employee);
            }
        }
        return uniqueMap;
    }
    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUniqeu = new LinkedList<>(uniques.values());
        onlyUniqeu.removeAll(duplicates);
        return onlyUniqeu;
    }


}

