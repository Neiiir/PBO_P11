package com.omibat.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jadwal_obat")
public class JadwalObat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "obat_id", nullable = false)
    private Obat obat;

    private LocalTime waktuMinum;
    private String frekuensi;
    private String aturanWaktu;
    private boolean aktif = true;
    private LocalDate tanggalKonfirmasi;
    private LocalDateTime waktuKonfirmasi;

    public JadwalObat() {}

    public Long getId() { return id; }
    public Obat getObat() { return obat; }
    public void setObat(Obat obat) { this.obat = obat; }
    public LocalTime getWaktuMinum() { return waktuMinum; }
    public void setWaktuMinum(LocalTime waktuMinum) { this.waktuMinum = waktuMinum; }
    public String getFrekuensi() { return frekuensi; }
    public void setFrekuensi(String frekuensi) { this.frekuensi = frekuensi; }
    public String getAturanWaktu() { return aturanWaktu; }
    public void setAturanWaktu(String aturanWaktu) { this.aturanWaktu = aturanWaktu; }
    public LocalDate getTanggalKonfirmasi() { return tanggalKonfirmasi; }
    public void setTanggalKonfirmasi(LocalDate tanggalKonfirmasi) { this.tanggalKonfirmasi = tanggalKonfirmasi; }
    public LocalDateTime getWaktuKonfirmasi() { return waktuKonfirmasi; }
    public void setWaktuKonfirmasi(LocalDateTime waktuKonfirmasi) { this.waktuKonfirmasi = waktuKonfirmasi; }
    public boolean isAktif() { return aktif; }
    public void setAktif(boolean aktif) { this.aktif = aktif; }
}
