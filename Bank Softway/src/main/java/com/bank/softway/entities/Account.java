package com.bank.softway.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_accounts")
public class Account implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)             // --> Auto incremento no banco de dados
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_account_user_id")
    private User IdAccountUser;

    private Double balance;
    private String typeAccount;
    private Double limitAccount;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private User userAccount;

    List<Transaction> bankingOperations;

}
