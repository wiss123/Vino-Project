-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Apr 06, 2024 alle 13:39
-- Versione del server: 10.4.24-MariaDB
-- Versione PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vinoproject`
--

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste `listacquistarepropostavino`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `listacquistarepropostavino` (
`IdOrdine` int(11)
,`IdPersone` int(11)
,`Date` date
,`isVendita` varchar(6)
,`isProposa` varchar(6)
);

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste `listordinevino`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `listordinevino` (
`IdOrdine` int(11)
,`NomeVino` varchar(150)
,`Bottiglia` int(11)
,`Cassa6` int(11)
,`Cassa12` int(11)
,`Prezzo` float(7,2)
,`Nome` varchar(30)
,`Cognome` varchar(30)
,`Indirizzio` varchar(30)
,`Date` date
,`Disponibile` int(11)
,`isProposa` varchar(6)
,`Idvino` int(11)
,`IdPersone` int(11)
,`DateConsegna` varchar(15)
,`DispBot` int(11)
,`DispCassa6` int(11)
,`DispCassa12` int(11)
);

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste `listpropostaview`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `listpropostaview` (
`DateProposta` varchar(10)
,`NomeVino` varchar(150)
,`Nome` varchar(30)
,`IdProposta` int(11)
,`isPrepara` varchar(6)
,`isReady` varchar(6)
,`IdPersone` int(11)
,`Idvino` int(11)
,`isPagata` varchar(6)
,`IdOrdine` int(11)
,`isProposa` varchar(6)
,`isVendita` varchar(6)
,`dispBottiglia` int(11)
,`disCassa6` int(11)
,`disCassa12` int(11)
,`Prezzo` float(7,2)
,`NumVinoProposta` int(11)
,`NumCassa6` int(11)
,`NumCassa12` int(11)
,`IdFornitore` int(11)
);

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste `listrecensione`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `listrecensione` (
`IdVendita` int(11)
,`IdOrdine` int(11)
,`DateVendita` varchar(30)
,`IdPersone` int(11)
,`Voto` varchar(11)
,`Comment` varchar(300)
,`Nome` varchar(30)
,`NomeVino` varchar(150)
,`Bottiglia` int(11)
,`Cassa6` int(11)
,`Cassa12` int(11)
,`isVendita` varchar(6)
);

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste `listvinoview`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `listvinoview` (
`Idvino` int(11)
,`NomeVino` varchar(150)
,`Produttore` varchar(50)
,`Provenienza` varchar(50)
,`Anno` varchar(50)
,`Note` varchar(50)
,`Prezzo` float(7,2)
,`Vitgini` varchar(150)
,`Disponibile` int(11)
,`Limita` int(11)
,`ImageVino` varchar(200)
,`Bottiglia` int(11)
,`Cassa6` int(11)
,`Cassa12` int(11)
);

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine`
--

