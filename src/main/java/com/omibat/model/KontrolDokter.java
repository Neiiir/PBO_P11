package com.omibat.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "kontrol_dokter")
public class KontrolDokter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaDokter;
    private LocalDate tanggalKontrol;
    private LocalTime jamKontrol;
    private String lokasi;

    @Column(length = 1000)
    private String catatan;

    public KontrolDokter() {}

    public Long getId() { return id; }
    public String getNamaDokter() { return namaDokter; }
    public void setNamaDokter(String namaDokter) { this.namaDokter = namaDokter; }
    public LocalDate getTanggalKontrol() { return tanggalKontrol; }
    public void setTanggalKontrol(LocalDate tanggalKontrol) { this.tanggalKontrol = tanggalKontrol; }
    public LocalTime getJamKontrol() { return jamKontrol; }
    public void setJamKontrol(LocalTime jamKontrol) { this.jamKontrol = jamKontrol; }
    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    public String getCatatan() { return catatan; }
    public void setCatatan(String catatan) { this.catatan = catatan; }
}
