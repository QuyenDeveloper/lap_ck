package com.example.lap_ck.services;

import com.example.lap_ck.dtos.TotnghiepDTO;
import com.example.lap_ck.models.Totnghiep;
import com.example.lap_ck.repositories.TotnghiepRepository;
import com.example.lap_ck.vos.TotnghiepQueryVO;
import com.example.lap_ck.vos.TotnghiepUpdateVO;
import com.example.lap_ck.vos.TotnghiepVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.PreRemove;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class TotnghiepService {

    @Autowired
    private TotnghiepRepository totnghiepRepository;

    public String save(TotnghiepVO vO) {
        Totnghiep bean = new Totnghiep();
        BeanUtils.copyProperties(vO, bean);
        bean = totnghiepRepository.save(bean);
        return bean.getSoCCCD();
    }

    public void delete2(String id,String mt,String mn) {
        totnghiepRepository.deleteQR(id,mt,mn);
    }
    public Totnghiep editPre(String id,String mt,String mn){
        return totnghiepRepository.editQRPre(id,mt,mn);
    }
    public void update(String id, TotnghiepUpdateVO vO) {
        Totnghiep bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        totnghiepRepository.save(bean);
    }
    public void editQRPost(String id,String mt,String mn, TotnghiepUpdateVO vO){
        totnghiepRepository.editQRPost(id,mt,mn,vO.getSoCCCD(),vO.getMaTruong(),vO.getMaNganh(),vO.getHeTN(),vO.getLoaiTN(),vO.getNgayTN());
    }

    public void delete(String id) {
        totnghiepRepository.deleteById(id);
    }
    public TotnghiepDTO getById(String id) {
        Totnghiep original = requireOne(id);
        return toDTO(original);
    }

    public Page<TotnghiepDTO> query(String id) {
        throw new UnsupportedOperationException();
    }

    private TotnghiepDTO toDTO(Totnghiep original) {
        TotnghiepDTO bean = new TotnghiepDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Totnghiep requireOne(String id) {
        return totnghiepRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<Totnghiep> findAll() {
        return totnghiepRepository.findAll();
    }
}