CREATE TABLE `ordine` (
  `IdOrdine` int(11) NOT NULL,
  `IdVino` int(11) NOT NULL,
  `Bottiglia` int(11) NOT NULL,
  `Cassa6` int(11) NOT NULL,
  `Cassa12` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ordine`
--

INSERT INTO `ordine` (`IdOrdine`, `IdVino`, `Bottiglia`, `Cassa6`, `Cassa12`) VALUES
(314, 2, 1, 0, 0),
(315, 3, 0, 2, 0),
(316, 17, 3, 1, 2),
(317, 17, 1, 2, 0),
(318, 3, 10, 0, 0),
(319, 1, 1, 0, 0),
(320, 25, 5, 2, 1),
(320, 29, 2, 0, 0),
(321, 29, 10, 0, 0),
(322, 26, 0, 25, 0),
(323, 26, 0, 0, 0),
(324, 25, 1, 0, 0),
(324, 27, 1, 0, 0),
(325, 31, 1, 2, 0),
(325, 33, 1, 0, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `ordinedetails`
--

CREATE TABLE `ordinedetails` (
  `IdOrdine` int(11) NOT NULL,
  `IdPersone` int(11) NOT NULL,
  `Date` date NOT NULL,
  `isVendita` varchar(6) NOT NULL DEFAULT 'false',
  `isProposa` varchar(6) NOT NULL DEFAULT 'false',
  `NetTotal` float(7,2) NOT NULL DEFAULT 0.00,
  `DateConsegna` varchar(15) NOT NULL DEFAULT '',
  `Spesa` int(11) NOT NULL DEFAULT 0,
  `DateOrdine` date NOT NULL DEFAULT current_timestamp(),
  `isSpesa` varchar(5) NOT NULL DEFAULT 'false'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ordinedetails`
--

INSERT INTO `ordinedetails` (`IdOrdine`, `IdPersone`, `Date`, `isVendita`, `isProposa`, `NetTotal`, `DateConsegna`, `Spesa`, `DateOrdine`, `isSpesa`) VALUES
(314, 34, '2023-03-26', 'true', 'false', 3.00, '2023-04-05', 0, '2023-03-26', 'false'),
(315, 34, '2023-03-26', 'true', 'true', 11.16, '2023-04-05', 0, '2023-03-26', 'false'),
(316, 1, '2023-03-26', 'false', 'true', 0.00, '2023-04-05', 297, '2023-03-26', 'true'),
(317, 34, '2023-03-26', 'true', 'false', 109.44, '2023-04-05', 0, '2023-03-26', 'false'),
(318, 1, '2023-03-26', 'false', 'true', 0.00, '2023-04-05', 10, '2023-03-26', 'true'),
(319, 34, '2023-03-27', 'true', 'false', 9.00, '2023-04-06', 0, '2023-03-27', 'false'),
(320, 33, '2023-03-27', 'true', 'false', 356.62, '2023-04-06', 0, '2023-03-27', 'false'),
(321, 1, '2023-03-27', 'false', 'true', 0.00, '2023-04-06', 179, '2023-03-27', 'true'),
(322, 33, '2023-03-27', 'true', 'true', 648.60, '2023-04-06', 0, '2023-03-27', 'false'),
(323, 1, '2024-04-04', 'false', 'true', 0.00, '2024-04-14', 0, '2024-04-04', 'true'),
(324, 33, '2024-04-04', 'false', 'false', 39.80, '2024-04-14', 0, '2024-04-04', 'false'),
(325, 33, '2024-04-04', 'false', 'false', 578.90, '2024-04-14', 0, '2024-04-04', 'false');

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste `ordineview`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `ordineview` (
`Nome` varchar(30)
,`Date` date
,`isVendita` varchar(6)
,`isProposa` varchar(6)
,`IdOrdine` int(11)
);

-- --------------------------------------------------------

--
-- Struttura della tabella `persone`
--

CREATE TABLE `persone` (
  `IdPersone` int(11) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `Cognome` varchar(30) NOT NULL,
  `Codice_fiscale` varchar(30) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `Indirizzio` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `isAdmin` varchar(5) DEFAULT 'false',
  `isCliente` varchar(5) DEFAULT 'false',
  `isImpiegato` varchar(5) DEFAULT 'false',
  `isFornitore` varchar(5) NOT NULL DEFAULT 'false',
  `NumeroCarta` int(11) NOT NULL DEFAULT 0,
  `NomeSullaCarta` varchar(30) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `persone`
--

INSERT INTO `persone` (`IdPersone`, `Nome`, `Cognome`, `Codice_fiscale`, `Email`, `Phone`, `Indirizzio`, `Password`, `isAdmin`, `isCliente`, `isImpiegato`, `isFornitore`, `NumeroCarta`, `NomeSullaCarta`) VALUES
(1, 'wissam', 'ahmad', 'aaaa', '123', '222', 'Parma', '123', 'true', 'false', 'false', 'false', 0, '0'),
(4, 'Jakobo', 'ayman', 'jjsn22', '111', '228847', 'Parma', '111', 'false', 'false', 'true', 'false', 0, '0'),
(33, 'Salvatore', 'Sabisi', 'aaaa', '000', '222', 'Milano', '000', 'false', 'true', 'false', 'false', 0, '0'),
(34, 'Luna', 'Caiani', 'L24141', '222', '112254', 'ssss', '222', 'false', 'true', 'false', 'false', 0, '0'),
(36, 'Rossi', 'Montilini', '412', '444', '2232', '2232', '444', 'false', 'false', 'false', 'true', 0, '0'),
(45, 'JIJI', 'Salmoni', 'SAl224', 'jiji', '447755', 'Parma-Via Venezia-13', 'jiji', 'false', 'false', 'false', 'true', 0, ''),
(46, 'Sam', 'Moni', 'Smkik475', '777', '7744552', 'Parma-Via Trieste - 4', '777', 'false', 'false', 'true', 'false', 0, '');

-- --------------------------------------------------------

--
-- Struttura della tabella `proposta`
--

CREATE TABLE `proposta` (
  `IdProposta` int(11) NOT NULL,
  `IdVino` int(11) NOT NULL,
  `IdPersone` int(11) NOT NULL,
  `DateProposta` varchar(10) NOT NULL,
  `NumVinoProposta` int(11) NOT NULL,
  `isReady` varchar(6) NOT NULL DEFAULT 'false',
  `isPrepara` varchar(6) NOT NULL DEFAULT 'false',
  `isPagata` varchar(6) NOT NULL DEFAULT 'false',
  `IdOrdine` int(11) NOT NULL,
  `NumCassa6` int(11) NOT NULL,
  `NumCassa12` int(11) NOT NULL,
  `IdFornitore` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `proposta`
--

INSERT INTO `proposta` (`IdProposta`, `IdVino`, `IdPersone`, `DateProposta`, `NumVinoProposta`, `isReady`, `isPrepara`, `isPagata`, `IdOrdine`, `NumCassa6`, `NumCassa12`, `IdFornitore`) VALUES
(81, 17, 1, '2023-03-26', 0, 'true', 'true', 'false', 311, 10, 0, 45),
(82, 3, 34, '2023-03-26', 0, 'true', 'true', 'true', 315, 2, 0, 45),
(83, 17, 1, '2023-03-26', 3, 'true', 'true', 'false', 316, 1, 2, 45),
(84, 3, 1, '2023-03-26', 10, 'true', 'true', 'false', 318, 0, 0, 45),
(85, 29, 1, '2023-03-27', 10, 'true', 'true', 'false', 321, 0, 0, 45),
(86, 26, 33, '2023-03-27', 0, 'true', 'true', 'true', 322, 25, 0, 36),
(87, 26, 1, '2024-04-04', 0, 'false', 'true', 'false', 323, 0, 0, 45);

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste `reportview`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `reportview` (
`NomeVino` varchar(150)
,`Vendita` double(19,2)
,`Spesa` decimal(32,0)
,`disponibile_Bottiglia` int(11)
,`disponibile_Cassa6` int(11)
,`disponibile_Cassa12` int(11)
,`Vendita_Bottiglia` decimal(32,0)
,`Vendita_Cassa6` decimal(32,0)
,`Vendita_Cassa12` decimal(32,0)
,`DateOrdine` date
,`DateVendita` varchar(30)
);

-- --------------------------------------------------------

--
-- Struttura della tabella `vendita`
--

CREATE TABLE `vendita` (
  `IdVendita` int(11) NOT NULL,
  `IdOrdine` int(11) NOT NULL,
  `DateVendita` varchar(30) NOT NULL,
  `IdPersone` int(11) NOT NULL,
  `Voto` varchar(11) NOT NULL DEFAULT '',
  `Comment` varchar(300) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `vendita`
--

INSERT INTO `vendita` (`IdVendita`, `IdOrdine`, `DateVendita`, `IdPersone`, `Voto`, `Comment`) VALUES
(23, 314, '2023-03-26', 34, '9 ', 'Very Good'),
(24, 315, '2023-03-26', 34, '4 ', 'Bad'),
(25, 316, '2023-03-26', 1, '', ''),
(26, 317, '2023-03-26', 34, '', ''),
(27, 318, '2023-03-26', 1, '', ''),
(28, 319, '2023-03-27', 34, '', ''),
(29, 320, '2023-03-27', 33, '4 ', 'Bad'),
(30, 320, '2023-03-27', 33, '4 ', 'Bad'),
(31, 321, '2023-03-27', 1, '', ''),
(32, 322, '2023-03-27', 33, '', '');

-- --------------------------------------------------------

--
-- Struttura della tabella `vino`
--

CREATE TABLE `vino` (
  `Idvino` int(11) NOT NULL,
  `NomeVino` varchar(150) NOT NULL,
  `Produttore` varchar(50) NOT NULL,
  `Provenienza` varchar(50) NOT NULL,
  `Anno` varchar(50) NOT NULL,
  `Note` varchar(50) NOT NULL,
  `Prezzo` float(7,2) NOT NULL,
  `Vitgini` varchar(150) NOT NULL,
  `Disponibile` int(11) NOT NULL,
  `Limita` int(11) NOT NULL,
  `ImageVino` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `vino`
--

INSERT INTO `vino` (`Idvino`, `NomeVino`, `Produttore`, `Provenienza`, `Anno`, `Note`, `Prezzo`, `Vitgini`, `Disponibile`, `Limita`, `ImageVino`) VALUES
(1, 'Lambrusco Colli di Parma', 'Lamoretti', 'Casatico - Parma', '2017', '', 9.00, 'Lambrusco Maestri 100%', 48, 2, 'file:/C:/Users/Wissam/eclipse-workspace/PojectVino/src/Image/Vino.png'),
(25, 'Malandrino Montepulciano Abruzzo Bio', 'Cataldi Mandonna', 'Abruzzo', '2020', '', 11.90, 'Montepulciano 100%', 20, 5, 'file:/C:/Users/Wissam/eclipse-workspace/PojectVino/src/Image/Vino%202.png'),
(26, 'Nero Avola Sicilia', 'Mandarossa', 'Menfi - Agrigento', '2021', '', 9.20, 'Nero Avola 100%', 25, 7, 'file:/C:/Users/Wissam/eclipse-workspace/PojectVino/src/Image/Vino%203.png'),
(27, 'Chianti Classico', 'Querciablla', 'Toscana', '2019', '', 27.90, 'Sangiovese 100%', 100, 10, 'file:/C:/Users/Wissam/eclipse-workspace/PojectVino/src/Image/NoImage.png'),
(29, 'Franciacorta Brut Storica 61 Berlucchi', 'Berlucchi 61', 'Franciacorta', '2018', '', 17.90, 'Chardonnay 90% Pinot Nero 10%', 10, 5, 'file:/C:/Users/Wissam/eclipse-workspace/PojectVino/src/Image/Vino%205.png'),
(30, 'Maurus Merlot', 'Vie di Romans', 'Friuli Venezia Giulia', '2018', '', 21.90, 'Merlot 100%', 50, 10, 'file:/C:/Users/Wissam/eclipse-workspace/PojectVino/src/Image/Vino%206.png'),
(31, 'Pinot Grigio', 'Hofstatter', 'Alto Adige - Bolzano', '2021', '', 11.80, 'Pinot Grigio 100%', 20, 5, 'file:/C:/Users/Wissam/eclipse-workspace/PojectVino/src/Image/Vino%207.png'),
(32, 'Nebbiolo Alba \"Michet\"', 'Marchesi di Barolo', 'o Barolo - Cuneo', '2019', '', 15.90, 'Nebbiolo 100%', 70, 11, 'file:/C:/Users/Wissam/eclipse-workspace/PojectVino/src/Image/NoImage.png'),
(33, 'Sauvignon Blanc \"Lehen\"', 'Alois Lageder', 'Magu - Bolzano', '2019', '', 19.90, 'Sauvignon Blanc 100%', 105, 15, 'file:/C:/Users/Wissam/eclipse-workspace/PojectVino/src/Image/Vino%209.png'),
(34, 'Prosecco superiore Valdobbiadene Extra Dry \"Il Soller\"', 'Marsuret', 'Valdobbiadene - Treviso', '2022', '', 11.80, 'Pinot Grigio 100%', 30, 5, 'file:/C:/Users/Wissam/eclipse-workspace/PojectVino/src/Image/Vino%2010.png');

-- --------------------------------------------------------

--
-- Struttura della tabella `vinoquantita`
--

CREATE TABLE `vinoquantita` (
  `IdVino` int(11) NOT NULL,
  `Bottiglia` int(11) NOT NULL,
  `Cassa6` int(11) NOT NULL,
  `Cassa12` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `vinoquantita`
--

INSERT INTO `vinoquantita` (`IdVino`, `Bottiglia`, `Cassa6`, `Cassa12`) VALUES
(1, 47, 29, 38),
(2, 12, 12, 12),
(3, 58, 29, 40),
(14, 50, 3, 3),
(15, 40, 28, 28),
(16, 40, 28, 28),
(17, 92, 95, 80),
(17, 100, 75, 65),
(17, 100, 80, 70),
(3, 22, 23, 12),
(3, 12, 12, 12),
(2, 12, 12, 12),
(21, 123, 123, 123),
(22, 312, 312, 312),
(23, 222, 222, 222),
(24, 222, 222, 222),
(25, 15, 13, 9),
(26, 25, 20, 15),
(27, 100, 80, 70),
(28, 48, 29, 38),
(29, 18, 15, 20),
(30, 50, 55, 80),
(31, 20, 15, 30),
(32, 70, 66, 80),
(33, 105, 55, 60),
(34, 30, 40, 50);

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste `vinovenditaview`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `vinovenditaview` (
`NomeVino` varchar(150)
,`num` decimal(32,0)
,`VCassa6` decimal(32,0)
,`VCassa12` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Struttura per vista `listacquistarepropostavino`
--
DROP TABLE IF EXISTS `listacquistarepropostavino`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listacquistarepropostavino`  AS SELECT `ordinedetails`.`IdOrdine` AS `IdOrdine`, `ordinedetails`.`IdPersone` AS `IdPersone`, `ordinedetails`.`Date` AS `Date`, `ordinedetails`.`isVendita` AS `isVendita`, `ordinedetails`.`isProposa` AS `isProposa` FROM `ordinedetails` WHERE `ordinedetails`.`isProposa` = 'true' AND `ordinedetails`.`isVendita` = 'false''false'  ;

-- --------------------------------------------------------

--
-- Struttura per vista `listordinevino`
--
DROP TABLE IF EXISTS `listordinevino`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listordinevino`  AS SELECT `ordine`.`IdOrdine` AS `IdOrdine`, `vino`.`NomeVino` AS `NomeVino`, `ordine`.`Bottiglia` AS `Bottiglia`, `ordine`.`Cassa6` AS `Cassa6`, `ordine`.`Cassa12` AS `Cassa12`, `vino`.`Prezzo` AS `Prezzo`, `persone`.`Nome` AS `Nome`, `persone`.`Cognome` AS `Cognome`, `persone`.`Indirizzio` AS `Indirizzio`, `ordinedetails`.`Date` AS `Date`, `vino`.`Disponibile` AS `Disponibile`, `ordinedetails`.`isProposa` AS `isProposa`, `vino`.`Idvino` AS `Idvino`, `persone`.`IdPersone` AS `IdPersone`, `ordinedetails`.`DateConsegna` AS `DateConsegna`, `vinoquantita`.`Bottiglia` AS `DispBot`, `vinoquantita`.`Cassa6` AS `DispCassa6`, `vinoquantita`.`Cassa12` AS `DispCassa12` FROM ((((`ordine` join `vino`) join `ordinedetails`) join `persone`) join `vinoquantita`) WHERE `ordine`.`IdVino` = `vino`.`Idvino` AND `vinoquantita`.`IdVino` = `vino`.`Idvino` AND `ordinedetails`.`IdPersone` = `persone`.`IdPersone` AND `ordinedetails`.`IdOrdine` = `ordine`.`IdOrdine``IdOrdine`  ;

-- --------------------------------------------------------

--
-- Struttura per vista `listpropostaview`
--
DROP TABLE IF EXISTS `listpropostaview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listpropostaview`  AS SELECT `proposta`.`DateProposta` AS `DateProposta`, `vino`.`NomeVino` AS `NomeVino`, `persone`.`Nome` AS `Nome`, `proposta`.`IdProposta` AS `IdProposta`, `proposta`.`isPrepara` AS `isPrepara`, `proposta`.`isReady` AS `isReady`, `persone`.`IdPersone` AS `IdPersone`, `vino`.`Idvino` AS `Idvino`, `proposta`.`isPagata` AS `isPagata`, `ordinedetails`.`IdOrdine` AS `IdOrdine`, `ordinedetails`.`isProposa` AS `isProposa`, `ordinedetails`.`isVendita` AS `isVendita`, `vinoquantita`.`Bottiglia` AS `dispBottiglia`, `vinoquantita`.`Cassa6` AS `disCassa6`, `vinoquantita`.`Cassa12` AS `disCassa12`, `vino`.`Prezzo` AS `Prezzo`, `proposta`.`NumVinoProposta` AS `NumVinoProposta`, `proposta`.`NumCassa6` AS `NumCassa6`, `proposta`.`NumCassa12` AS `NumCassa12`, `proposta`.`IdFornitore` AS `IdFornitore` FROM ((((`proposta` join `ordinedetails`) join `vino`) join `persone`) join `vinoquantita`) WHERE `proposta`.`IdOrdine` = `ordinedetails`.`IdOrdine` AND `proposta`.`IdVino` = `vino`.`Idvino` AND `proposta`.`IdPersone` = `persone`.`IdPersone` AND `vinoquantita`.`IdVino` = `vino`.`Idvino``Idvino`  ;

-- --------------------------------------------------------

--
-- Struttura per vista `listrecensione`
--
DROP TABLE IF EXISTS `listrecensione`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listrecensione`  AS SELECT `vendita`.`IdVendita` AS `IdVendita`, `vendita`.`IdOrdine` AS `IdOrdine`, `vendita`.`DateVendita` AS `DateVendita`, `vendita`.`IdPersone` AS `IdPersone`, `vendita`.`Voto` AS `Voto`, `vendita`.`Comment` AS `Comment`, `persone`.`Nome` AS `Nome`, `vino`.`NomeVino` AS `NomeVino`, `ordine`.`Bottiglia` AS `Bottiglia`, `ordine`.`Cassa6` AS `Cassa6`, `ordine`.`Cassa12` AS `Cassa12`, `ordinedetails`.`isVendita` AS `isVendita` FROM ((((`vendita` join `persone`) join `vino`) join `ordinedetails`) join `ordine`) WHERE `vendita`.`IdPersone` = `persone`.`IdPersone` AND `vendita`.`IdOrdine` = `ordinedetails`.`IdOrdine` AND `ordinedetails`.`IdOrdine` = `ordine`.`IdOrdine` AND `ordine`.`IdVino` = `vino`.`Idvino``Idvino`  ;

-- --------------------------------------------------------

--
-- Struttura per vista `listvinoview`
--
DROP TABLE IF EXISTS `listvinoview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listvinoview`  AS SELECT `vino`.`Idvino` AS `Idvino`, `vino`.`NomeVino` AS `NomeVino`, `vino`.`Produttore` AS `Produttore`, `vino`.`Provenienza` AS `Provenienza`, `vino`.`Anno` AS `Anno`, `vino`.`Note` AS `Note`, `vino`.`Prezzo` AS `Prezzo`, `vino`.`Vitgini` AS `Vitgini`, `vino`.`Disponibile` AS `Disponibile`, `vino`.`Limita` AS `Limita`, `vino`.`ImageVino` AS `ImageVino`, `vinoquantita`.`Bottiglia` AS `Bottiglia`, `vinoquantita`.`Cassa6` AS `Cassa6`, `vinoquantita`.`Cassa12` AS `Cassa12` FROM (`vino` join `vinoquantita`) WHERE `vino`.`Idvino` = `vinoquantita`.`IdVino``IdVino`  ;

-- --------------------------------------------------------

--
-- Struttura per vista `ordineview`
--
DROP TABLE IF EXISTS `ordineview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ordineview`  AS SELECT `persone`.`Nome` AS `Nome`, `ordinedetails`.`Date` AS `Date`, `ordinedetails`.`isVendita` AS `isVendita`, `ordinedetails`.`isProposa` AS `isProposa`, `ordinedetails`.`IdOrdine` AS `IdOrdine` FROM (`persone` join `ordinedetails`) WHERE `persone`.`IdPersone` = `ordinedetails`.`IdPersone``IdPersone`  ;

-- --------------------------------------------------------

--
-- Struttura per vista `reportview`
--
DROP TABLE IF EXISTS `reportview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reportview`  AS SELECT `vino`.`NomeVino` AS `NomeVino`, sum(`ordinedetails`.`NetTotal`) AS `Vendita`, sum(`ordinedetails`.`Spesa`) AS `Spesa`, `vinoquantita`.`Bottiglia` AS `disponibile_Bottiglia`, `vinoquantita`.`Cassa6` AS `disponibile_Cassa6`, `vinoquantita`.`Cassa12` AS `disponibile_Cassa12`, sum(`ordine`.`Bottiglia`) AS `Vendita_Bottiglia`, sum(`ordine`.`Cassa6`) AS `Vendita_Cassa6`, sum(`ordine`.`Cassa12`) AS `Vendita_Cassa12`, `ordinedetails`.`DateOrdine` AS `DateOrdine`, `vendita`.`DateVendita` AS `DateVendita` FROM ((((`ordinedetails` join `ordine`) join `vino`) join `vinoquantita`) join `vendita`) WHERE `ordinedetails`.`IdOrdine` = `ordine`.`IdOrdine` AND `vendita`.`IdOrdine` = `ordine`.`IdOrdine` AND `vinoquantita`.`IdVino` = `vino`.`Idvino` AND `vino`.`Idvino` = `ordine`.`IdVino` GROUP BY `vino`.`NomeVino``NomeVino`  ;

-- --------------------------------------------------------

--
-- Struttura per vista `vinovenditaview`
--
DROP TABLE IF EXISTS `vinovenditaview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vinovenditaview`  AS SELECT `vino`.`NomeVino` AS `NomeVino`, sum(`ordine`.`Bottiglia`) AS `num`, sum(`ordine`.`Cassa6`) AS `VCassa6`, sum(`ordine`.`Cassa12`) AS `VCassa12` FROM ((`ordine` join `vino`) join `ordinedetails`) WHERE `ordine`.`IdVino` = `vino`.`Idvino` AND `ordinedetails`.`IdOrdine` = `ordine`.`IdOrdine` AND `ordinedetails`.`isVendita` = 'true' GROUP BY `vino`.`NomeVino``NomeVino`  ;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `ordinedetails`
--
ALTER TABLE `ordinedetails`
  ADD PRIMARY KEY (`IdOrdine`);

--
-- Indici per le tabelle `persone`
--
ALTER TABLE `persone`
  ADD PRIMARY KEY (`IdPersone`);

--
-- Indici per le tabelle `proposta`
--
ALTER TABLE `proposta`
  ADD PRIMARY KEY (`IdProposta`);

--
-- Indici per le tabelle `vendita`
--
ALTER TABLE `vendita`
  ADD PRIMARY KEY (`IdVendita`);

--
-- Indici per le tabelle `vino`
--
ALTER TABLE `vino`
  ADD PRIMARY KEY (`Idvino`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `ordinedetails`
--
ALTER TABLE `ordinedetails`
  MODIFY `IdOrdine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=326;

--
-- AUTO_INCREMENT per la tabella `persone`
--
ALTER TABLE `persone`
  MODIFY `IdPersone` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT per la tabella `proposta`
--
ALTER TABLE `proposta`
  MODIFY `IdProposta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;

--
-- AUTO_INCREMENT per la tabella `vendita`
--
ALTER TABLE `vendita`
  MODIFY `IdVendita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT per la tabella `vino`
--
ALTER TABLE `vino`
  MODIFY `Idvino` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
