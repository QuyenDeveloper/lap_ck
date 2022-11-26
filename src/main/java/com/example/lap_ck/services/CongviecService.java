package com.example.lap_ck.services;

import com.example.lap_ck.dtos.CongviecDTO;
import com.example.lap_ck.models.Congviec;
import com.example.lap_ck.repositories.CongviecRepository;
import com.example.lap_ck.vos.CongviecQueryVO;
import com.example.lap_ck.vos.CongviecUpdateVO;
import com.example.lap_ck.vos.CongviecVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CongviecService {

    @Autowired
    private CongviecRepository congviecRepository;
    public Congviec editPre(String id, Date ngay, String mn) {
        return congviecRepository.editQRPre(id,ngay,mn);
    }
    public void editQRPost(String id, Date ngay, String mn, CongviecVO vo) {
        congviecRepository.editQRPost(id,ngay,mn,vo.getNgayVaoCongTy(),vo.getMaNganh(),vo.getTenCongViec(),vo.getTenCongTy(),vo.getDiaChiCongTy(),vo.getThoiGianLamViec());
    }

    public String save(CongviecVO vO) {
        Congviec bean = new Congviec();
        BeanUtils.copyProperties(vO, bean);
        bean = congviecRepository.save(bean);
        return bean.getSoCCCD();
    }

    public void delete(String id) {
        congviecRepository.deleteById(id);
    }


    public void update(String id, CongviecUpdateVO vO) {
        Congviec bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        congviecRepository.save(bean);
    }

    public CongviecDTO getById(String id) {
        Congviec original = requireOne(id);
        return toDTO(original);
    }

    public Page<CongviecDTO> query(CongviecQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CongviecDTO toDTO(Congviec original) {
        CongviecDTO bean = new CongviecDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Congviec requireOne(String id) {
        return congviecRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
    public List<Congviec> findAll() {
        return congviecRepository.findAll();
    }

    public void delete2(String id, Date ngay,String mn) {
        congviecRepository.deleteQR(id,ngay,mn);
    }
}
