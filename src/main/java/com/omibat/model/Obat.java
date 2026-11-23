package com.omibat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "obat")
public class Obat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String namaObat;

    private String dosis;
    private String aturanMinum;
    private String keterangan;

    public Obat() {}

    public Long getId() { return id; }
    public String getNamaObat() { return namaObat; }
    public void setNamaObat(String namaObat) { this.namaObat = namaObat; }
    public String getDosis() { return dosis; }
    public void setDosis(String dosis) { this.dosis = dosis; }
    public String getAturanMinum() { return aturanMinum; }
    public void setAturanMinum(String aturanMinum) { this.aturanMinum = aturanMinum; }
    public String getKeterangan() { return keterangan; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }
}
