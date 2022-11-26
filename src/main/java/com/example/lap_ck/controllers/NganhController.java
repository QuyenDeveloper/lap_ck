package com.example.lap_ck.controllers;

import com.example.lap_ck.dtos.NganhDTO;
import com.example.lap_ck.services.NganhService;
import com.example.lap_ck.vos.NganhQueryVO;
import com.example.lap_ck.vos.NganhUpdateVO;
import com.example.lap_ck.vos.NganhVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@Controller
@RequestMapping("/nganh")
public class NganhController {

    @Autowired
    private NganhService nganhService;

    @PostMapping
    public String save(@Valid @RequestBody NganhVO vO) {
        return nganhService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        nganhService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody NganhUpdateVO vO) {
        nganhService.update(id, vO);
    }

    @GetMapping("/{id}")
    public NganhDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return nganhService.getById(id);
    }

    @GetMapping
    public Page<NganhDTO> query(@Valid NganhQueryVO vO) {
        return nganhService.query(vO);
    }
}
