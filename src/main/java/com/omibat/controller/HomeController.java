package com.omibat.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.omibat.repository.JadwalObatRepository;
import com.omibat.repository.KontrolDokterRepository;
import com.omibat.repository.ObatRepository;

@Controller
public class HomeController {
    private final ObatRepository obatRepository;
    private final JadwalObatRepository jadwalObatRepository;
    private final KontrolDokterRepository kontrolDokterRepository;

    public HomeController(ObatRepository obatRepository,
                          JadwalObatRepository jadwalObatRepository,
                          KontrolDokterRepository kontrolDokterRepository) {
        this.obatRepository = obatRepository;
        this.jadwalObatRepository = jadwalObatRepository;
        this.kontrolDokterRepository = kontrolDokterRepository;
    }

    @GetMapping("/")
    public String home() { return "home"; }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("jumlahObat", obatRepository.count());
        model.addAttribute("jumlahJadwal", jadwalObatRepository.count());
        model.addAttribute("jumlahKontrol", kontrolDokterRepository.count());
        model.addAttribute("jadwal", jadwalObatRepository.findAll());
        model.addAttribute("hariIni", LocalDate.now());
        model.addAttribute("kontrol", kontrolDokterRepository.findAll());
        return "dashboard";
    }

    @GetMapping("/orang-tua")
    public String orangTua(Model model) {
        model.addAttribute("jadwal", jadwalObatRepository.findAll());
        model.addAttribute("hariIni", LocalDate.now());
        model.addAttribute("kontrol", kontrolDokterRepository.findAll());
        return "orang-tua";
    }
}
