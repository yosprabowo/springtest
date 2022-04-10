package com.yos.koperasi.transaksi.manager;

import com.yos.koperasi.BaseManager;
import com.yos.koperasi.Const;
import com.yos.koperasi.ResponseManager;
import com.yos.koperasi.anggota.model.Anggota;
import com.yos.koperasi.anggota.repo.AnggotaRepository;
import com.yos.koperasi.transaksi.model.Transaksi;
import com.yos.koperasi.transaksi.repo.TransaksiRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import static org.springframework.data.domain.ExampleMatcher.matchingAll;

@Service
@AllArgsConstructor
public class TransaksiManagerImpl extends BaseManager implements TransaksiManager {
    TransaksiRepository transaksiRepository;
    AnggotaRepository anggotaRepository;

    @Override
    @Transactional
    public ResponseManager<Transaksi> addTransaksi(Transaksi transaksi) {
        transaksi.setTransaction_date(new Date().getTime());
        transaksi.setStatus(Const.TRANSACTION_STATUS.VALID);
        transaksiRepository.save(transaksi);
        return isSuccessData(transaksi);
    }

    @Override
    public ResponseManager<Transaksi> addTransaksiCredit(Transaksi transaksi) {
        Long totalAmmountCredit = transaksiRepository.totalAmount(transaksi.getId_anggota(), Const.TRANSACTION_TYPE.CREDIT);
        Long totalAmmountPayment = transaksiRepository.totalAmount(transaksi.getId_anggota(), Const.TRANSACTION_TYPE.INSTALLMENT_CREDIT);

        if ((totalAmmountCredit == null || totalAmmountCredit <= 0) || ((totalAmmountPayment != null && totalAmmountCredit != null) && totalAmmountCredit <= totalAmmountPayment)) {
            transaksi.setTransaction_date(new Date().getTime());
            transaksi.setStatus(Const.TRANSACTION_STATUS.VALID);
            transaksiRepository.save(transaksi);
            return isSuccessData(transaksi);
        }else{
            return isFailedData("Masih ada sisa pinjaman sebelumnya, silahkan melakukan pembayaran");
        }
    }

    @Override
    public ResponseManager<Page<Transaksi>> getList(int page, int size) {
        return isSuccessData(transaksiRepository.findAll(PageRequest.of(page, size)));
    }

    @Override
    public ResponseManager<Page<Transaksi>> getListById(Long idAnggota) {
        return isSuccessData(transaksiRepository.findAllByAnggotaId(idAnggota));
    }

    @Override
    public ResponseManager<Page<Transaksi>> getListByDate(Long startDate, Long endDate) {
        return isSuccessData(transaksiRepository.findAllByRangeDate(startDate, endDate));

    }
}
