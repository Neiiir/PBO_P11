package com.kuis.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "riwayat_kalkulator")
public class Kalkulator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double bilangan1;
    private String operator;
    private Double bilangan2;

    // @Transient bikin variabel ini DIABAIKAN oleh database SQL
    @Transient
    private Double hasil;

    // --- Getter dan Setter ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getBilangan1() { return bilangan1; }
    public void setBilangan1(Double bilangan1) { this.bilangan1 = bilangan1; }

    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }

    public Double getBilangan2() { return bilangan2; }
    public void setBilangan2(Double bilangan2) { this.bilangan2 = bilangan2; }

    // Logika perhitungan dipindah ke sini (Dihitung on-the-fly saat web ditampilkan)
    public Double getHasil() {
        if (bilangan1 != null && bilangan2 != null && operator != null) {
            switch (operator) {
                case "+": return bilangan1 + bilangan2;
                case "-": return bilangan1 - bilangan2;
                case "x": return bilangan1 * bilangan2;
                case ":": return (bilangan2 != 0) ? bilangan1 / bilangan2 : 0.0;
            }
        }
        return 0.0;
    }

    public void setHasil(Double hasil) { 
        this.hasil = hasil; 
    }
}