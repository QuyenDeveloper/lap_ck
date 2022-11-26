package com.example.lap_ck.controllers;

import com.example.lap_ck.models.Congviec;
import com.example.lap_ck.models.Totnghiep;
import com.example.lap_ck.services.CongviecService;
import com.example.lap_ck.services.NganhService;
import com.example.lap_ck.services.SinhvienService;
import com.example.lap_ck.services.TotnghiepService;
import com.example.lap_ck.vos.CongviecVO;
import com.example.lap_ck.vos.TotnghiepUpdateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Validated
@Controller
@RequestMapping("/congviec")
public class CongviecController {
    @Autowired
    private SinhvienService sinhvienService;
    @Autowired
    private CongviecService congviecService;
    @Autowired
    private NganhService nganhService;
    @Autowired
    private TotnghiepService totnghiepService;

    @GetMapping()
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("congviecs", congviecService.findAll());
        return "congviec/index";
    }
    @GetMapping("/create")
    public String formCreate(ModelMap modelMap) {
        modelMap.addAttribute("sinhviens", sinhvienService.findAll());
        modelMap.addAttribute("totnghieps", totnghiepService.findAll());
        modelMap.addAttribute("nganhs", nganhService.findAll());
        return "congviec/create";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createSinhVien(ModelMap modelMap, @Valid CongviecVO vO) throws Exception {
        String sinhVienId = congviecService.save(vO);
        return "redirect:/congviec";
    }
    @GetMapping("/delete/{id},{ngay},{mn}")
    public String Delete(ModelMap modelMap, @Valid @NotNull @PathVariable("id") String id, @PathVariable("ngay") Date ngay, @PathVariable("mn") String mn) throws Exception {
        congviecService.delete2(id,ngay,mn);
        return "redirect:/congviec";
    }
    @GetMapping("/edit/{id},{ngay},{mn}")
    public String HomeEdit(ModelMap modelMap, @Valid @NotNull @PathVariable("id") String id, @PathVariable("ngay") Date ngay, @PathVariable("mn") String mn) throws Exception {
        Congviec congviec = congviecService.editPre(id,ngay,mn);
        modelMap.addAttribute("congviec", congviec);
        modelMap.addAttribute("nganhs", nganhService.findAll());
        return "congviec/edit";
    }

    @RequestMapping(value = "/edit/{id},{ngay},{mn}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String editTotNghiep(ModelMap modelMap, @Valid CongviecVO vO, @Valid @NotNull @PathVariable("id") String id, @PathVariable("ngay") Date ngay, @PathVariable("mn") String mn) throws Exception {
//        Congviec congviec = congviecService.editPre(id,ngay,mn);
//        modelMap.addAttribute("congviec", congviec);
        congviecService.editQRPost(id,ngay,mn, vO);
        return "redirect:/congviec/";
    }
}
