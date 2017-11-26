/*
SQLyog Job Agent v12.4.1 (64 bit) Copyright(c) Webyog Inc. All Rights Reserved.


MySQL - 5.6.21 : Database - bd_ccm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bd_ccm` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bd_ccm`;

/*Table structure for table `area` */

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
  `ID` char(3) NOT NULL,
  `AREA` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `area` */

insert  into `area`(`ID`,`AREA`) values 
('101','ALUMBRADO PUBLICO'),
('102','BAJA TENSION'),
('103','CALIDAD DE PRODUCTO'),
('104','EMERGENCIAS'),
('105','MEDIA TENSION'),
('106','PODAS'),
('107','LOGISTICA'),
('108','SEGURIDAD'),
('109','TODAS'),
('110','TERMOGRAFIA');

/*Table structure for table `articulo` */

DROP TABLE IF EXISTS `articulo`;

CREATE TABLE `articulo` (
  `CODIGO` char(7) NOT NULL,
  `DESCRIPCION` varchar(60) NOT NULL,
  `IDTIPOARTICULO` char(4) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  KEY `IDTIPOARTICULO` (`IDTIPOARTICULO`),
  CONSTRAINT `articulo_ibfk_1` FOREIGN KEY (`IDTIPOARTICULO`) REFERENCES `tipo_articulo` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `articulo` */

insert  into `articulo`(`CODIGO`,`DESCRIPCION`,`IDTIPOARTICULO`,`CANTIDAD`) values 
('1210001','HEBILLAS DE 3/4','TA01',150),
('1210002','FLEJE DE 3/4','TA01',20),
('1210003','CINTA DE PVC','TA01',90),
('1210004','BENTONITA','TA01',25),
('1210005','CEMENTO','TA01',0),
('1210006','LENTES DE LUNA OSCURA','TA02',120),
('1210007','CINTA MASTIC','TA01',20),
('1210008','GUANTES DE CUERO DE BADANA','TA02',50),
('1210009','GUANTES DE CUERO REFORZADO','TA02',20);

/*Table structure for table `cargo` */

DROP TABLE IF EXISTS `cargo`;

CREATE TABLE `cargo` (
  `CODTRABAJADOR` char(4) NOT NULL,
  `CODHERRAMIENTA` char(10) NOT NULL,
  `CODAREA` char(10) NOT NULL,
  `FECHA` date NOT NULL,
  KEY `CODHERRAMIENTA` (`CODHERRAMIENTA`),
  KEY `CODTRABAJADOR` (`CODTRABAJADOR`),
  CONSTRAINT `cargo_ibfk_2` FOREIGN KEY (`CODHERRAMIENTA`) REFERENCES `herramienta` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cargo_ibfk_3` FOREIGN KEY (`CODTRABAJADOR`) REFERENCES `trabajador` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cargo` */

/*Table structure for table `herramienta` */

DROP TABLE IF EXISTS `herramienta`;

CREATE TABLE `herramienta` (
  `CODIGO` char(10) NOT NULL,
  `HERRAMIENTA` varchar(40) NOT NULL,
  `MARCA` varchar(20) DEFAULT NULL,
  `MODELO` varchar(20) DEFAULT NULL,
  `SERIE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `herramienta` */

/*Table structure for table `nota_salida` */

DROP TABLE IF EXISTS `nota_salida`;

CREATE TABLE `nota_salida` (
  `CODIGO` char(12) NOT NULL,
  `COD_TRAB_ENTREG` char(4) NOT NULL,
  `COD_TRAB_RECIB` char(4) NOT NULL,
  `FECHA` datetime NOT NULL,
  `IDAREA` char(3) NOT NULL,
  `CODARTICULO` char(7) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `NRO_OM` char(9) NOT NULL,
  KEY `NRO_OM` (`NRO_OM`),
  KEY `CODARTICULO` (`CODARTICULO`),
  KEY `IDAREA` (`IDAREA`),
  KEY `COD_TRAB_ENTREG` (`COD_TRAB_ENTREG`),
  KEY `COD_TRAB_RECIB` (`COD_TRAB_RECIB`),
  CONSTRAINT `nota_salida_ibfk_2` FOREIGN KEY (`CODARTICULO`) REFERENCES `articulo` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nota_salida_ibfk_3` FOREIGN KEY (`IDAREA`) REFERENCES `area` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nota_salida_ibfk_4` FOREIGN KEY (`COD_TRAB_ENTREG`) REFERENCES `trabajador` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nota_salida_ibfk_5` FOREIGN KEY (`COD_TRAB_RECIB`) REFERENCES `trabajador` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `nota_salida` */

/*Table structure for table `orden_mantenimiento` */

DROP TABLE IF EXISTS `orden_mantenimiento`;

CREATE TABLE `orden_mantenimiento` (
  `NRO` char(9) NOT NULL,
  PRIMARY KEY (`NRO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `orden_mantenimiento` */

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `DNI` char(8) NOT NULL,
  `NOMBRES` varchar(30) NOT NULL,
  `APELLIDOP` varchar(30) NOT NULL,
  `APELLIDOM` varchar(30) NOT NULL,
  `FECHANACIMIENTO` date NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `persona` */

insert  into `persona`(`DNI`,`NOMBRES`,`APELLIDOP`,`APELLIDOM`,`FECHANACIMIENTO`) values 
('02642599','Anibal','Calderon','Garcia','2017-11-20'),
('02709857','Jorge Eduardo','Chunga','Garcia','2017-11-20'),
('02792991','Angel','Ceferino','Cordova','2017-11-20'),
('02840831','Yave','Palomino','Arbayza','2017-11-20'),
('03234191','Walter','Guerrero','Vilcherrez','2017-11-20'),
('03564460','Luis','Estrada','Pardo','2017-11-20'),
('03621916','Walter','Flores','Ruiz','2017-11-20'),
('03632634','Luis Humberto','Tavara','Sabalu','2017-11-20'),
('03659044','Jaime Santiago','Mereci','Valdiviezo','2017-11-20'),
('03661740','Luis Alberto','Gutierrez','Requena','2017-11-20'),
('03681144','Luis Manuel','Torres','Cordova','2017-11-20'),
('16555947','Edwin Homero','Yaipen','Custodio','2017-11-20'),
('17537336','Cesar','Coronado','Silupu','2017-11-15'),
('21881121','Victor Angel','Almeyda','Tasayco','2017-11-20'),
('2771617','Pedro Lizandro','Iturria','Yarleque','2017-11-15'),
('3561817','Victor Andres','Correa','Nieves','2017-11-20'),
('3569871','Gaston','Navarro','Castillo','2017-11-20'),
('3651535','Manuel Estevez','Vasquez','Pacherrez','2017-11-20'),
('3669617','Edward Alejandro','Curay','Herna','2017-11-20'),
('3679064','Jose Javier','Ancajima','Reyes','2017-11-20'),
('3879045','Raul','Suarez','Nole','2017-11-20'),
('40088413','Ducblis','Castillo','Cevallos','2017-11-20'),
('40302255','Elber','Tavara','Saavedra','2017-11-20'),
('40569500','Marco','Espinoza','Sanchez','2017-11-20'),
('40693789','Jorge Nemesio','Arevalo','Cevallos','2017-11-20'),
('41053324','Jimmy Ronald','Ynoquio ','Garcia','2017-11-20'),
('41511901','Roberto Carlos','Tavara','Rivera','2017-11-20'),
('41600491','Carlos','Litano','Coveñas','2017-11-20'),
('41715724','Danny Daniel','Castillo','Dioses','2017-11-20'),
('41735712','Jose Alberto','Santamaria','Bellodas','2017-11-20'),
('41795541','Wilmer Darwin','Hidalgo','Abad','2017-11-20'),
('42843559','Luis Carlos','Agurto','Meca','2017-11-20'),
('43246013','Javier','Huamnchumo','Llenque','2017-11-20'),
('43262539','Tonny Cayetano','Heredia','Perez','2017-11-20'),
('43666076','Maria Esther','Litano','Coveñas','2017-11-20'),
('43878294','Santos Alfredo','Sandoval','Namuche','2017-11-20'),
('44182117','Joshua','Ormachea','Del Aguila','1986-12-29'),
('44316318','Erick','Sernaque','Rivera','2017-11-20'),
('44444444','Jose David','Galvez','Gonzales','2017-11-20'),
('44444445','Elvis','Mozombite','Zulueta','2017-11-20'),
('44444446','Paulo','Curay','Herna','2017-11-20'),
('44454276','Luis Enrique','Tavara','Rivera','2017-11-20'),
('44633130','Yunior','Cornejo','Urteaga','2017-11-20'),
('44775997','Juan Augusto','Santos','Villegas','2017-11-20'),
('44803053','Esdras Daniel','Elera','Castillo','2017-11-20'),
('45151584','Renzo Kield','Inga','Zacarias','2017-11-20'),
('45380816','Harry','Mori','Lopez','2017-11-20'),
('45748150','Cristhian','Ramos','Berru','2017-11-20'),
('45764210','Jose Joaquin','Ramos','Berru','2017-11-20'),
('46248420','Jarol','Gonzales','Delgado','2017-11-20'),
('46543376','Darwin','Miñope','Yaipen','2017-11-15'),
('46642210','Irvin','Vasquez','Cordova','2017-11-15'),
('46691311','Hermiz Jhon','Garcia','Hernandez','2017-11-20'),
('46932616','Jhon','Agurto','Alburqueque','2017-11-20'),
('47255879','Danni Efrain','Acaro','Hernadez','1991-09-05'),
('47468968','Carlos Alberto','Godos','Peña','2017-11-20'),
('47817460','Edson Joel','Moran','Calderon','2017-11-20'),
('47854139','Edinson','Yarleque','Vilchez','2017-11-20'),
('48632942','Miguel Alfredo','Cielo','Briceño','2017-11-20'),
('48644685','Veronica','Ramos','Berru','2017-11-20'),
('70038532','Pool','Palacios','Changano','2017-11-20'),
('70046216','Javier Arturo','Reto','Castillo','2017-11-20'),
('70087251','Percy Junior','Castillo','Carrion','2017-11-20'),
('70384817','Julio Cesar','Nima','Vasquez','2017-11-20'),
('71061812','Walter','Palacios','Rodriguez','2017-11-20'),
('71299351','Elvis','Mozombite','Zulueta','2017-11-20'),
('71997581','Anthony Christian','Silupu','Cochachi','2017-11-20'),
('73173592','Marco Antonio','Sandoval','Ordinola','2017-11-20'),
('73354201','Jose benjamin','Chong','Guerrero','2017-11-20'),
('75104119','Luis Kevin','Atoche','De la Cruz','2017-11-20'),
('75442583','Alexander','Navarro','Rojas','2017-11-15'),
('76942722','Josue Jhonatan','Otero','Querevalu','2017-11-20'),
('80662265','Jose David','Espinoza','Becerra','2017-11-20');

/*Table structure for table `puesto` */

DROP TABLE IF EXISTS `puesto`;

CREATE TABLE `puesto` (
  `ID` char(3) NOT NULL,
  `PUESTO` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `puesto` */

insert  into `puesto`(`ID`,`PUESTO`) values 
('201','GERENTE'),
('202','ADMINISTRADOR'),
('203','SUPERVISOR'),
('204','JEFE DE CUADRILLA'),
('205','TECNICO ELECTRICISTA'),
('206','TECNICO CHOFER'),
('207','AYUDANTE'),
('208','ENCARGADO');

/*Table structure for table `tipo_articulo` */

DROP TABLE IF EXISTS `tipo_articulo`;

CREATE TABLE `tipo_articulo` (
  `ID` char(4) NOT NULL,
  `TIPO` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_articulo` */

insert  into `tipo_articulo`(`ID`,`TIPO`) values 
('TA01','MATERIAL'),
('TA02','EPP'),
('TA03','OTROS');

/*Table structure for table `trabajador` */

DROP TABLE IF EXISTS `trabajador`;

CREATE TABLE `trabajador` (
  `CODIGO` char(4) NOT NULL,
  `DNI` char(8) NOT NULL,
  `IDPUESTO` char(3) NOT NULL,
  `IDAREA` char(3) NOT NULL,
  `CORREO` varchar(60) NOT NULL,
  PRIMARY KEY (`CODIGO`),
  KEY `DNI` (`DNI`),
  KEY `IDPUESTO` (`IDPUESTO`),
  KEY `IDAREA` (`IDAREA`),
  CONSTRAINT `trabajador_ibfk_2` FOREIGN KEY (`DNI`) REFERENCES `persona` (`DNI`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trabajador_ibfk_3` FOREIGN KEY (`IDPUESTO`) REFERENCES `puesto` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `trabajador` */

insert  into `trabajador`(`CODIGO`,`DNI`,`IDPUESTO`,`IDAREA`,`CORREO`) values 
('8001','44182117','208','107','Joshuaormachea1987@gmail.com'),
('8002','46642210','205','105','logisticaccmpp@gmail.com'),
('8003','2771617','203','108','logisticaccmpp@gmail.com'),
('8004','46543376','203','105','logisticaccmpp@gmail.com'),
('8005','75442583','205','101','logisticaccmpp@gmail.com'),
('8006','17537336','203','104','logisticaccmpp@gmail.com'),
('8007','3561817','204','104','vcorrea@procesosproductivos.com'),
('8008','42843559','204','105','lagurto@procesosproductivos.com'),
('8009','3879045','204','104','rsuarez@procesosproductivos.com '),
('8010','3651535','205','104','mvasquez@procesosproductivos.com'),
('8011','43262539','203','102','tcayetano@procesosproductivos.com'),
('8012','45380816','203','104','hmori@procesosproductivos.com'),
('8013','70046216','206','105','logisticaccmpp@gmail.com'),
('8014','41053324','203','101','jynoquio@procesosproductivos.com'),
('8015','46932616','205','101','logisticaccmpp@gmail.com'),
('8016','3569871','204','103','gnavarro@procesosproductivos.com'),
('8017','3679064','206','104','logisticaccmpp@gmail.com'),
('8018','44454276','205','102','logisticaccmpp@gmail.com'),
('8019','44444446','206','104','logisticaccmpp@gmail.com'),
('8020','45764210','206','101','jramos@procesosproductivos.com'),
('8021','40693789','206','103','logisticaccmpp@gmail.com'),
('8022','75104119','205','104','logisticaccmpp@gmail.com'),
('8023','41795541','204','103','logisticaccmpp@gmail.com'),
('8024','45748150','206','105','cramos@procesosproductivos.com'),
('8025','3669617','204','101','ecuray@procesosproductivos.com'),
('8026','43666076','202','109','elitano@procesosproductivos.com'),
('8027','43878294','207','102','logisticaccmpp@gmail.com'),
('8028','40302255','207','105','logisticaccmpp@gmail.com'),
('8029','47817460','205','102','ejmc383@gmail.com'),
('8030','03659044','206','101','logisticaccmpp@gmail.com'),
('8031','03632634','206','102','logisticaccmpp@gmail.com'),
('8032','03681144','204','102','ltorres@procesosproductivos.com'),
('8033','03621916','207','105','logisticaccmpp@gmail.com'),
('8034','03661740','206','104','logisticaccmpp@gmail.com'),
('8035','46248420','205','104','jarol19_13@hotmail.com'),
('8036','47255879','206','101','logisticaccmpp@gmail.com'),
('8037','73354201','207','101','jcsergen2016@gmail.com'),
('8038','44316318','205','103','logisticaccmpp@gmail.com'),
('8039','21881121','205','104','angel.almeyda@hotmail.com'),
('8040','71061812','206','105','logisticaccmpp@gmail.com'),
('8041','47854139','203','110','eyarleque@procesosproductivos.com'),
('8042','47468968','205','106','logisticaccmpp@gmail.com'),
('8043','46691311','207','105','logisticaccmpp@gmail.com'),
('8044','40088413','207','109','dcastillo@procesosproductivos.com'),
('8045','44633130','203','104','ycornejo@procesosproductivos.com'),
('8046','41511901','205','104','rtavararivera@gmail.com'),
('8047','02792991','206','104','logisticaccmpp@gmail.com'),
('8048','70087251','203','103','pcastillo@procesosproductivos.com'),
('8049','41715724','203','108','ddcastillo@procesosproductivos.com'),
('8050','48632942','207','105','logisticaccmpp@gmail.com'),
('8051','80662265','205','101','logisticaccmpp@gmail.com'),
('8052','76942722','207','102','logisticaccmpp@gmail.com'),
('8053','48644685','202','109','vramos@procesosproductivos.com'),
('8054','02642599','207','105','logisticaccmpp@gmail.com'),
('8055','44775997','204','104','logisticaccmpp@gmail.com'),
('8056','70384817','207','105','logisticaccmpp@gmail.com'),
('8057','45151584','203','104','ringa@procesosproductivos.com'),
('8058','41735712','203','104','jsantamaria@procesosproductivos.com'),
('8059','02709857','203','108','jchunga@procesosproductivos.com'),
('8060','40569500','205','102','logisticaccmpp@gmail.com'),
('8061','03234191','205','105','logisticaccmpp@gmail.com'),
('8062','73173592','205','102','logisticaccmpp@gmail.com'),
('8063','71299351','207','105','logisticaccmpp@gmail.com'),
('8064','43246013','203','103','jhuamanchumo@procesosproductivos.com'),
('8065','41600491','207','105','logisticaccmpp@gmail.com'),
('8066','70038532','205','101','logisticaccmpp@gmail.com'),
('8067','02840831','206','104','logisticaccmpp@gmail.com'),
('8068','44444444','204','105','jgalvez@procesosproductivos.com'),
('8069','16555947','203','104','eyaipen@procesosproductivos.com'),
('8070','03564460','206','104','logisticaccmpp@gmail.com'),
('8071','44444445','207','105','logisticaccmpp@gmail.com'),
('8072','44803053','203','105','eelera@procesosproductivos.com'),
('8073','71997581','205','102','logisticaccmpp@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
