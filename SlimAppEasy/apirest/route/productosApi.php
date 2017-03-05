<?php
 if (!defined("SPECIALCONSTANT")) die("Acceso Denegado");

$app->get("/productosApi/",function() use ($app)
{
    try {
        $connection = getConnection();
        $dbh = $connection->prepare
				("
					SELECT 
						Prod_Identificador, 
						SuCat_Identificador,						
						Prod_Denominacion,
						Prod_Descripcion,
						Prod_Cantidad,
						Prod_Precio,
						Prod_UImagen,
						Prod_EstadoRegistro,
						Prod_UsuarioCreacion,
						Prod_FechaCreacion,
						Prod_UsuarioActualizacion,
						Prod_FechaActualizacion
					FROM tbl_productos WHERE 1
				");
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

$app->get("/productosApi/:id",function($id) use ($app)
{
    try {
        $connection = getConnection();
        $dbh = $connection->prepare
				(" 
					SELECT 
						Prod_Identificador, 
						SuCat_Identificador,						
						Prod_Denominacion,
						Prod_Descripcion,
						Prod_Cantidad,
						Prod_Precio,
						Prod_UImagen,
						Prod_EstadoRegistro,
						Prod_UsuarioCreacion,
						Prod_FechaCreacion,
						Prod_UsuarioActualizacion,
						Prod_FechaActualizacion
					FROM tbl_productos 
					WHERE Prod_Identificador=? 
				");
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

$app->post("/productosApi/",function() use ($app)
{
    $request = $app->request();
    $productosApi = json_decode($request->getBody());

    $SuCat_Identificador = $productosApi->SuCat_Identificador;
    $Prod_Denominacion = $productosApi->Prod_Denominacion;
    $Prod_Descripcion = $productosApi->Prod_Descripcion;
    $Prod_Cantidad = $productosApi->Prod_Cantidad;
	$Prod_Precio = $productosApi->Prod_Precio;	
	$Prod_UImagen = $productosApi->Prod_UImagen;	
    $Prod_EstadoRegistro = $productosApi->Prod_EstadoRegistro;
	$Prod_UsuarioCreacion = $productosApi->Prod_UsuarioCreacion;
	$Prod_FechaCreacion = $productosApi->Prod_FechaCreacion;
    try {
        $sql =""; 
        $connection = getConnection();
       
        $sql = "INSERT INTO tbl_productos 
			(
				SuCat_Identificador, 
				Prod_Denominacion, 
				Prod_Descripcion, 
				Prod_Cantidad, 
				Prod_Precio, 
				Prod_UImagen,
				Prod_EstadoRegistro,
				Prod_UsuarioCreacion,
				Prod_FechaCreacion				
			) VALUES(?,?,?,?,?,?,?,?,?)";
                
        $dbh = $connection->prepare($sql);
        
        $dbh->bindParam(1,$SuCat_Identificador);
		$dbh->bindParam(2,$Prod_Denominacion);
		$dbh->bindParam(3,$Prod_Descripcion);
		$dbh->bindParam(4,$Prod_Cantidad);
		$dbh->bindParam(5,$Prod_Precio);
		$dbh->bindParam(6,$Prod_UImagen);
		$dbh->bindParam(7,$Prod_EstadoRegistro);			
        $dbh->bindParam(8,$Prod_UsuarioCreacion);
		$dbh->bindParam(9,$Prod_FechaCreacion);
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

$app->put("/productosApi/",function() use ($app)
{
    $request = $app->request();
    $productosApi = json_decode($request->getBody());

	$Prod_Identificador = $productosApi->Prod_Identificador;
    $SuCat_Identificador = $productosApi->SuCat_Identificador;
    $Prod_Denominacion = $productosApi->Prod_Denominacion;
    $Prod_Descripcion = $productosApi->Prod_Descripcion;
    $Prod_Cantidad = $productosApi->Prod_Cantidad;
	$Prod_Precio = $productosApi->Prod_Precio;
	$Prod_UImagen = $productosApi->Prod_UImagen;
	$Prod_EstadoRegistro = $productosApi->Prod_EstadoRegistro;
	$Prod_UsuarioActualizacion = $productosApi->Prod_UsuarioActualizacion;
	$Prod_FechaActualizacion = $productosApi->Prod_FechaActualizacion;
	   
    try {

        $connection = getConnection();
        $dbh = $connection->prepare
			(" 
				UPDATE 	tbl_productos SET 
						SuCat_Identificador=?, 
						Prod_Denominacion=?, 
						Prod_Descripcion=?, 
						Prod_Cantidad=?, 
						Prod_Precio=?,
						Prod_UImagen=?, 
						Prod_EstadoRegistro=?,
						Prod_UsuarioActualizacion=?,
						Prod_FechaActualizacion=? 
				WHERE Prod_Identificador=? 
			");
        $dbh->bindParam(1,$SuCat_Identificador);
        $dbh->bindParam(2,$Prod_Denominacion);
        $dbh->bindParam(3,$Prod_Descripcion);
        $dbh->bindParam(4,$Prod_Cantidad);
		$dbh->bindParam(5,$Prod_Precio);
		$dbh->bindParam(6,$Prod_UImagen);
		$dbh->bindParam(7,$Prod_EstadoRegistro);
		$dbh->bindParam(8,$Prod_UsuarioActualizacion);
		$dbh->bindParam(9,$Prod_FechaActualizacion);
		$dbh->bindParam(10,$Prod_Identificador);
        $dbh->execute();
        
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode(array("res" => 1)));
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
});

$app->delete("/productosApi/", function() use ($app)
{
    $request = $app->request();
    $productosApi = json_decode($request->getBody());

    $Prod_Identificador = $productosApi->Prod_Identificador;
    try {
        $connection = getConnection();
        $dbh = $connection->prepare("DELETE FROM tbl_productos WHERE Prod_Identificador=?");
        $dbh->bindParam(1,$Prod_Identificador);        
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