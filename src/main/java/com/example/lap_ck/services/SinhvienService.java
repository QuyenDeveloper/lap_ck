package com.example.lap_ck.services;

import com.example.lap_ck.dtos.SinhvienDTO;
import com.example.lap_ck.models.Sinhvien;
import com.example.lap_ck.repositories.SinhvienRepository;
import com.example.lap_ck.vos.SinhvienQueryVO;
import com.example.lap_ck.vos.SinhvienUpdateVO;
import com.example.lap_ck.vos.SinhvienVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SinhvienService {

    @Autowired
    private SinhvienRepository sinhvienRepository;

    public String save(SinhvienVO vO) {
        Sinhvien bean = new Sinhvien();
        BeanUtils.copyProperties(vO, bean);
        bean = sinhvienRepository.save(bean);
        return bean.getSoCCCD();
    }

    public void delete(String id) {
        sinhvienRepository.deleteById(id);
    }

    public void update(String id, SinhvienUpdateVO vO) {
        Sinhvien bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        sinhvienRepository.save(bean);
    }

    public SinhvienDTO getById(String id) {
        Sinhvien original = requireOne(id);
        return toDTO(original);
    }

    public Page<SinhvienDTO> query(SinhvienQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SinhvienDTO toDTO(Sinhvien original) {
        SinhvienDTO bean = new SinhvienDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    public Sinhvien requireOne(String id) {
        return sinhvienRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<Sinhvien> findAll() {
        return sinhvienRepository.findAll();
    }
}
