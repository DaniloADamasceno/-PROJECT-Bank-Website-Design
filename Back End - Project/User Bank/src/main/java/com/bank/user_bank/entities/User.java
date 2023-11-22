package com.bank.user_bank.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "table_usuarios")
@Getter
@Setter
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;

    @Column(unique = true)          //--> Para não permitir repetição de CPF
    private String cpf;

    @Column(unique = true)          //--> Para não permitir repetição de email
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_perfil_usuario",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private Set<Profile> profiles = new HashSet<>();

    // ?--------------------------------------------- Constructors -----------------------------------------------------
    public User() {
    }

    public User(Long id, String name, String lastName, String cpf, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
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
