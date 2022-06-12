
package com.mycompany.zadanie1_jdbc.maven;


public class zadanie1_jdbc {

    
    public static void main(String[] args) {
        EmployeeDAO dao =new EmployeeDAO();
         Employee p1=new Employee("Kasia","Kowalska",28,"123456987","jan.kowalski@op.pl");
         dao.add(p1);
        
    }
    
}
