package com.omibat.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.omibat.model.JadwalObat;
import com.omibat.repository.JadwalObatRepository;
import com.omibat.repository.ObatRepository;

@Controller
@RequestMapping("/jadwal")
public class JadwalObatController {
    private final JadwalObatRepository jadwalRepository;
    private final ObatRepository obatRepository;

    public JadwalObatController(JadwalObatRepository jadwalRepository, ObatRepository obatRepository) {
        this.jadwalRepository = jadwalRepository;
        this.obatRepository = obatRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("daftarJadwal", jadwalRepository.findAll());
        return "jadwal/index";
    }

    @GetMapping("/tambah")
    public String tambah(Model model) {
        model.addAttribute("jadwal", new JadwalObat());
        model.addAttribute("daftarObat", obatRepository.findAll());
        model.addAttribute("judul", "Tambah Jadwal");
        return "jadwal/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("jadwal", jadwalRepository.findById(id).orElseThrow());
        model.addAttribute("daftarObat", obatRepository.findAll());
        model.addAttribute("judul", "Edit Jadwal");
        return "jadwal/form";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute JadwalObat jadwal, @RequestParam Long obatId) {
        jadwal.setObat(obatRepository.findById(obatId).orElseThrow());
        jadwalRepository.save(jadwal);
        return "redirect:/jadwal";
    }

    @PostMapping("/konfirmasi/{id}")
    public String konfirmasi(@PathVariable Long id) {
            JadwalObat jadwal = jadwalRepository.findById(id).orElseThrow();
            jadwal.setTanggalKonfirmasi(LocalDate.now());
            jadwal.setWaktuKonfirmasi(LocalDateTime.now());
            jadwalRepository.save(jadwal);
            return "redirect:/orang-tua?konfirmasi=berhasil";
    }
    @PostMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        jadwalRepository.deleteById(id);
        return "redirect:/jadwal";
    }
}
