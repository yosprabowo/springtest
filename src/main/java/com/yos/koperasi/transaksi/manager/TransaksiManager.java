package com.yos.koperasi.transaksi.manager;

import com.yos.koperasi.ResponseManager;
import com.yos.koperasi.transaksi.model.Transaksi;
import org.springframework.data.domain.Page;

public interface TransaksiManager {

    ResponseManager<Page<Transaksi>> getList(int page, int size);

    ResponseManager<Page<Transaksi>> getListById(Long idAnggota);

    ResponseManager<Page<Transaksi>> getListByDate(Long startDate, Long endDate);

    ResponseManager<Transaksi> addTransaksi(Transaksi transaksi);

    ResponseManager<Transaksi> addTransaksiCredit(Transaksi transaksi);
}
