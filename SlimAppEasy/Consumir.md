-- SEGURIDAD --

GET : https://www.ginperu.com/SlimAppEasy/apirest/index.php/usuariosApi

GET : https://www.ginperu.com/SlimAppEasy/apirest/index.php/usuariosApi/1

POST : https://www.ginperu.com/SlimAppEasy/apirest/index.php/usuariosApi

{
  "Usu_Usuario": "ddurand",
  "Usu_Contrasena": "123456",
  "Usu_ClaveApi": "e10adc3949ba59abbe56e057f20f883e",
  "Usu_ApePaterno": "Durand",
  "Usu_ApeMaterno": "Morillo",
  "Usu_Nombres": "Darwin",
  "Usu_CorreoElectronico": "ddurand@ginperu.com",
  "Usu_Telefono": "930156439",
  "Usu_UImagen": null,
  "Usu_EstadoRegistro": "1",
  "Usu_UsuarioCreacion": "ddurand",
  "Usu_FechaCreacion": "2017-03-05 00:00:00"
}

PUT : https://www.ginperu.com/SlimAppEasy/apirest/index.php/usuariosApi

{
  "Usu_Identificador": "1",
  "Usu_Usuario": "ddurand",
  "Usu_Contrasena": "123456",
  "Usu_ClaveApi": "e10adc3949ba59abbe56e057f20f883e",
  "Usu_ApePaterno": "Durand",
  "Usu_ApeMaterno": "Morillo",
  "Usu_Nombres": "Darwin",
  "Usu_CorreoElectronico": "ddurand@ginperu.com",
  "Usu_Telefono": "930156439",
  "Usu_UImagen": null,
  "Usu_EstadoRegistro": "1",
  "Usu_UsuarioActualizacion": "ddurand",
  "Usu_FechaActualizacion": "2017-03-05 00:00:00"
}

DELETE : https://www.ginperu.com/SlimAppEasy/apirest/index.php/usuariosApi

{
  "Usu_Identificador": "2"
}

POST : https://www.ginperu.com/SlimAppEasy/apirest/index.php/login

{
  "Usu_Usuario": "ddurand",
  "Usu_Contrasena": "123456"
}

-- MANTENIMIENTOS - CRUD --

https://www.ginperu.com/SlimAppEasy/apirest/index.php/categoriasApi

https://www.ginperu.com/SlimAppEasy/apirest/index.php/subCategoriasApi

https://www.ginperu.com/SlimAppEasy/apirest/index.php/productosApi
