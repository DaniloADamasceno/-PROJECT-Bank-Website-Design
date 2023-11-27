package com.bank.softway.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import com.bank.softway.entities.enums.Profile;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // --> Auto incremento no banco de dados
    private Long id;
    private String name;
    private String lastName;

    @CPF
    @Column(unique = true)                                  //--> Para não permitir repetição de CPF
    private String cpf;

    @Column(unique = true)                                  //--> Para não permitir repetição de email
    private String email;
    private String password;

    @JsonFormat(pattern = "dd/MM/yyyy")                     //-> Formatação da data
    private Number birthDate;
    private String cep;
    private String address;
    private String country;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "tb_perfil_usuario",
//            joinColumns = @JoinColumn(name = "usuario_id"),
//            inverseJoinColumns = @JoinColumn(name = "perfil_id")
//    )
    @ElementCollection(fetch = FetchType.EAGER)             //-> Garante que não vai repetir o mesmo valor
    @CollectionTable(name = "PROFILE")                      //-> Nome da tabela que vai ser criada
    private Set<Integer> profiles = new HashSet<>();

    // ?--------------------------------------------- Constructors -----------------------------------------------------
    public User() {
        super();
        addProfile(Profile.NOVICE);                             //-> Todos os novos Usuários são cadastrados como Iniciantes

    }

    public User(Long id, String name, String lastName, String cpf, String email, String password, Number birthDate ) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        addProfile(Profile.NOVICE);                             //-> Todos os novos Usuários são cadastrados como Iniciantes
    }

    // ? ---------------------------------------------  Getters and Setters --------------------------------------------
    public Set<Profile> getProfile() {
        return profiles.stream().map(Profile::toEnum)
                .collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile.getCod());
    }

    // ? ---------------------------------------------  HashCode and Equals --------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!getId().equals(user.getId())) return false;
        return getCpf().equals(user.getCpf());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCpf().hashCode();
        return result;
    }
}
