GET : https://www.ginperu.com/SlimAppEasy/apirest/index.php/usuariosApi

GET : https://www.ginperu.com/SlimAppEasy/apirest/index.php/usuariosApi/1

POST : https://www.ginperu.com/SlimAppEasy/apirest/index.php/usuariosApi

{
  "Usu_Usuario": "ddurand",
  "Usu_Contrasena": "123456",
  "Usu_ClaveApi": "123456",
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

PUT https://www.ginperu.com/SlimAppEasy/apirest/index.php/usuariosApi

{
  "Usu_Identificador": "1",
  "Usu_Usuario": "ddurand",
  "Usu_Contrasena": "123456",
  "Usu_ClaveApi": "123456",
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
