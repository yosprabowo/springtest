package com.yos.koperasi.transaksi.repo;

import com.yos.koperasi.transaksi.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
    List<Transaksi> findAll();

    @Query("select SUM(s.amount) from Transaksi s where s.type = :type and s.id_anggota = :idAnggota")
    Long totalAmount(Long idAnggota, String type);

    @Query("select s from Transaksi s where s.id_anggota = :idAnggota")
    List<Transaksi> findAllByAnggotaId(Long idAnggota);

    @Query("select s from Transaksi s where s.transaction_date > :startDate and s.transaction_date < :endDate")
    List<Transaksi> findAllByRangeDate(Long startDate, Long endDate);

}
