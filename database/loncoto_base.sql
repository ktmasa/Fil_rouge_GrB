-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018 年 8 朁E29 日 21:11
-- サーバのバージョン： 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loncoto_base`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `article`
--

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `fiche_technique` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sous_famille_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `article`
--

INSERT INTO `article` (`id`, `description`, `fiche_technique`, `nom`, `sous_famille_id`) VALUES
(1, 'blabla PIXMA TS6150...', '/PIXMATS6150.pdf', 'Imprimante Canon PIXMA TS6150', 1),
(2, 'blabla le TX-32ES500E ...', '/TX32ES500E.pdf', 'Panasonic TX-32ES500E', 4),
(3, 'blabla le Leica LeicaT500...', '/LEICAT500.pdf', 'Videoprojecteur LeicaT500', 5),
(4, 'blabla Imagepro2B ...', '/IMAGEPRO2B.pdf', 'Retroprojecteur Imagepro2B', 6),
(5, 'blabla Designjet T120 24...', '/DESIGNJETT120.pdf', 'Imprimante HP Designjet T120 24', 1),
(6, 'blabla le LV-70X500E...', '/LV70X500E.pdf', 'Sharp LV-70X500E', 3),
(7, 'blabla Bravia AF9...', '/BRAVIAAF9.pdf', 'Sony Bravia AF9', 3),
(8, 'blabla MFC-9330CDW ...', '/MFC-9330CDW.pdf', 'Brother MFC-9330CDW', 2);

-- --------------------------------------------------------

--
-- テーブルの構造 `batiment`
--

CREATE TABLE `batiment` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `site_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `batiment`
--

INSERT INTO `batiment` (`id`, `nom`, `site_id`) VALUES
(1, 'Apollon', 1),
(2, 'Perceval', 2),
(3, 'Tour Alpha', 3),
(4, 'Tour Beta', 3),
(5, 'Laboratoire Elton', 4);

-- --------------------------------------------------------

--
-- テーブルの構造 `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `entreprise` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `mail` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `siret` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `telephone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `client`
--

INSERT INTO `client` (`id`, `entreprise`, `mail`, `siret`, `telephone`) VALUES
(1, 'JohnLegend', 'contact@johnlegend.fr', '542 107 651 13030', 185459871),
(2, 'Expert Concept', 'contact@expert-contact.fr', '397 552 811 00044', 323658917),
(3, 'DecoFirst', 'contact@decofirst.com', '440 087 161 00020', 185312578),
(4, 'Newpower', 'contact@newpower.fr', '775 583 263 00121', 258691736),
(5, 'Flashbox', 'contact@flashbox.fr', '814 841 748 00019', 577459852);

-- --------------------------------------------------------

--
-- テーブルの構造 `client_sites`
--

