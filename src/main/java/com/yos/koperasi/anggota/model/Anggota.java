package com.yos.koperasi.anggota.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_anggota")
@Setter
@Getter
public class Anggota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", length = 100)
    @NotBlank(message = "First name is mandatory")
    @Size(min=3, max = 20)
    private String firstName;

    @Column(name = "last_name", length = 100)
    @NotBlank(message = "Last name is mandatory")
    @Size(min=3, max = 20)
    private String lastName;

    @Column(name = "birthdate")
    private Long birthDate;

    @Column(name = "address", length = 100)
    @NotBlank(message = "Address is mandatory")
    private String address;

    public Anggota() {

    }
}
