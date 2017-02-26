SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE `tbl_usuarios` (
  `Usu_Identificador` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `Usu_Usuario` varchar(100) NOT NULL,
  `Usu_Contrasena` varchar(100) NOT NULL,
  `Usu_ApePaterno` varchar(100) NOT NULL,
  `Usu_ApeMaterno` varchar(100) NOT NULL,
  `Usu_Nombres` varchar(100) NOT NULL,
  `Usu_CorreoElectronico` varchar(100) NOT NULL,
  `Usu_EstadoRegistro` int(11) NOT NULL,  
  PRIMARY KEY (`Usu_Identificador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_categorias` (
  `Cate_Identificador` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `Cate_Denominacion` varchar(100) NOT NULL,
  `Cate_Descripcion` varchar(100) NOT NULL,
  `Cate_EstadoRegistro` int(11) NOT NULL,
  PRIMARY KEY (`Cate_Identificador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_subcategorias` (
  `SuCat_Identificador` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `Cate_Identificador` int(11) NOT NULL,
  `SuCat_Denominacion` varchar(100) NOT NULL,
  `SuCat_Descripcion` varchar(100) NOT NULL,
  `SuCat_EstadoRegistro` int(11) NOT NULL,
  PRIMARY KEY (`SuCat_Identificador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_productos` (
  `Prod_Identificador` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `SuCat_Identificador` int(11) NOT NULL,
  `Prod_Cantidad` int(11) NOT NULL,
  `Prod_Denominacion` varchar(100) NOT NULL,
  `Prod_Descripcion` varchar(100) NOT NULL,
  `Prod_Precio` double NOT NULL,
  `Prod_EstadoRegistro` int(11) NOT NULL,
  PRIMARY KEY (`Prod_Identificador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;