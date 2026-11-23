package com.omibat.controller;

import com.omibat.model.KontrolDokter;
import com.omibat.repository.KontrolDokterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kontrol")
public class KontrolDokterController {
    private final KontrolDokterRepository repository;

    public KontrolDokterController(KontrolDokterRepository repository) { this.repository = repository; }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("daftarKontrol", repository.findAll());
        return "kontrol/index";
    }

    @GetMapping("/tambah")
    public String tambah(Model model) {
        model.addAttribute("kontrol", new KontrolDokter());
        model.addAttribute("judul", "Tambah Jadwal Kontrol");
        return "kontrol/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("kontrol", repository.findById(id).orElseThrow());
        model.addAttribute("judul", "Edit Jadwal Kontrol");
        return "kontrol/form";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute KontrolDokter kontrol) {
        repository.save(kontrol);
        return "redirect:/kontrol";
    }

    @PostMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/kontrol";
    }
}
