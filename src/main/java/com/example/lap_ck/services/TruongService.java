package com.example.lap_ck.services;

import com.example.lap_ck.dtos.TruongDTO;
import com.example.lap_ck.models.Truong;
import com.example.lap_ck.repositories.TruongRepository;
import com.example.lap_ck.vos.TruongQueryVO;
import com.example.lap_ck.vos.TruongUpdateVO;
import com.example.lap_ck.vos.TruongVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TruongService {

    @Autowired
    private TruongRepository truongRepository;

    public String save(TruongVO vO) {
        Truong bean = new Truong();
        BeanUtils.copyProperties(vO, bean);
        bean = truongRepository.save(bean);
        return bean.getMaTruong();
    }

    public void delete(String id) {
        truongRepository.deleteById(id);
    }

    public void update(String id, TruongUpdateVO vO) {
        Truong bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        truongRepository.save(bean);
    }

    public TruongDTO getById(String id) {
        Truong original = requireOne(id);
        return toDTO(original);
    }

    public Page<TruongDTO> query(TruongQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private TruongDTO toDTO(Truong original) {
        TruongDTO bean = new TruongDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Truong requireOne(String id) {
        return truongRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<Truong> findAll() {
        return truongRepository.findAll();
    }
}
