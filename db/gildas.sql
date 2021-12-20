-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 14 juin 2021 à 11:51
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP :  7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gildas`
--

-- --------------------------------------------------------

--
-- Structure de la table `album`
--

CREATE TABLE `album` (
  `id` int(11) NOT NULL,
  `code` varchar(12) NOT NULL,
  `titre` varchar(20) NOT NULL,
  `datedesortie` date NOT NULL,
  `idchanteur` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `album`
--

INSERT INTO `album` (`id`, `code`, `titre`, `datedesortie`, `idchanteur`) VALUES
(1, '1ADW5S', 'LOVEURS', '2021-05-19', 2),
(2, '1AW5S', 'LOVZ', '2020-11-17', 2),
(5, 'AbcdE', 'SLOW  F', '1976-05-21', 1),
(7, 'jvdhjhfd', 'dcbjdh', '2021-05-21', 1),
(8, 'jhkj78 taga', 'gildas jjhjhkj', '2015-05-14', 2),
(398, 'gildas', 'taga', '2021-06-05', 1),
(400, 'gildas58', 'taga', '2021-06-05', 1),
(401, 'ttom11F', 'tom yon', '2000-06-22', 2),
(402, 'aaAA11', 'test', '2011-02-18', 1),
(403, 'JAzz9', 'succes  jazz', '1986-06-12', 2),
(404, 'dfg', 'vcbvnb', '2021-06-01', 1),
(405, 'zouk1985', 'kassav', '1981-05-20', 1);

-- --------------------------------------------------------

--
-- Structure de la table `chanteurs`
--

CREATE TABLE `chanteurs` (
  `id` int(4) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `sexe` enum('M','F') NOT NULL,
  `ddn` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `chanteurs`
--

INSERT INTO `chanteurs` (`id`, `nom`, `prenom`, `sexe`, `ddn`) VALUES
(1, 'toto', 'titi', 'M', '2019-06-19'),
(2, 'tata', 'tete', 'F', '2016-08-16');

-- --------------------------------------------------------

--
-- Structure de la table `collabo`
--

CREATE TABLE `collabo` (
  `id` int(11) NOT NULL,
  `ida` int(4) NOT NULL,
  `idm` int(4) NOT NULL,
  `idi` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `collabo`
--

INSERT INTO `collabo` (`id`, `ida`, `idm`, `idi`) VALUES
(1, 1, 1, 1),
(3, 5, 1, 1),
(4, 2, 2, 2),
(7, 1, 1, 1),
(9, 1, 1, 1),
(11, 1, 1, 1),
(12, 398, 1, 1),
(13, 7, 2, 3),
(14, 405, 2, 3),
(15, 1, 1, 5),
(16, 403, 1, 5);

-- --------------------------------------------------------

--
-- Structure de la table `instru`
--

CREATE TABLE `instru` (
  `id` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `instru`
--

INSERT INTO `instru` (`id`, `nom`) VALUES
(1, 'piano'),
(2, 'tambou'),
(3, 'guitare'),
(4, 'clavier'),
(5, 'batterie'),
(6, 'violon');

-- --------------------------------------------------------

--
-- Structure de la table `musicien`
--

CREATE TABLE `musicien` (
  `id` int(4) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `sexe` enum('M','F') NOT NULL,
  `ddn` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `musicien`
--

INSERT INTO `musicien` (`id`, `nom`, `prenom`, `sexe`, `ddn`) VALUES
(1, 'charlotte', 'dipanda', 'F', '2014-02-18'),
(2, 'bango', 'lydol', 'F', '2019-02-13');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idchanteur` (`idchanteur`);

--
-- Index pour la table `chanteurs`
--
ALTER TABLE `chanteurs`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `collabo`
--
ALTER TABLE `collabo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ida` (`ida`),
  ADD KEY `idm` (`idm`),
  ADD KEY `idi` (`idi`);

--
-- Index pour la table `instru`
--
ALTER TABLE `instru`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `musicien`
--
ALTER TABLE `musicien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `album`
--
ALTER TABLE `album`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=406;

--
-- AUTO_INCREMENT pour la table `chanteurs`
--
ALTER TABLE `chanteurs`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `collabo`
--
ALTER TABLE `collabo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `instru`
--
ALTER TABLE `instru`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `musicien`
--
ALTER TABLE `musicien`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `album_ibfk_1` FOREIGN KEY (`idchanteur`) REFERENCES `chanteurs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `collabo`
--
ALTER TABLE `collabo`
  ADD CONSTRAINT `collabo_ibfk_1` FOREIGN KEY (`ida`) REFERENCES `album` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `collabo_ibfk_2` FOREIGN KEY (`idm`) REFERENCES `musicien` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `collabo_ibfk_3` FOREIGN KEY (`idi`) REFERENCES `instru` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
