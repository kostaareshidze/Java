package pgdp.company;
import pgdp.tree.Node;
import pgdp.tree.Tree;

import java.util.*;

public class Company<T> {

    private Employee CEO;
    private Tree<Integer> employeesTree;
    private Map<Integer,Employee> employees;
    private Queue<Integer> availableIDs;
    private static int availableID = 1;
    private String name;

    public Company(String name, Employee CEO) {
        this.name = name;
        this.CEO = CEO;
        employeesTree = new Tree<>(0);
        availableIDs = new PriorityQueue<>();
        employees = new HashMap<>();
        employees.put(0,CEO);
    }

    public void addEmployee(Employee newEmployee) {

        if (newEmployee.getBoss() != null){
            Object[] array = availableIDs.toArray();
            Arrays.sort(array);
            newEmployee.setID((Integer) array[0]);
        }
        if (newEmployee.getID() == availableID)
            availableID++;
        employeesTree.insert(newEmployee.getID(), newEmployee.getBoss().getID());
        employees.put(newEmployee.getID(), newEmployee);
        availableIDs.remove(newEmployee.getID());

    }

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public void fireEmployee(int ID) {
        if (employees.get(ID) != null && CEO.getID() != ID){
            employeesTree.remove(ID);
            employees.remove(ID);
            availableIDs.add(ID);
        }

    }

    public Employee findCommonBoss(Employee e1, Employee e2) {
        return employees.get(employeesTree.LCA(e1.getID(), e2.getID()));
    }

    public Employee findByID(int ID) {
       if (employeesTree.containsKey(ID))
           return employees.get(ID);
       else return null;
    }

}
