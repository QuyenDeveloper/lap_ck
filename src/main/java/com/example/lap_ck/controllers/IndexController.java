package com.example.lap_ck.controllers;

import com.example.lap_ck.dtos.SinhvienDTO;
import com.example.lap_ck.models.Sinhvien;
import com.example.lap_ck.services.CongviecService;
import com.example.lap_ck.services.IndexService;
import com.example.lap_ck.services.SinhvienService;
import com.example.lap_ck.services.TotnghiepService;
import com.example.lap_ck.vos.SinhvienVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private SinhvienService sinhvienService;
    @Autowired
    private TotnghiepService totnghiepService;
    @Autowired
    private CongviecService congviecService;
    @Autowired
    private IndexService indexService;
    @GetMapping
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("sinhviens", sinhvienService.findAll());
        modelMap.addAttribute("totnghieps", totnghiepService.findAll());
        modelMap.addAttribute("congviecs", congviecService.findAll());
        return "/index";
    }
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String timKiem(ModelMap modelMap, @RequestParam(value="timKiem") String timKiem) throws Exception {
        if (timKiem == ""){
            return "redirect:/";
        }else {
            List<Sinhvien> sinhVien = indexService.timKiem(timKiem);
            modelMap.addAttribute("sinhviens", sinhVien);
            modelMap.addAttribute("totnghieps", totnghiepService.findAll());
            modelMap.addAttribute("congviecs", congviecService.findAll());
            return "/index";
        }
    }
}