CREATE TABLE `client_sites` (
  `clients_id` int(11) NOT NULL,
  `sites_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `client_sites`
--

INSERT INTO `client_sites` (`clients_id`, `sites_id`) VALUES
(1, 1),
(1, 3),
(2, 2),
(3, 3),
(4, 4),
(5, 1),
(5, 2);

-- --------------------------------------------------------

--
-- テーブルの構造 `etage`
--

CREATE TABLE `etage` (
  `id` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `batiment_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `etage`
--

INSERT INTO `etage` (`id`, `numero`, `batiment_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 1, 2),
(5, 4, 2),
(6, 9, 3),
(7, 4, 4),
(8, 5, 4),
(9, 0, 5);

-- --------------------------------------------------------

--
-- テーブルの構造 `famille`
--

CREATE TABLE `famille` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `famille`
--

INSERT INTO `famille` (`id`, `nom`) VALUES
(1, 'Imprimante'),
(2, 'Televiseur'),
(3, 'Projecteur');

-- --------------------------------------------------------

--
-- テーブルの構造 `image`
--

CREATE TABLE `image` (
  `id` bigint(20) NOT NULL,
  `content_type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `file_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `storage_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `intervention_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- テーブルの構造 `intervenant`
--

CREATE TABLE `intervenant` (
  `id` int(11) NOT NULL,
  `cv_id` int(11) NOT NULL,
  `mail` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `specialite` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `telephone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `intervenant`
--

INSERT INTO `intervenant` (`id`, `cv_id`, `mail`, `nom`, `prenom`, `specialite`, `telephone`) VALUES
(1, 1, 'j.courtier@loncoto.fr', 'Courtier', 'Jean-Alain', '1', 685459871),
(2, 2, 'j.miguel@loncoto.fr', 'Miguel', 'Jesus', '2', 635268476),
(3, 3, 'r.herrada@loncoto.fr', 'Herrada', 'Romain', '3', 654128547),
(4, 4, 'c.saavedra@loncoto.fr', 'Saavedra', 'Coralie', '4', 754128569),
(5, 5, 'a.shearar@loncoto.fr', 'Shearar', 'Alain', '1', 654176269),
(6, 6, 'r.courtalon@loncoto.fr', 'Courtalon', 'Romain', '2', 611254986),
(7, 7, 'c.jesus@loncoto.fr', 'Jesus', 'Christelle', '3', 745983258),
(8, 8, 'c.luiz@loncoto.fr', 'Luiz', 'Charles', '4', 632659874),
(9, 9, 'j.richard@loncoto.fr', 'Ricard', 'James', '1', 778644612),
(10, 10, 'm.hanouna@loncoto.fr', 'Hanouna', 'Malika', '2', 685477496),
(11, 11, 's.dertora@loncoto.fr', 'Dertora', 'Samy', '3', 698784512),
(12, 12, 'r.metge@loncoto.fr', 'Metge', 'Romain', '4', 633299845),
(13, 13, 'g.vic@loncoto.fr', 'Vic', 'Guillaume', '1', 774859658),
(14, 14, 'jl.bouchez@loncoto.fr', 'Bouchez', 'Jean-Luck', '2', 687789889);

-- --------------------------------------------------------

--
-- テーブルの構造 `intervention`
--

CREATE TABLE `intervention` (
  `id` int(11) NOT NULL,
  `commentaire_intervenant` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `date_planification` date DEFAULT NULL,
  `date_realisation` date DEFAULT NULL,
  `description_panne` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `intervenant_id` int(11) DEFAULT NULL,
  `materiel_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `intervention`
--

INSERT INTO `intervention` (`id`, `commentaire_intervenant`, `date_planification`, `date_realisation`, `description_panne`, `status`, `intervenant_id`, `materiel_id`) VALUES
(1, 'reparation terminee', '2018-05-10', '2018-05-15', 'panne de type A', 'realisee', 1, 1),
(2, 'reparation terminee mais besoin d\'une reparation preventive', '2018-05-11', '2018-06-19', 'panne de type B', 'realisee', 2, 2),
(3, 'no comment', '2018-06-06', '2018-08-22', 'panne de type C', 'curative', 3, 3),
(4, 'no comment', '2018-07-26', '2018-09-05', 'panne de type A', 'preventive', 4, 4),
(5, 'no comment', '2018-07-17', '2018-09-08', 'panne de type C', 'curative', 5, 9);

-- --------------------------------------------------------

--
-- テーブルの構造 `materiel`
--

CREATE TABLE `materiel` (
  `id` int(11) NOT NULL,
  `serial_number` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `salle_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `materiel`
--

INSERT INTO `materiel` (`id`, `serial_number`, `article_id`, `client_id`, `salle_id`) VALUES
(1, 'ABC973133717186', 3, 1, 1),
(2, 'DEF968541558862', 1, 1, 2),
(3, 'GHI154771552985', 8, 2, 3),
(4, 'EFG697751556428', 2, 2, 3),
(5, 'JKL984476621258', 4, 5, 4),
(6, 'MNO258545228841', 5, 2, 5),
(7, 'PQR658768167524', 6, 1, 6),
(8, 'STU712664719952', 7, 1, 7),
(9, 'VWX891746614771', 2, 3, 8),
(10, 'YZA217737551496', 6, 3, 8),
(11, 'BCD912336987452', 8, 4, 9);

-- --------------------------------------------------------

--
-- テーブルの構造 `salle`
--

CREATE TABLE `salle` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `etage_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `salle`
--

INSERT INTO `salle` (`id`, `nom`, `etage_id`) VALUES
(1, 'Azur', 1),
(2, 'Pervenche', 2),
(3, '302', 3),
(4, 'Reunion A', 4),
(5, '406', 5),
(6, 'Lin', 6),
(7, 'Pistache', 6),
(8, '410', 7),
(9, '503', 8),
(10, 'Labo B2', 9);

-- --------------------------------------------------------

--
-- テーブルの構造 `site`
--

CREATE TABLE `site` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `site`
--

INSERT INTO `site` (`id`, `adresse`, `latitude`, `longitude`, `nom`) VALUES
(1, '25 rue de la decoration 75008', 48.88015782668268, 2.3021831645569364, 'Digital Art IDF'),
(2, '89 avenue de la vieille ville 33000', 48.99125783678268, 2.4021965645569394, 'Media Jet Bordeaux'),
(3, '116 avenue Claude E Shannon 92400', 47.88015782668268, 5.302183164556936, 'Expert Access La Defense'),
(4, '59 rue du chemin verdoyant 75012', 47.88986526682689, 2.30218125698693, 'EcoPart IDF');

-- --------------------------------------------------------

--
-- テーブルの構造 `sous_famille`
--

CREATE TABLE `sous_famille` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `famille_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- テーブルのデータのダンプ `sous_famille`
--

INSERT INTO `sous_famille` (`id`, `nom`, `famille_id`) VALUES
(1, 'Imprimante jet d\'encre', 1),
(2, 'Imprimante laser', 1),
(3, 'Televiseur OLED', 2),
(4, 'Televiseur Plasma', 2),
(5, 'Videoprojecteur', 3),
(6, 'Retroprojecteur', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjj9rxu6egd1h4883nwcpkn2pl` (`sous_famille_id`);

--
-- Indexes for table `batiment`
--
ALTER TABLE `batiment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf41flig2235or0c5me4on2orm` (`site_id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `client_sites`
--
ALTER TABLE `client_sites`
  ADD PRIMARY KEY (`clients_id`,`sites_id`),
  ADD KEY `FKhih6wi4y999yc4s81m0i2yfok` (`sites_id`);

--
-- Indexes for table `etage`
--
ALTER TABLE `etage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK34p7mnsfavvf0nwqstf8d342v` (`batiment_id`);

--
-- Indexes for table `famille`
--
ALTER TABLE `famille`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmq01j6eiyi8vd8v641t8m76bm` (`intervention_id`);

--
-- Indexes for table `intervenant`
--
ALTER TABLE `intervenant`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `intervention`
--
ALTER TABLE `intervention`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1gq45xrtd7j688juiuto7vs3x` (`intervenant_id`),
  ADD KEY `FK9kenlchr3krdac5pd53nre1ia` (`materiel_id`);

--
-- Indexes for table `materiel`
--
ALTER TABLE `materiel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn4syf6r9mesx5gngvx85jqr5i` (`article_id`),
  ADD KEY `FKe1pyrhny75x6wvyjh05i39bm9` (`client_id`),
  ADD KEY `FKp057v4x0sac33cxq4ppu3vvwm` (`salle_id`);

--
-- Indexes for table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlnluj1ex74abqjivhvvd2cq5x` (`etage_id`);

--
-- Indexes for table `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sous_famille`
--
ALTER TABLE `sous_famille`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqihlu5kt7l1ses8ks8vxdk4r2` (`famille_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `article`
--
ALTER TABLE `article`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `batiment`
--
ALTER TABLE `batiment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `etage`
--
ALTER TABLE `etage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `famille`
--
ALTER TABLE `famille`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `image`
--
ALTER TABLE `image`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `intervenant`
--
ALTER TABLE `intervenant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `intervention`
--
ALTER TABLE `intervention`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `materiel`
--
ALTER TABLE `materiel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `salle`
--
ALTER TABLE `salle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `site`
--
ALTER TABLE `site`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `sous_famille`
--
ALTER TABLE `sous_famille`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- ダンプしたテーブルの制約
--

--
-- テーブルの制約 `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `FKjj9rxu6egd1h4883nwcpkn2pl` FOREIGN KEY (`sous_famille_id`) REFERENCES `sous_famille` (`id`);

--
-- テーブルの制約 `batiment`
--
ALTER TABLE `batiment`
  ADD CONSTRAINT `FKf41flig2235or0c5me4on2orm` FOREIGN KEY (`site_id`) REFERENCES `site` (`id`);

--
-- テーブルの制約 `client_sites`
--
ALTER TABLE `client_sites`
  ADD CONSTRAINT `FK2mimln7fyonw9iqm0nbhqd783` FOREIGN KEY (`clients_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `FKhih6wi4y999yc4s81m0i2yfok` FOREIGN KEY (`sites_id`) REFERENCES `site` (`id`);

--
-- テーブルの制約 `etage`
--
ALTER TABLE `etage`
  ADD CONSTRAINT `FK34p7mnsfavvf0nwqstf8d342v` FOREIGN KEY (`batiment_id`) REFERENCES `batiment` (`id`);

--
-- テーブルの制約 `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `FKmq01j6eiyi8vd8v641t8m76bm` FOREIGN KEY (`intervention_id`) REFERENCES `intervention` (`id`);

--
-- テーブルの制約 `intervention`
--
ALTER TABLE `intervention`
  ADD CONSTRAINT `FK1gq45xrtd7j688juiuto7vs3x` FOREIGN KEY (`intervenant_id`) REFERENCES `intervenant` (`id`),
  ADD CONSTRAINT `FK9kenlchr3krdac5pd53nre1ia` FOREIGN KEY (`materiel_id`) REFERENCES `materiel` (`id`);

--
-- テーブルの制約 `materiel`
--
ALTER TABLE `materiel`
  ADD CONSTRAINT `FKe1pyrhny75x6wvyjh05i39bm9` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `FKn4syf6r9mesx5gngvx85jqr5i` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
  ADD CONSTRAINT `FKp057v4x0sac33cxq4ppu3vvwm` FOREIGN KEY (`salle_id`) REFERENCES `salle` (`id`);

--
-- テーブルの制約 `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `FKlnluj1ex74abqjivhvvd2cq5x` FOREIGN KEY (`etage_id`) REFERENCES `etage` (`id`);

--
-- テーブルの制約 `sous_famille`
--
ALTER TABLE `sous_famille`
  ADD CONSTRAINT `FKqihlu5kt7l1ses8ks8vxdk4r2` FOREIGN KEY (`famille_id`) REFERENCES `famille` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
