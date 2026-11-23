# OMIBAT — Orang Tua Minum Obat

Aplikasi web Spring Boot + Thymeleaf untuk membantu keluarga mengelola data obat, jadwal minum obat, dan jadwal kontrol dokter.

## Teknologi
- Java 17
- Spring Boot 3.5.6
- Spring Web, Thymeleaf, Spring Data JPA
- PostgreSQL

## Cara menjalankan
1. Pastikan Java 17+ dan PostgreSQL sudah terpasang.
2. Buat database:
   ```sql
   CREATE DATABASE omibat_db;
   ```
3. Buka `src/main/resources/application.properties`, lalu sesuaikan `spring.datasource.username` dan `spring.datasource.password` dengan PostgreSQL lokal.
4. Buka folder proyek ini di IntelliJ IDEA / Eclipse / VS Code.
5. Jalankan `src/main/java/com/omibat/OmibatApplication.java`, atau lewat terminal:
   ```bash
   mvn spring-boot:run
   ```
6. Buka `http://localhost:8080`.

## Fitur yang tersedia
- Beranda dan dashboard ringkas.
- CRUD data obat.
- CRUD jadwal minum obat (terhubung ke data obat).
- CRUD jadwal kontrol dokter.
- Tampilan sederhana untuk orang tua melalui menu **Mode Orang Tua**.

## Catatan
- `spring.jpa.hibernate.ddl-auto=update` membuat/memperbarui tabel secara otomatis saat aplikasi dijalankan.
- Versi awal ini belum memiliki login/otorisasi multi-akun, notifikasi push/telepon, dan unggah arsip hasil pemeriksaan. Fitur tersebut dapat ditambahkan pada tahap berikutnya.


## Fitur konfirmasi minum obat
- Halaman `/orang-tua` menampilkan hitung mundur menuju waktu minum obat.
- Jika waktu jadwal lewat dan belum dikonfirmasi, aplikasi menampilkan peringatan terlambat.
- Orang tua dapat menekan tombol "Saya Sudah Minum Obat" untuk menyimpan waktu konfirmasi.
- Konfirmasi disimpan per tanggal, sehingga jadwal dapat dikonfirmasi kembali pada hari berikutnya.
- Countdown diperbarui selama halaman terbuka. Notifikasi push/SMS ketika aplikasi ditutup belum termasuk versi ini.

Project disetel untuk Java 25 pada `pom.xml`.
