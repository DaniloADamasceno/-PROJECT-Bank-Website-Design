package com.bank.user_bank.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "table_perfil")
@Getter
@Setter
public class Profile implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profileName;

    //?----------------------------------------------  Constructors  ---------------------------------------------------
    public Profile() {
    }

    public Profile(Long id, String profileName) {
        this.id = id;
        this.profileName = profileName;
    }

    //? -------------------------------------------   HashCode & Equals  -----------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile profile)) return false;

        if (!id.equals(profile.id)) return false;
        return profileName.equals(profile.profileName);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + profileName.hashCode();
        return result;
    }
}
