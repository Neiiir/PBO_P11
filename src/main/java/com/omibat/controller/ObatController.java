package com.omibat.controller;

import com.omibat.model.Obat;
import com.omibat.repository.ObatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/obat")
public class ObatController {
    private final ObatRepository repository;

    public ObatController(ObatRepository repository) { this.repository = repository; }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("daftarObat", repository.findAll());
        return "obat/index";
    }

    @GetMapping("/tambah")
    public String tambah(Model model) {
        model.addAttribute("obat", new Obat());
        model.addAttribute("judul", "Tambah Obat");
        return "obat/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Obat obat = repository.findById(id).orElseThrow();
        model.addAttribute("obat", obat);
        model.addAttribute("judul", "Edit Obat");
        return "obat/form";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Obat obat) {
        repository.save(obat);
        return "redirect:/obat";
    }

    @PostMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/obat";
    }
}
