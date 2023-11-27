package com.bank.softway.entities.enums;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
public enum Profile {

    /*
     Conservador: Conservador é o investidor que busca preservar o seu capital.
            --> Prefere investimentos de baixo risco.
            --> Busca preservar o capital.
            --> Tolerância ao risco é baixa.
     */
    CONSERVATIVE(0, "CONSERVATIVE_INVESTOR"),

    /*
        Moderado: Aceita algum nível de risco em busca de retornos moderados.
               --> Pode ter uma combinação de investimentos de baixo e médio risco.
               --> Busca um equilíbrio entre preservação de capital e crescimento.
        */
    MODERATE(1, "MODERATE_INVESTOR"),

    /*
     Agressivo: Disposto a assumir riscos substanciais em busca de retornos mais elevados.
            --> Pode investir em ativos de alto risco, como ações voláteis.
            --> Tolerância ao risco é alta.
     */
    AGGRESSIVE(2, "AGGRESSIVE_INVESTOR"),

    /*
     Day Trader: Realiza transações diárias para aproveitar movimentos de curto prazo no mercado.
            --> Tolerância ao risco pode variar, mas muitas vezes é mais alta devido à natureza de curto prazo das operações.
     */
    DAY_TRADER(3, "DAY_TRADER"),

    /*
     Investidor de longo prazo: Foca em investimentos para o longo prazo.
            --> Menos preocupado com flutuações de curto prazo.
            --> Pode tolerar mais risco devido ao horizonte de investimento mais extenso.
     */
    LONG_TERM(4, "LONG_TERM_INVESTOR"),

    /*
     Investidor Socialmente Responsável (ISR): Considera critérios éticos e sociais ao fazer investimentos.
            --> Prefere investir em empresas que seguem práticas sustentáveis e éticas.
     */
    RESPONSIBLE_SOCIAL(5, "RESPONSIBLE_SOCIAL_INVESTOR"),

    /*
     Investidor Sofisticado: Geralmente tem um bom entendimento dos mercados financeiros.
            --> Pode ter acesso a investimentos mais complexos ou alternativos.
     */
    SOPHISTICATED(6, "SOPHISTICATED_INVESTOR"),

    /*
     Novato: Inexperiente em investimentos.
            --> Pode preferir opções mais simples e de baixo risco até ganhar mais conhecimento.
     */
    NOVICE(7, "NOVICE_INVESTOR"),
    /*
     Investidor Institucional: Representa organizações, como fundos de pensão, fundos de investimento, seguradoras, etc.
            --> Tem metas e tolerância ao risco específicas para a instituição que representa.
     */
    INSTITUTIONAL(8, "INSTITUTIONAL_INVESTOR");

    //? -------------------------------------------------  Constructor  ------------------------------------------------
    private Integer cod;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)                 //  --> Auto incremento no banco de dados
    private Long idProfile;

    private Profile(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
        this.idProfile = Long.valueOf(cod);
    }

    //? --------------------------------------------   GETTERS and SETTERS  --------------------------------------------
    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getDescription() {
        return description;
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    //?  -------------------------------------------------  Methods  ---------------------------------------------------

    public static Profile toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Profile numberProfile : Profile.values()) {
            if (cod.equals(numberProfile.getCod())) {
                return numberProfile;
            }
        }
        throw new IllegalArgumentException("⚠️ ⚠️ ️invalid PROFILE ID: / ID invalido de PERFIL ⚠️ ⚠️" + cod);
    }
}








