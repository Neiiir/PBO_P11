package com.kuis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KalkulatorController {

    @Autowired
    private KalkulatorRepository kalkulatorRepository;

    @GetMapping("/kalkulator")
    public String tampilkanHalaman(Model model) {
        model.addAttribute("listData", kalkulatorRepository.findAll());
        model.addAttribute("kalkulator", new Kalkulator());
        return "Kalkulator";
    }

    @PostMapping("/kalkulator/simpan")
    public String hitungDanSimpan(@ModelAttribute Kalkulator kalkulator) {
        // Langsung save aja! Hasilnya otomatis diabaikan DB berkat @Transient
        kalkulatorRepository.save(kalkulator);
        return "redirect:/kalkulator";
    }

    @GetMapping("/kalkulator/edit/{id}")
    public String editData(@PathVariable Long id, Model model) {
        Kalkulator dataEdit = kalkulatorRepository.findById(id).orElse(new Kalkulator());
        model.addAttribute("listData", kalkulatorRepository.findAll());
        model.addAttribute("kalkulator", dataEdit);
        return "Kalkulator";
    }

    @GetMapping("/kalkulator/hapus/{id}")
    public String hapusData(@PathVariable Long id) {
        kalkulatorRepository.deleteById(id);
        return "redirect:/kalkulator";
    }
}