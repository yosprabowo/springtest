package com.yos.koperasi.controller;

import com.yos.koperasi.ResponseManager;
import com.yos.koperasi.anggota.controller.AnggotaController;
import com.yos.koperasi.anggota.manager.AnggotaManager;
import com.yos.koperasi.anggota.model.Anggota;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AnggotaControllerTest {

    @Mock
    AnggotaManager anggotaManager;

    @InjectMocks
    AnggotaController controller;

    @Test
    public void addAnggota_returnSuccess() {
        Anggota anggota = new Anggota();
        anggota.setFirstName("joni");
        anggota.setLastName("Last");
        anggota.setBirthDate(new Date().getTime());
        anggota.setAddress("Jakarta");

        ResponseEntity<ResponseManager<Anggota>> responseEntity = controller.doAdd(anggota);
        ResponseManager<Anggota> response = responseEntity.getBody();

        assertThat(response).isNotNull();
        assertThat(response.getCode()).isEqualTo(200);
    }
}
