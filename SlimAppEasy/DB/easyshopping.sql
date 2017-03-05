CREATE TABLE IF NOT EXISTS `tbl_usuarios` (
  `Usu_Identificador` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Usu_Usuario` varchar(100) NOT NULL,
  `Usu_Contrasena` varchar(100) NOT NULL,
  `Usu_ClaveApi` varchar(200) NOT NULL,
  `Usu_ApePaterno` varchar(100) NOT NULL,
  `Usu_ApeMaterno` varchar(100) NOT NULL,
  `Usu_Nombres` varchar(100) NOT NULL,
  `Usu_CorreoElectronico` varchar(100) NOT NULL,
  `Usu_Telefono` varchar(100) NULL,
  `Usu_UImagen` varchar(1000) NULL, 
  `Usu_EstadoRegistro` int(11) NOT NULL,   
  `Usu_UsuarioCreacion` varchar(100) NOT NULL,
  `Usu_FechaCreacion` datetime NOT NULL,
  `Usu_UsuarioActualizacion` varchar(100) NULL,
  `Usu_FechaActualizacion` datetime NULL,
  PRIMARY KEY (`Usu_Identificador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `tbl_categorias` (
  `Cate_Identificador` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Cate_Denominacion` varchar(100) NOT NULL,
  `Cate_Descripcion` varchar(100) NULL,
  `Cate_UImagen` varchar(1000) NULL, 
  `Cate_EstadoRegistro` int(11) NOT NULL,  
  `Cate_UsuarioCreacion` varchar(100) NOT NULL,
  `Cate_FechaCreacion` datetime NOT NULL,
  `Cate_UsuarioActualizacion` varchar(100) NULL,
  `Cate_FechaActualizacion` datetime NULL,
  PRIMARY KEY (`Cate_Identificador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `tbl_subcategorias` (
  `SuCat_Identificador` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Cate_Identificador` int(11) UNSIGNED NOT NULL,
  `SuCat_Denominacion` varchar(100) NOT NULL,
  `SuCat_Descripcion` varchar(100) NOT NULL,
  `SuCat_UImagen` varchar(1000) NOT NULL,
  `SuCat_EstadoRegistro` int(11) NOT NULL,  
  `SuCat_UsuarioCreacion` varchar(100) NOT NULL,
  `SuCat_FechaCreacion` datetime NOT NULL,
  `SuCat_UsuarioActualizacion` varchar(100) NULL,
  `SuCat_FechaActualizacion` datetime NULL,
  PRIMARY KEY (`SuCat_Identificador`),  
  FOREIGN KEY (`Cate_Identificador`) REFERENCES `tbl_categorias`(`Cate_Identificador`)  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `tbl_productos` (
  `Prod_Identificador` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `SuCat_Identificador` int(11) UNSIGNED NOT NULL,  
  `Prod_Denominacion` varchar(100) NOT NULL,
  `Prod_Descripcion` varchar(100) NULL,
  `Prod_Cantidad` int(11) NOT NULL,
  `Prod_Precio` double NOT NULL,
  `Prod_UImagen` varchar(1000) NULL,
  `Prod_EstadoRegistro` int(11) NOT NULL,  
  `Prod_UsuarioCreacion` varchar(100) NOT NULL,
  `Prod_FechaCreacion` datetime NOT NULL,
  `Prod_UsuarioActualizacion` varchar(100) NULL,
  `Prod_FechaActualizacion` datetime NULL,
  PRIMARY KEY (`Prod_Identificador`),  
  FOREIGN KEY (`SuCat_Identificador`) REFERENCES `tbl_subcategorias`(`SuCat_Identificador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;