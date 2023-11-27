package com.bank.softway.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class Transaction implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)            // --> Auto incremento no banco de dados
    private Long idTransaction;

    private String typeTransaction;
    private Double valueTransaction;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT") // --> Formatação da data
    private Date dateTransaction;

    private Double accountOrigin;                               // --> Conta de origem
    private Double accountDestination;                          // --> Conta de destino

    //? --------------------------------------------   Constructors   --------------------------------------------------
    public Transaction() {
        super();
    }

    public Transaction(Long idTransaction, String typeTransaction, Double valueTransaction, Date dateTransaction,
                       Double accountOrigin, Double accountDestination) {
        this.idTransaction = idTransaction;
        this.typeTransaction = typeTransaction;
        this.valueTransaction = valueTransaction;
        this.dateTransaction = dateTransaction;
        this.accountOrigin = accountOrigin;
        this.accountDestination = accountDestination;
    }


}
