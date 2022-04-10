package com.yos.koperasi.transaksi.model;

import com.yos.koperasi.anggota.model.Anggota;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_transaksi")
@Setter
@Getter
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_anggota")
    private long id_anggota;

    @Column(name = "amount")
    @Min(0)
    private Long amount;

    @Column(name = "transaction_date")
    private Long transaction_date;

    @Column(name = "type", length = 2)
    private String type;

    @Column(name = "status", length = 1)
    private String status;
//
//    @Transient
//    private Anggota anggota;

    public Transaksi() {

    }
}
