package com.yos.koperasi.anggota.repo;

import com.yos.koperasi.anggota.model.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnggotaRepository extends JpaRepository<Anggota, Long> {
    List<Anggota> findAll();

}
