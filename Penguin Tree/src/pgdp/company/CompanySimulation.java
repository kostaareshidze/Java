package pgdp.company;

import pgdp.tree.Tree;

import java.util.Scanner;

public class CompanySimulation {
    public static void main(String[] args) {
        simulation("Novak","ATP");
    }

    private static void simulation(String ceoName, String companyName) {
        Employee ceo = new Employee(ceoName,null);
        ceo.setID(0);
        Company company = new Company(companyName,ceo);
        Scanner scanner = new Scanner(System.in);
        String numberOfQueries = scanner.nextLine();
        Employee s = new Employee("saba", ceo);
        company.addEmployee(s);

        for (int k = 0; k < Integer.parseInt(numberOfQueries); k++) {
            String query = scanner.nextLine();
            String[] array = query.split(" ");
            if (array.length == 2) {
                if (array[0].equals("EmployeeWithID") && company.getEmployees().get(Integer.parseInt(array[1]))!=null)
                    System.out.println(company.getEmployees().get(Integer.parseInt(array[1])));
                if (array[0].equals("Fire") && company.getEmployees().containsKey(Integer.parseInt(array[1])))
                    company.fireEmployee(Integer.parseInt(array[1]));
            }if (array.length == 3){
                if (array[0].equals("FindCommonBoss") && company.getEmployees().containsKey(Integer.parseInt(array[1]))
                && company.getEmployees().containsKey(Integer.parseInt(array[2])))
                    System.out.println(company.findCommonBoss(company.findByID(Integer.parseInt(array[1])),
                            company.findByID(Integer.parseInt(array[2]))));
                if (array[0].equals("Add") && company.getEmployees().containsKey(Integer.parseInt(array[2]))){
                    var employee = new Employee(array[1], (Employee) company.getEmployees().get(Integer.parseInt(array[2])));
                    company.addEmployee(employee);

                }


            }
        }
        scanner.close();
    }
}
