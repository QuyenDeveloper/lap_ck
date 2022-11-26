package com.example.lap_ck.controllers;

import com.example.lap_ck.dtos.SinhvienDTO;
import com.example.lap_ck.services.SinhvienService;
import com.example.lap_ck.vos.SinhvienUpdateVO;
import com.example.lap_ck.vos.SinhvienVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@Controller
@RequestMapping("/sinhvien")
public class SinhvienController {

    @Autowired
    private SinhvienService sinhvienService;

    @GetMapping("/create")
    public String FormCreate() {
        return "sinhvien/create";
    }

    @GetMapping("/delete/{id}")
    public String Delete(ModelMap modelMap, @Valid @NotNull @PathVariable("id") String id) throws Exception {
        sinhvienService.delete(id);
        return "redirect:/sinhvien";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createSinhVien(ModelMap modelMap, @Valid SinhvienVO vO) throws Exception {
        String sinhVienId = sinhvienService.save(vO);
        return "redirect:/sinhvien";
    }


    @GetMapping("/edit/{id}")
    public String HomeEdit(ModelMap modelMap, @Valid @NotNull @PathVariable("id") String id) throws Exception {
        SinhvienDTO sinhvien = sinhvienService.getById(id);
        modelMap.addAttribute("sinhvien", sinhvien);
        return "sinhvien/edit";
    }

    @RequestMapping(value = "/edit/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String editSinhVien(@Valid SinhvienUpdateVO sinhvienUpdateVO,
                               @Valid @NotNull @PathVariable("id") String id
    ) throws Exception {
        this.sinhvienService.update(id, sinhvienUpdateVO);
        return "redirect:/sinhvien/";
    }

    @PostMapping
    public String save(@Valid @RequestBody SinhvienVO vO) {
        return sinhvienService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        sinhvienService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody SinhvienUpdateVO vO) {
        sinhvienService.update(id, vO);
    }


    @GetMapping("/{id}")
    public SinhvienDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return sinhvienService.getById(id);
    }

//    @GetMapping
//    public Page<SinhvienDTO> query(@Valid SinhvienQueryVO vO) {
//        return sinhvienService.query(vO);
//    }

    @GetMapping
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("sinhviens", sinhvienService.findAll());
        return "sinhvien/index";
    }
}
