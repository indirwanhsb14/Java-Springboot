lagu > album > musisi > instrumen

-- Adminer 4.8.1 MySQL 5.5.5-10.4.24-MariaDB dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

USE `melodi_indah`;

DROP VIEW IF EXISTS `combine-all-data`;
CREATE TABLE `combine-all-data` (`id_lagu` int(12), `judul` varchar(50), `id_album` int(12), `format` enum('CD','MC'), `id_ssn` int(12), `nama` varchar(50), `nama_instrumen` enum('Gitar','Piano','Flute'), `kunci_musik` enum('C','E','G'));


DROP VIEW IF EXISTS `combinelagualbum`;
CREATE TABLE `combinelagualbum` (`id_lagu` int(12), `id_album` int(12));


SET NAMES utf8mb4;

DROP TABLE IF EXISTS `tb_album`;
CREATE TABLE `tb_album` (
  `id_album` int(12) NOT NULL AUTO_INCREMENT,
  `tgl_copy` date NOT NULL,
  `format` enum('CD','MC') NOT NULL,
  `id_combine_musik` int(11) NOT NULL,
  PRIMARY KEY (`id_album`),
  KEY `id_combine_musik` (`id_combine_musik`),
  CONSTRAINT `tb_album_ibfk_1` FOREIGN KEY (`id_combine_musik`) REFERENCES `tb_combine_musik` (`id_combine_musik`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tb_album` (`id_album`, `tgl_copy`, `format`, `id_combine_musik`) VALUES
(5,	'2013-09-02',	'CD',	2),
(6,	'2018-11-30',	'MC',	3),
(7,	'2020-12-18',	'MC',	4),
(8,	'2016-01-05',	'MC',	5);

DROP TABLE IF EXISTS `tb_combine_musik`;
CREATE TABLE `tb_combine_musik` (
  `id_combine_musik` int(11) NOT NULL AUTO_INCREMENT,
  `id_ssn` int(12) NOT NULL,
  `id_instrumen` int(10) NOT NULL,
  PRIMARY KEY (`id_combine_musik`),
  KEY `id_ssn` (`id_ssn`),
  KEY `id_instrumen` (`id_instrumen`),
  CONSTRAINT `tb_combine_musik_ibfk_3` FOREIGN KEY (`id_ssn`) REFERENCES `tb_musisi` (`id_ssn`),
  CONSTRAINT `tb_combine_musik_ibfk_4` FOREIGN KEY (`id_instrumen`) REFERENCES `tb_instrumen` (`id_instrumen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tb_combine_musik` (`id_combine_musik`, `id_ssn`, `id_instrumen`) VALUES
(2,	197501,	121),
(3,	197502,	122),
(4,	197503,	123),
(5,	197501,	124);

DROP TABLE IF EXISTS `tb_instrumen`;
CREATE TABLE `tb_instrumen` (
  `id_instrumen` int(10) NOT NULL AUTO_INCREMENT,
  `nama_instrumen` enum('Gitar','Piano','Flute') NOT NULL,
  `kunci_musik` enum('C','E','G') NOT NULL,
  PRIMARY KEY (`id_instrumen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tb_instrumen` (`id_instrumen`, `nama_instrumen`, `kunci_musik`) VALUES
(121,	'Gitar',	'C'),
(122,	'Piano',	'G'),
(123,	'Flute',	'E'),
(124,	'Piano',	'E');

DROP TABLE IF EXISTS `tb_lagu`;
CREATE TABLE `tb_lagu` (
  `id_lagu` int(12) NOT NULL AUTO_INCREMENT,
  `judul` varchar(50) NOT NULL,
  `pengarang` varchar(50) NOT NULL,
  `id_album` int(12) NOT NULL,
  PRIMARY KEY (`id_lagu`),
  KEY `id_album` (`id_album`),
  CONSTRAINT `tb_lagu_ibfk_1` FOREIGN KEY (`id_album`) REFERENCES `tb_album` (`id_album`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tb_lagu` (`id_lagu`, `judul`, `pengarang`, `id_album`) VALUES
(411,	'Somebody Else',	'Tobias Eaton',	5),
(412,	'Robbers',	'Jimmy Fallen',	6),
(413,	'Its not living',	'Matthew',	7),
(414,	'Be my mistake',	'Adam Hann',	8);

DROP TABLE IF EXISTS `tb_musisi`;
CREATE TABLE `tb_musisi` (
  `id_ssn` int(12) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `alamat` tinytext NOT NULL,
  `no_telp` int(15) NOT NULL,
  PRIMARY KEY (`id_ssn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tb_musisi` (`id_ssn`, `nama`, `alamat`, `no_telp`) VALUES
(197501,	'Matthew Healy',	'London',	2007044),
(197502,	'Adam Hann',	'Manchester',	20890060),
(197503,	'Ross MacDonald',	'London',	20657098),
(197504,	'George Daniel',	'',	20498011),
(197505,	'Matthew Healy',	'London',	2007044),
(197506,	'Adam Hann',	'Manchester',	20890060),
(197507,	'Ross MacDonald',	'London',	20657098),
(197508,	'George Daniel',	'',	20498011);

DROP TABLE IF EXISTS `combine-all-data`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `combine-all-data` AS select `tl`.`id_lagu` AS `id_lagu`,`tl`.`judul` AS `judul`,`ta`.`id_album` AS `id_album`,`ta`.`format` AS `format`,`tm`.`id_ssn` AS `id_ssn`,`tm`.`nama` AS `nama`,`ti`.`nama_instrumen` AS `nama_instrumen`,`ti`.`kunci_musik` AS `kunci_musik` from (((`tb_lagu` `tl` join `tb_album` `ta`) join `tb_musisi` `tm`) join `tb_instrumen` `ti`);

DROP TABLE IF EXISTS `combinelagualbum`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `combinelagualbum` AS select `tl`.`id_lagu` AS `id_lagu`,`ta`.`id_album` AS `id_album` from (`tb_lagu` `tl` join `tb_album` `ta`);

-- 2022-06-21 17:03:04



Query jalankan perintah
select tl.id_lagu AS id_lagu, tl.judul AS judul, tl.pengarang,
	ta.id_album AS id_album, ta.format AS format,
	tm.id_ssn AS id_ssn, tm.nama AS nama,
	ti.nama_instrumen AS nama_instrumen, ti.kunci_musik AS kunci_musik 
	from tb_lagu tl 
	join tb_album ta on tl.id_album=ta.id_album
join tb_combine_musik tcm on ta.id_combine_musik=tcm.id_combine_musik
	join tb_musisi tm on tcm.id_ssn=tm.id_ssn
	join tb_instrumen ti on tcm.id_instrumen=ti.id_instrumen
where tm.nama = 'Adam Hann'

select tl.id_lagu AS id_lagu, tl.judul AS judul, tl.pengarang,
	ta.id_album AS id_album, ta.format AS format,
	tm.id_ssn AS id_ssn, tm.nama, tm.alamat AS nama,
	ti.nama_instrumen AS nama_instrumen, ti.kunci_musik AS kunci_musik 
from tb_lagu tl 
	join tb_album ta on tl.id_album=ta.id_album
        join tb_combine_musik tcm on ta.id_combine_musik=tcm.id_combine_musik
	join tb_musisi tm on tcm.id_ssn=tm.id_ssn
	join tb_instrumen ti on tcm.id_instrumen=ti.id_instrumen
where tm.nama = 'Matthew Healy'