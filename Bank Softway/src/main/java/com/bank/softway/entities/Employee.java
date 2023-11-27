package com.bank.softway.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tb_employees")
public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // --> Auto incremento no banco de dados
    private Long idEmployee;

    private String nameEmployee;
    private String LastNameEmployee;

    private String positionEmployee;
    private String hiringDate;
    private Double salaryEmployee;

    // ?--------------------------------------------- Constructors -----------------------------------------------------

    public Employee() {
        super();
    }

    public Employee(Long idEmployee, String nameEmployee, String lastNameEmployee, String positionEmployee, String hiringDate, Double salaryEmployee) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        LastNameEmployee = lastNameEmployee;
        this.positionEmployee = positionEmployee;
        this.hiringDate = hiringDate;
        this.salaryEmployee = salaryEmployee;
    }

    // ? ---------------------------------------------  HashCode and Equals --------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;

        return getIdEmployee().equals(employee.getIdEmployee());
    }

    @Override
    public int hashCode() {
        return getIdEmployee().hashCode();
    }

    // ? ---------------------------------------------  toString -------------------------------------------------------

    @Override
    public String toString() {
        return "Employee | Funcionario " +
                "ID =" + idEmployee +
                ", name| Nome ='" + nameEmployee + '\'' +
                ", LastNameEmployee='" + LastNameEmployee.charAt(0) + '\'' +  // Mostrar apenas a primeira letra do sobrenome
                ", Position Employee | Cargo ='" + positionEmployee + '\'' +
                ", Hiring Date | Data de Contratação='" + hiringDate + '\'' +
                ", Salary | Salario =" + salaryEmployee +
                '}';
    }
}
