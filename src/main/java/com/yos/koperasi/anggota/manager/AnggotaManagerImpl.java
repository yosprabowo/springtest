package com.yos.koperasi.anggota.manager;

import com.yos.koperasi.BaseManager;
import com.yos.koperasi.ResponseManager;
import com.yos.koperasi.anggota.model.Anggota;
import com.yos.koperasi.anggota.repo.AnggotaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AnggotaManagerImpl extends BaseManager implements AnggotaManager{
    AnggotaRepository anggotaRepository;

    @Override
    @Transactional
    public ResponseManager<Anggota> addAnggota(Anggota anggota) {
        anggotaRepository.save(anggota);
        return isSuccessData(anggota);
    }

    @Override
    public ResponseManager<Page<Anggota>> getList(int page, int size) {
        return isSuccessData(anggotaRepository.findAll(PageRequest.of(page, size)));
    }
}
