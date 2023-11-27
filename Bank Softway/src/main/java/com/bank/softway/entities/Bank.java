package com.bank.softway.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "bank")
@Getter
@Setter
public class Bank implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // --> Auto incremento no banco de dados
    private Long idBank;

    @ManyToOne
    @JoinColumn(name = "client_bank_id")
    private User clientBank;
    private String nameBank = "Softway Bank";
    private String cnpjBank = "68.550.264/0001-52";             // --> CNPJ gerado em https://www.4devs.com.br/gerador_de_cnpj
    private String addressBank = "Rua dos Bancos, " +
                                    "nº 0, " +
                                    "Bairro: Jardim das Flores Bancarias," +
                                    "Cidade: São Paulo," +
                                    " Estado: São Paulo," +
                                    " CEP: 04334-030";

    @OneToOne
    @JoinColumn(name = "responsible_employee_id_employee")
    private Employee responsibleEmployee;                       // --> Funcionario responsável pelo banco

    // ?--------------------------------------------- Constructors -----------------------------------------------------
    public Bank() {
        super();
    }

    public Bank(Long id, User clientBank, String nameBank, String cnpjBank, String addressBank) {
        this.idBank = id;
        this.clientBank = clientBank;
        this.nameBank = nameBank;
        this.cnpjBank = cnpjBank;
        this.addressBank = addressBank;
    }

    // ? ---------------------------------------------  HashCode and Equals --------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bank bank)) return false;

        return getIdBank().equals(bank.getIdBank());
    }

    @Override
    public int hashCode() {
        return getIdBank().hashCode();
    }

    // ? ---------------------------------------------  ToSTRING -------------------------------------------------------
    @Override
    public String toString() {
        return "Bank"+ nameBank + '\'' +
                "ID= " + idBank + '\'' +
//                " Client Bank | Cliente = " + clientBank.getName() + clientBank.getLastName() +
                " CNPJ = " + cnpjBank + '\'' +
                ", Address = " + addressBank + '\'';
    }
}
