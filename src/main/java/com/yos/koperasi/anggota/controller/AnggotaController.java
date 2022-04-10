package com.yos.koperasi.anggota.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yos.koperasi.ResponseManager;
import com.yos.koperasi.anggota.manager.AnggotaManager;
import com.yos.koperasi.anggota.model.Anggota;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/anggota")
@AllArgsConstructor
public class AnggotaController {
    AnggotaManager anggotaManager;

    @GetMapping("/")
    public ResponseEntity checkServiceController() {
        return ResponseEntity.ok().body("service active");
    }

    @GetMapping("/list")
    public ResponseEntity getList(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok().body(anggotaManager.getList(page, size));
    }

    @PostMapping("/add")
    public ResponseEntity doAdd(@RequestBody Anggota anggota) {
        ResponseManager<Anggota> anggotaRes = anggotaManager.addAnggota(anggota);
        if(anggotaRes.getSuccess()) {
            return ResponseEntity.ok().body(anggotaRes);
        }else{
            return ResponseEntity.badRequest().body(anggotaRes.getDescription());
        }
    }
}
