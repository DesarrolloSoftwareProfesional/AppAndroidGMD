<?php
 if (!defined("SPECIALCONSTANT")) die("Accedo Denegado");

$app->get("/usuariosApi/",function() use ($app)
{
    try {
        $connection = getConnection();
        $dbh = $connection->prepare("SELECT Usu_Identificador, Usu_Usuario, Usu_Contrasena, Usu_ApePaterno, Usu_ApeMaterno, Usu_Nombres, Usu_CorreoElectronico, Usu_EstadoRegistro FROM tbl_usuarios WHERE 1");


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
        $dbh = $connection->prepare(" SELECT Usu_Identificador, Usu_Usuario, Usu_Contrasena, Usu_ApePaterno, Usu_ApeMaterno, Usu_Nombres, Usu_CorreoElectronico, Usu_EstadoRegistro FROM tbl_usuarios WHERE Usu_Identificador=? ");
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

	$Usu_Identificador = $usuariosApi->Usu_Identificador;
    $Usu_Usuario = $usuariosApi->Usu_Usuario;
    $Usu_Contrasena = $usuariosApi->Usu_Contrasena;
    $Usu_ApePaterno = $usuariosApi->Usu_ApePaterno;
    $Usu_ApeMaterno = $usuariosApi->Usu_ApeMaterno;
	$Usu_Nombres = $usuariosApi->Usu_Nombres;	
	$Usu_CorreoElectronico = $usuariosApi->Usu_CorreoElectronico;
	$Usu_EstadoRegistro = $usuariosApi->Usu_EstadoRegistro;
    $accion = $usuariosApi->accion;
    try {
        $sql =""; 
        $connection = getConnection();
        if ($accion=="PUT") {
            $sql = " UPDATE tbl_usuarios SET Usu_Usuario=?, Usu_Contrasena=?, Usu_ApePaterno=?, Usu_ApeMaterno=?, Usu_Nombres=?, Usu_CorreoElectronico=?, Usu_EstadoRegistro=? WHERE Usu_Identificador=? ";
        }else if ($accion=="DELETE") {
            $sql = "DELETE FROM tbl_usuarios WHERE Usu_Identificador=? ";
        }else{
            $sql = "INSERT INTO tbl_usuarios ((Usu_Usuario, Usu_Contrasena, Usu_ApePaterno, Usu_ApeMaterno, Usu_Nombres, Usu_CorreoElectronico, Usu_EstadoRegistro)) VALUES(?,?,?,?,?,?,?)";
        }
        
        $dbh = $connection->prepare($sql);
        if ($accion=="DELETE") {
            $dbh->bindParam(1,$Usu_Identificador);           
        }else if ($accion=="PUT") {
            $dbh->bindParam(1,$Usu_Usuario);
			$dbh->bindParam(2,$Usu_Contrasena);
			$dbh->bindParam(3,$Usu_ApePaterno);
			$dbh->bindParam(4,$Usu_ApeMaterno);
			$dbh->bindParam(5,$Usu_Nombres);
			$dbh->bindParam(6,$Usu_CorreoElectronico);
			$dbh->bindParam(7,$Usu_EstadoRegistro);
			$dbh->bindParam(8,$Usu_Identificador);
        }else {
            $dbh->bindParam(1,$Usu_Usuario);
			$dbh->bindParam(2,$Usu_Contrasena);
			$dbh->bindParam(3,$Usu_ApePaterno);
			$dbh->bindParam(4,$Usu_ApeMaterno);
			$dbh->bindParam(5,$Usu_Nombres);
			$dbh->bindParam(6,$Usu_CorreoElectronico);
			$dbh->bindParam(7,$Usu_EstadoRegistro);
        }	
        $dbh->execute();
        $locationId = $connection->lastInsertId();
        
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode($locationId));
    } catch (PDOException $e) {
        echo "Error:2 " . $e->getMessage();
    }
});

$app->put("/usuariosApi/",function() use ($app)
{
    $request = $app->request();
    $usuariosApi = json_decode($request->getBody());

    $Usu_Usuario = $usuariosApi->Usu_Usuario;
    $Usu_Contrasena = $usuariosApi->Usu_Contrasena;
    $Usu_ApePaterno = $usuariosApi->Usu_ApePaterno;
    $Usu_ApeMaterno = $usuariosApi->Usu_ApeMaterno;
	$Usu_Nombres = $usuariosApi->Usu_Nombres;
	$Usu_CorreoElectronico = $usuariosApi->Usu_CorreoElectronico;
	$Usu_EstadoRegistro = $usuariosApi->Usu_EstadoRegistro;
    $Usu_Identificador = $usuariosApi->Usu_Identificador;
    try {

        $connection = getConnection();
        $dbh = $connection->prepare(" UPDATE tbl_usuarios SET Usu_Usuario=?, Usu_Contrasena=?, Usu_ApePaterno=?, Usu_ApeMaterno=?, Usu_Nombres=?, Usu_CorreoElectronico=?, Usu_EstadoRegistro=? WHERE Usu_Identificador=? ");
        $dbh->bindParam(1,$Usu_Usuario);
        $dbh->bindParam(2,$Usu_Contrasena);
        $dbh->bindParam(3,$Usu_ApePaterno);
        $dbh->bindParam(4,$Usu_ApeMaterno);
		$dbh->bindParam(5,$Usu_Nombres);
		$dbh->bindParam(6,$Usu_CorreoElectronico);
		$dbh->bindParam(7,$Usu_EstadoRegistro);
        $dbh->execute();
        
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode(array("res" => 1)));
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
});

$app->delete("/usuariosApi/:id",function($id) use ($app)
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
?>