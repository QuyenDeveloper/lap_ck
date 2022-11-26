package com.example.lap_ck.controllers;

import com.example.lap_ck.dtos.TruongDTO;
import com.example.lap_ck.services.TruongService;
import com.example.lap_ck.vos.TruongQueryVO;
import com.example.lap_ck.vos.TruongUpdateVO;
import com.example.lap_ck.vos.TruongVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@Controller
@RequestMapping("/truong")
public class TruongController {

    @Autowired
    private TruongService truongService;

    @PostMapping
    public String save(@Valid @RequestBody TruongVO vO) {
        return truongService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        truongService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody TruongUpdateVO vO) {
        truongService.update(id, vO);
    }

    @GetMapping("/{id}")
    public TruongDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return truongService.getById(id);
    }

    @GetMapping
    public Page<TruongDTO> query(@Valid TruongQueryVO vO) {
        return truongService.query(vO);
    }
}
