package com.yos.koperasi.transaksi.controller;

import com.yos.koperasi.Const;
import com.yos.koperasi.ResponseManager;
import com.yos.koperasi.anggota.manager.AnggotaManager;
import com.yos.koperasi.anggota.model.Anggota;
import com.yos.koperasi.transaksi.manager.TransaksiManager;
import com.yos.koperasi.transaksi.model.Transaksi;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaksi")
@AllArgsConstructor
public class TransaksiController {
    TransaksiManager transaksiManager;

    @GetMapping("/")
    public ResponseEntity checkServiceController() {
        return ResponseEntity.ok().body("service active");
    }

    @GetMapping("/list")
    public ResponseEntity getList(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok().body(transaksiManager.getList(page, size));
    }

    @GetMapping("/listbyid")
    public ResponseEntity getListById(@RequestParam Long idAnggota) {
        return ResponseEntity.ok().body(transaksiManager.getListById(idAnggota));
    }

    @GetMapping("/listbydate")
    public ResponseEntity getListByDate(@RequestParam Long startDate, @RequestParam Long lastDate) {
        return ResponseEntity.ok().body(transaksiManager.getListByDate(startDate, lastDate));
    }

    @PostMapping("/addDebit")
    public ResponseEntity doAddDebit(@RequestBody Transaksi transaksi) {
        transaksi.setType(Const.TRANSACTION_TYPE.DEBIT);
        ResponseManager<Transaksi> transaksiRes = transaksiManager.addTransaksi(transaksi);
        return ResponseEntity.ok().body(transaksiRes);
    }

    @PostMapping("/addCredit")
    public ResponseEntity doAddCredit(@RequestBody Transaksi transaksi) {
        transaksi.setType(Const.TRANSACTION_TYPE.CREDIT);
        ResponseManager<Transaksi> transaksiRes = transaksiManager.addTransaksiCredit(transaksi);
        return ResponseEntity.ok().body(transaksiRes);
    }

    @PostMapping("/addPayment")
    public ResponseEntity doAddPayment(@RequestBody Transaksi transaksi) {
        transaksi.setType(Const.TRANSACTION_TYPE.INSTALLMENT_CREDIT);
        ResponseManager<Transaksi> transaksiRes = transaksiManager.addTransaksi(transaksi);
        return ResponseEntity.ok().body(transaksiRes);
    }
}
