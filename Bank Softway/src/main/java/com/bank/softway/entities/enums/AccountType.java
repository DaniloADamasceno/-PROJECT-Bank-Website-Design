package com.bank.softway.entities.enums;

import lombok.Getter;

@Getter
public enum AccountType {

    /*
        Savings Account <|--|> Conta Poupança
            Usada para transações do dia a dia, como depósitos, saques, transferências e pagamentos de contas.
            Pode oferecer um talão de cheques e um cartão de débito.
     */
    SAVINGS_ACCOUNT(1, "Savings Account <||> Conta Poupança"),

    /*
        Current Account <|--|> Conta Corrente
            Destinada a economias e geralmente oferece taxas de juros mais altas do que as contas correntes.
            Pode ter limites de saques mensais.
     */
    CURRENT_ACCOUNT(2, "Current Account <||> Conta Corrente"),

    /*
        Salary Account <|--|> Conta Salário
            É uma conta na qual o empregador deposita o salário do funcionário.
            Pode ter benefícios específicos, como isenção de tarifas.
     */
    SALARY_ACCOUNT(3, "Salary Account <||> Conta Salário"),

    /*
        Join Account <|--|> Conta Conjunta
            Uma conta compartilhada por duas ou mais pessoas, como cônjuges ou parceiros de negócios.
     */
    JOIN_ACCOUNT(4, "Join Account <||> Conta Conjunta"),

    /*
        Digital Account <|--|> Conta Digital
           Uma conta compartilhada por duas ou mais pessoas, como cônjuges ou parceiros de negócios.
     */
    DIGITAL_ACCOUNT(5, "Digital Account <||> Conta Digital"),

    /*
        Investment Account <|--|> Conta de Investimento
            Usada para investir em diferentes instrumentos financeiros, como ações, títulos e fundos mútuos.
     */
    INVESTMENT_ACCOUNT(6, "Investment Account <||> Conta de Investimento"),

    /*
        Business Account <|--|> Conta Empresarial
            Similar à conta corrente individual, mas voltada para empresas.
     */
    BUSINESS_ACCOUNT(7, "Business Account <||> Conta Empresarial");

    private final int codeAccountType;
    private final String descriptionAccountType;

    // ? ----------------------------------------   CONSTRUCTOR   -------------------------------------------------------
    private AccountType(int code, String description) {
        this.codeAccountType = code;
        this.descriptionAccountType = description;
    }

    // ? ----------------------------------------   METHODS   ----------------------------------------------------------
    public static AccountType valueOf(int code) {
        for (AccountType value : AccountType.values()) {
            if (value.getCodeAccountType() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid AccountType code | Código de Tipo de Conta inválido");
    }
}
