<?php
 if (!defined("SPECIALCONSTANT")) die("Acceso Denegado");

$app->get("/usuariosApi/",function() use ($app)
{
    try {
        $connection = getConnection();
        $dbh = $connection->prepare(
		"SELECT Usu_Identificador
				,Usu_Usuario
				,Usu_Contrasena
				,Usu_ClaveApi
				,Usu_ApePaterno
				,Usu_ApeMaterno
				,Usu_Nombres
				,Usu_CorreoElectronico
				,Usu_Telefono
				,Usu_UImagen
				,Usu_EstadoRegistro
				,Usu_UsuarioCreacion
				,Usu_FechaCreacion
				,Usu_UsuarioActualizacion
				,Usu_FechaActualizacion
		FROM tbl_usuarios WHERE 1");
		
        $dbh->execute();
        $tbl_usuarios = $dbh->fetchAll(PDO::FETCH_ASSOC);;
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode($tbl_usuarios));
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
});

$app->get("/usuariosApi/:id",function($id) use ($app)
{
    try {
        $connection = getConnection();
        $dbh = $connection->prepare(" 
		SELECT  Usu_Identificador
				,Usu_Usuario
				,Usu_Contrasena
				,Usu_ClaveApi
				,Usu_ApePaterno
				,Usu_ApeMaterno
				,Usu_Nombres
				,Usu_CorreoElectronico
				,Usu_Telefono
				,Usu_UImagen
				,Usu_EstadoRegistro
				,Usu_UsuarioCreacion
				,Usu_FechaCreacion
				,Usu_UsuarioActualizacion
				,Usu_FechaActualizacion
		FROM tbl_usuarios WHERE Usu_Identificador=? ");
        $dbh->bindParam(1,$id);
        $dbh->execute();
        $book = $dbh->fetchObject();
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode($book));
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
});

$app->post("/usuariosApi/",function() use ($app)
{
    $request = $app->request();
    $usuariosApi = json_decode($request->getBody());
	
    $Usu_Usuario = $usuariosApi->Usu_Usuario;
    $Usu_Contrasena = $usuariosApi->Usu_Contrasena;
	$Usu_ClaveApi = $usuariosApi->Usu_ClaveApi;
    $Usu_ApePaterno = $usuariosApi->Usu_ApePaterno;
    $Usu_ApeMaterno = $usuariosApi->Usu_ApeMaterno;
	$Usu_Nombres = $usuariosApi->Usu_Nombres;	
	$Usu_CorreoElectronico = $usuariosApi->Usu_CorreoElectronico;
	$Usu_Telefono = $usuariosApi->Usu_Telefono;
	$Usu_UImagen = $usuariosApi->Usu_UImagen;
	$Usu_EstadoRegistro = $usuariosApi->Usu_EstadoRegistro;
	$Usu_UsuarioCreacion = $usuariosApi->Usu_UsuarioCreacion;
	$Usu_FechaCreacion = $usuariosApi->Usu_FechaCreacion;	
    
    try {
        $sql =""; 
        $connection = getConnection();
       
        $sql = "INSERT INTO tbl_usuarios 
			(	Usu_Usuario
				,Usu_Contrasena
				,Usu_ClaveApi
				,Usu_ApePaterno
				,Usu_ApeMaterno
				,Usu_Nombres
				,Usu_CorreoElectronico
				,Usu_Telefono
				,Usu_UImagen
				,Usu_EstadoRegistro
				,Usu_UsuarioCreacion
				,Usu_FechaCreacion
			 )
			 VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";        
        
        $dbh = $connection->prepare($sql);
       
        $dbh->bindParam(1,$Usu_Usuario);
		$dbh->bindParam(2,$Usu_Contrasena);
		$dbh->bindParam(3,$Usu_ClaveApi);
		$dbh->bindParam(4,$Usu_ApePaterno);
		$dbh->bindParam(5,$Usu_ApeMaterno);
		$dbh->bindParam(6,$Usu_Nombres);
		$dbh->bindParam(7,$Usu_CorreoElectronico);
		$dbh->bindParam(8,$Usu_Telefono);
		$dbh->bindParam(9,$Usu_UImagen);
		$dbh->bindParam(10,$Usu_EstadoRegistro);
		$dbh->bindParam(11,$Usu_UsuarioCreacion);
		$dbh->bindParam(12,$Usu_FechaCreacion);
        	
        $dbh->execute();
        $Usu_Identificador = $connection->lastInsertId();
        
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode($Usu_Identificador));
    } catch (PDOException $e) {
        echo "Error:2 " . $e->getMessage();
    }
});

$app->put("/usuariosApi/",function() use ($app)
{
    $request = $app->request();
    $usuariosApi = json_decode($request->getBody());
   
    $Usu_Identificador = $usuariosApi->Usu_Identificador;
    $Usu_Usuario = $usuariosApi->Usu_Usuario;
    $Usu_Contrasena = $usuariosApi->Usu_Contrasena;
	$Usu_ClaveApi = $usuariosApi->Usu_ClaveApi;
    $Usu_ApePaterno = $usuariosApi->Usu_ApePaterno;
    $Usu_ApeMaterno = $usuariosApi->Usu_ApeMaterno;
	$Usu_Nombres = $usuariosApi->Usu_Nombres;
	$Usu_CorreoElectronico = $usuariosApi->Usu_CorreoElectronico;
	$Usu_Telefono = $usuariosApi->Usu_Telefono;
	$Usu_UImagen = $usuariosApi->Usu_UImagen;
	$Usu_EstadoRegistro = $usuariosApi->Usu_EstadoRegistro;
	$Usu_UsuarioActualizacion = $usuariosApi->Usu_UsuarioActualizacion;
	$Usu_FechaActualizacion = $usuariosApi->Usu_FechaActualizacion;
   
    try {

        $connection = getConnection();
        $dbh = $connection->prepare
				(" UPDATE tbl_usuarios SET 
						Usu_Usuario=?
						,Usu_Contrasena=?
						,Usu_ClaveApi=?
						,Usu_ApePaterno=?
						,Usu_ApeMaterno=?
						,Usu_Nombres=?
						,Usu_CorreoElectronico=?
						,Usu_Telefono=?
						,Usu_UImagen=?
						,Usu_EstadoRegistro=?
						,Usu_UsuarioActualizacion=?
						,Usu_FechaActualizacion=?
				   WHERE Usu_Identificador=? 
				");
        $dbh->bindParam(1,$Usu_Usuario);
        $dbh->bindParam(2,$Usu_Contrasena);
		$dbh->bindParam(3,$Usu_ClaveApi);
        $dbh->bindParam(4,$Usu_ApePaterno);
        $dbh->bindParam(5,$Usu_ApeMaterno);
		$dbh->bindParam(6,$Usu_Nombres);
		$dbh->bindParam(7,$Usu_CorreoElectronico);
		$dbh->bindParam(8,$Usu_Telefono);
		$dbh->bindParam(9,$Usu_UImagen);
		$dbh->bindParam(10,$Usu_EstadoRegistro);
		$dbh->bindParam(11,$Usu_UsuarioActualizacion);
		$dbh->bindParam(12,$Usu_FechaActualizacion);
		$dbh->bindParam(13,$Usu_Identificador);
        $dbh->execute();
        
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode(array("res" => 1)));
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
});

$app->delete("/usuariosApi/", function() use ($app)
{
    $request = $app->request();
    $usuariosApi = json_decode($request->getBody());

    $Usu_Identificador = $usuariosApi->Usu_Identificador;
    try {
        $connection = getConnection();
        $dbh = $connection->prepare("DELETE FROM tbl_usuarios WHERE Usu_Identificador=?");
        $dbh->bindParam(1,$Usu_Identificador);        
        $dbh->execute();
        $connection=null;
        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode(array("res" => 1)));
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
});

$app->post("/login/",function() use ($app)
{
    $request = $app->request();
    $usuariosApi = json_decode($request->getBody());
	
    $Usu_Usuario = $usuariosApi->Usu_Usuario;
    $Usu_Contrasena = $usuariosApi->Usu_Contrasena;
    
    try {
        $sql =""; 
        $connection = getConnection();
       
        $sql = "
		SELECT  Usu_Identificador
				,Usu_Usuario
				,Usu_Contrasena
				,Usu_ClaveApi
				,Usu_ApePaterno
				,Usu_ApeMaterno
				,Usu_Nombres
				,Usu_CorreoElectronico
				,Usu_Telefono
				,Usu_UImagen
				,Usu_EstadoRegistro
				,Usu_UsuarioCreacion
				,Usu_FechaCreacion
				,Usu_UsuarioActualizacion
				,Usu_FechaActualizacion
		FROM tbl_usuarios WHERE Usu_Usuario=? AND Usu_Contrasena=? ";
        $dbh = $connection->prepare($sql);       
        $dbh->bindParam(1,$Usu_Usuario);
		$dbh->bindParam(2,$Usu_Contrasena);		
        $dbh->execute();
        $book = $dbh->fetchObject();
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode($book));
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
});

