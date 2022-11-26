package com.example.lap_ck.controllers;

import com.example.lap_ck.dtos.SinhvienDTO;
import com.example.lap_ck.dtos.TotnghiepDTO;
import com.example.lap_ck.models.Totnghiep;
import com.example.lap_ck.services.*;
import com.example.lap_ck.vos.SinhvienUpdateVO;
import com.example.lap_ck.vos.TotnghiepUpdateVO;
import com.example.lap_ck.vos.TotnghiepVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@Controller
@RequestMapping("/totnghiep")
public class TotnghiepController {
    @Autowired
    private SinhvienService sinhvienService;
    @Autowired
    private TotnghiepService totnghiepService;
    @Autowired
    private TruongService truongService;
    @Autowired
    private NganhService nganhService;
    @Autowired
    private CongviecService congviecService;

    @GetMapping
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("totnghieps", totnghiepService.findAll());
        modelMap.addAttribute("sinhviens", sinhvienService.findAll());
        modelMap.addAttribute("congviecs", congviecService.findAll());
        return "totnghiep/index";
    }
    @GetMapping("/delete/{id},{mt},{mn}")
    public String Delete(ModelMap modelMap, @Valid @NotNull @PathVariable("id") String id, @PathVariable("mt") String mt,@PathVariable("mn") String mn) throws Exception {
        totnghiepService.delete2(id,mt,mn);
        return "redirect:/totnghiep";
    }

    @GetMapping("/create")
    public String FormCreate(ModelMap modelMap1) {
        modelMap1.addAttribute("sinhviens", sinhvienService.findAll());
        modelMap1.addAttribute("truongs", truongService.findAll());
        modelMap1.addAttribute("nganhs", nganhService.findAll());
        return "totnghiep/create";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createSinhVien(ModelMap modelMap, @Valid TotnghiepVO vO) throws Exception {
        String sinhVienId = totnghiepService.save(vO);
        return "redirect:/totnghiep";
    }

    @GetMapping("/edit/{id},{mt},{mn}")
    public String HomeEdit(ModelMap modelMap, @Valid @NotNull @PathVariable("id") String id, @PathVariable("mt") String mt,@PathVariable("mn") String mn) throws Exception {
        Totnghiep totnghiep = totnghiepService.editPre(id,mt,mn);
        modelMap.addAttribute("truongs", truongService.findAll());
        modelMap.addAttribute("nganhs", nganhService.findAll());
        modelMap.addAttribute("totnghiep", totnghiep);
        return "totnghiep/edit";
    }

    @RequestMapping(value = "/edit/{id},{mt},{mn}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String editTotNghiep(ModelMap modelMap,@Valid TotnghiepUpdateVO vO, @Valid @NotNull @PathVariable("id") String id, @PathVariable("mt") String mt,@PathVariable("mn") String mn) throws Exception {
//        Totnghiep totnghiep = totnghiepService.editPre(id,mt,mn);
//        modelMap.addAttribute("totnghiep", totnghiep);
        totnghiepService.editQRPost(id,mt,mn, vO);
        return "redirect:/totnghiep/";
    }
}
