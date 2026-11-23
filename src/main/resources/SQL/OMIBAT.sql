CREATE TABLE obat (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nama_obat VARCHAR(255) NOT NULL,
    dosis VARCHAR(255),
    aturan_minum VARCHAR(255),
    keterangan VARCHAR(255)
);

CREATE TABLE jadwal_obat (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    obat_id BIGINT NOT NULL,
    waktu_minum TIME,
    frekuensi VARCHAR(255),
    aturan_waktu VARCHAR(255),
    aktif BOOLEAN NOT NULL DEFAULT TRUE,
    tanggal_konfirmasi DATE,
    waktu_konfirmasi TIMESTAMP,

    CONSTRAINT fk_jadwal_obat
        FOREIGN KEY (obat_id)
        REFERENCES obat(id)
        ON DELETE CASCADE
);

CREATE TABLE kontrol_dokter (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nama_dokter VARCHAR(255),
    tanggal_kontrol DATE,
    jam_kontrol TIME,
    lokasi VARCHAR(255),
    catatan VARCHAR(1000)
);

INSERT INTO obat (nama_obat, dosis, aturan_minum, keterangan)
VALUES
('Paracetamol', '500 mg', 'Sesudah makan', 'Untuk demam'),
('Amoxicillin', '250 mg', '3 kali sehari', 'Habiskan sesuai resep');