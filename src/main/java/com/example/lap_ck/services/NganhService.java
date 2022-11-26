package com.example.lap_ck.services;

import com.example.lap_ck.dtos.NganhDTO;
import com.example.lap_ck.models.Nganh;
import com.example.lap_ck.repositories.NganhRepository;
import com.example.lap_ck.vos.NganhQueryVO;
import com.example.lap_ck.vos.NganhUpdateVO;
import com.example.lap_ck.vos.NganhVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NganhService {

    @Autowired
    private NganhRepository nganhRepository;

    public String save(NganhVO vO) {
        Nganh bean = new Nganh();
        BeanUtils.copyProperties(vO, bean);
        bean = nganhRepository.save(bean);
        return bean.getMaNganh();
    }

    public void delete(String id) {
        nganhRepository.deleteById(id);
    }

    public void update(String id, NganhUpdateVO vO) {
        Nganh bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        nganhRepository.save(bean);
    }

    public NganhDTO getById(String id) {
        Nganh original = requireOne(id);
        return toDTO(original);
    }

    public Page<NganhDTO> query(NganhQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private NganhDTO toDTO(Nganh original) {
        NganhDTO bean = new NganhDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Nganh requireOne(String id) {
        return nganhRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<Nganh> findAll() {
        return nganhRepository.findAll();
    }
}
