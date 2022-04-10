package com.yos.koperasi.anggota.manager;

import com.yos.koperasi.ResponseManager;
import com.yos.koperasi.anggota.model.Anggota;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AnggotaManager {

    ResponseManager<Page<Anggota>> getList(int page, int size);

    ResponseManager<Anggota> addAnggota(Anggota anggota);
}
