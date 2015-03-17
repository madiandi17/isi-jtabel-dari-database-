CREATE TABLE t_kontak (
id INT AUTO_INCREMENT,
nama VARCHAR(255) NOT NULL,
alamat VARCHAR(255) NOT NULL,
tanggal_lahir DATE,
aktif BOOLEAN,
PRIMARY KEY(id)
)Engine= InnoDB;
INSERT INTO t_kontak(nama, alamat, tanggal_lahir, aktif) VALUE
('Madi Andi', 'Jl.Madi Gosling', '1994-12-17', true),
('Dima Gosling', 'Jl.Dima Gosling', '1994-12-12', true);