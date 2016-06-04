-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 04 Juin 2016 à 18:13
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `spectasonic_location`
--

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `categorie_id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie_nom` varchar(30) NOT NULL,
  `categories_desc` varchar(1000) NOT NULL,
  PRIMARY KEY (`categorie_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `categories`
--

INSERT INTO `categories` (`categorie_id`, `categorie_nom`, `categories_desc`) VALUES
(1, 'enceinte', 'Que ce soit pour de la Haute Fidélité ou dans une configuration Home Cinéma, le choix des enceintes est tout simplement primordial. Sans écarter l''idée de les associer à d''autres composants électroniques (en particulier l''amplificateur), tous les spécialistes sont unanimes : les enceintes ont une durée de vie optimale.'),
(2, 'câbles audio', 'Les cables Spectasonic, ainsi que ceux fabriqués par nos confrères et disponibles sur notre site, ont été rigoureusement testé par nos techniciens avant leur commercialisation. Ils fournissent la qualité optimale sans nécessairement alourdir votre budget hifi.'),
(3, 'amplificateurs', 'La réputation de notre gamme d''amplificateurs n''est plus à démontrer. Elle a marqué le siècle dernier et aborde le nouveau avec optimisme ! Vous êtes un(e) puriste, un(e) passionné(e)? Rejoignez la communauté des passionnés de la HIFI à son plus haut niveau et goûtez à l''essence même du son le plus parfait.\r\nAllumez - écoutez - vibrez.'),
(4, 'lampes', 'Les lampes d''amplificateurs ont une certaine durée de vie. Nous vous proposons de bénéficier d''une sélection de lampes définie par nos experts en fonction de leur rapport qualité / prix.\r\nNous nous employons à sortir des sentiers battus et notre catalogue de lampes réserve quelques agréables surprises que nous avons dénichées pour vous.');

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `clients_id` int(11) NOT NULL AUTO_INCREMENT,
  `clients_nom` varchar(20) NOT NULL,
  `clients_prenom` varchar(25) NOT NULL,
  `clients_adresse` varchar(40) NOT NULL,
  PRIMARY KEY (`clients_id`),
  UNIQUE KEY `id` (`clients_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `clients`
--

INSERT INTO `clients` (`clients_id`, `clients_nom`, `clients_prenom`, `clients_adresse`) VALUES
(1, 'N''Zi', 'David', 'Rue de l''EPSI'),
(2, 'Bosquet', 'Stéphane', '2 Bis rue du dev REST');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `commande_id` int(11) NOT NULL,
  `commande_date` date NOT NULL,
  `commande_client_id` int(11) NOT NULL,
  PRIMARY KEY (`commande_id`),
  KEY `client_id` (`commande_client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`commande_id`, `commande_date`, `commande_client_id`) VALUES
(1, '2016-05-02', 1),
(2, '2016-05-29', 2),
(3, '2016-05-30', 1),
(4, '2016-05-30', 1),
(5, '2016-05-30', 1),
(6, '2016-05-30', 1),
(7, '2016-05-30', 1),
(9, '2016-05-30', 1),
(10, '2016-06-04', 2);

-- --------------------------------------------------------

--
-- Structure de la table `contenu_commande`
--

CREATE TABLE IF NOT EXISTS `contenu_commande` (
  `contenu_commande_id_commande` int(11) NOT NULL,
  `contenu_commande_numero_produit` int(11) NOT NULL,
  `contenu_commande_quantite_produit` int(11) NOT NULL,
  PRIMARY KEY (`contenu_commande_id_commande`,`contenu_commande_numero_produit`),
  KEY `numero_commande` (`contenu_commande_id_commande`),
  KEY `numero_produit` (`contenu_commande_numero_produit`),
  KEY `contenu_commande_numero_produit` (`contenu_commande_numero_produit`),
  KEY `contenu_commande_quantite_produit` (`contenu_commande_quantite_produit`),
  KEY `contenu_commande_numero_commande` (`contenu_commande_id_commande`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contenu_commande`
--

INSERT INTO `contenu_commande` (`contenu_commande_id_commande`, `contenu_commande_numero_produit`, `contenu_commande_quantite_produit`) VALUES
(1, 1, 1),
(2, 1, 1),
(10, 1, 1),
(1, 2, 2),
(10, 2, 10);

-- --------------------------------------------------------

--
-- Structure de la table `planning_produit`
--

CREATE TABLE IF NOT EXISTS `planning_produit` (
  `planning_produit_id_produit` int(11) NOT NULL,
  `planning_produit_date` date NOT NULL,
  `planning_produit_disponibilite` tinyint(1) NOT NULL,
  PRIMARY KEY (`planning_produit_id_produit`,`planning_produit_date`),
  KEY `planning_produit_id_produit` (`planning_produit_id_produit`),
  KEY `planning_produit_id_produit_2` (`planning_produit_id_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `planning_produit`
--

INSERT INTO `planning_produit` (`planning_produit_id_produit`, `planning_produit_date`, `planning_produit_disponibilite`) VALUES
(1, '2016-05-30', 1),
(1, '2016-05-31', 1),
(2, '2016-05-30', 0),
(2, '2016-05-31', 1);

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

CREATE TABLE IF NOT EXISTS `produits` (
  `produits_id` int(11) NOT NULL,
  `produits_nom` varchar(20) NOT NULL,
  `produits_description` varchar(1000) NOT NULL,
  `produits_id_categorie` int(11) NOT NULL,
  `produits_prix_journalier` float NOT NULL,
  PRIMARY KEY (`produits_id`),
  KEY `produits_id_categorie` (`produits_id_categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `produits`
--

INSERT INTO `produits` (`produits_id`, `produits_nom`, `produits_description`, `produits_id_categorie`, `produits_prix_journalier`) VALUES
(1, 'Spectalizer II', 'Le SPECTALIZER II est le produit phare de SPECTASONIC.\r\nVéritable légende de la stéréo, l''ampli intégré PMA-2010AE est équipé d''un circuit d''alimentation surdimensionné et est doté de diodes de redressement Schottky associées à des condensateurs de forte capacité pour un stockage et un transfert d''énergie considérables. Avec ses étages de puissance simple Push-Pull UHC-MOS, le SPECTALIZER II restitue aussi bien le plus subtil solo de violon que le fortissimo le plus grandiose, point culminant d''une oeuvre symphonique.', 3, 55),
(2, 'Spectalizer III', 'Le SPECTALIZER III est la dernière oeuvre magistrale de Marc Poinson, ingénieur et magicien du son.\r\nQualité de fabrication, finition exemplaire, composants de très haute volée, le SPECTALIZER III répond aux exigences des audiophiles les plus intransigeants en leur offrant un amplificateur très abouti digne des meilleures productions. A associer de préférence à des enceintes haut de gamme au rendement élevé.\r\n\r\nDans sa version SPECTALIZER III E, notre amplificateur est dôté de deux sorties SPDIF pour l''intégrer à votre chaine de home cinéma.\r\n\r\nAmplificateur intégré à tubes\r\nCommutation, volume et affichage numériques\r\n\r\nPuissance de sortie : 2 x 35 W RMS\r\nRéponse en Fréquence : 18hz - 30 kHz ( /- 0.5 dB)\r\nRapport signal/bruit : > 95 dB\r\nDistortion : < 1%\r\nSensibilité d''entrée : système mv 100\r\n\r\nEntrées : 4 x RCA permutables\r\nImpédance de sortie : 4/8 ohms\r\nTélécommande multifonctions', 3, 75);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `client_id` FOREIGN KEY (`commande_client_id`) REFERENCES `clients` (`clients_id`);

--
-- Contraintes pour la table `contenu_commande`
--
ALTER TABLE `contenu_commande`
  ADD CONSTRAINT `commande_id` FOREIGN KEY (`contenu_commande_id_commande`) REFERENCES `commande` (`commande_id`),
  ADD CONSTRAINT `produits_id` FOREIGN KEY (`contenu_commande_numero_produit`) REFERENCES `produits` (`produits_id`);

--
-- Contraintes pour la table `planning_produit`
--
ALTER TABLE `planning_produit`
  ADD CONSTRAINT `planning_produit_ibfk_1` FOREIGN KEY (`planning_produit_id_produit`) REFERENCES `produits` (`produits_id`);

--
-- Contraintes pour la table `produits`
--
ALTER TABLE `produits`
  ADD CONSTRAINT `categorie_id` FOREIGN KEY (`produits_id_categorie`) REFERENCES `categories` (`categorie_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
