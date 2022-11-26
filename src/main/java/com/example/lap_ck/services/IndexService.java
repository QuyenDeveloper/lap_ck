package com.example.lap_ck.services;

import com.example.lap_ck.models.Sinhvien;
import com.example.lap_ck.repositories.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    @Autowired
    IndexRepository indexRepository;
    public List<Sinhvien> timKiem(String id){
       return indexRepository.timKiemQR(id);
    }
}
