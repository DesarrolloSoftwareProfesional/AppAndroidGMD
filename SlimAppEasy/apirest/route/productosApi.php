<?php
 if (!defined("SPECIALCONSTANT")) die("Accedo Denegado");

$app->get("/productosApi/",function() use ($app)
{
    try {
        $connection = getConnection();
        $dbh = $connection->prepare("SELECT Prod_Identificador, SuCat_Identificador, Prod_Cantidad, Prod_Denominacion, Prod_Descripcion, Prod_Precio, Prod_EstadoRegistro FROM tbl_productos WHERE 1");


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
        $dbh = $connection->prepare(" SELECT Prod_Identificador, SuCat_Identificador, Prod_Cantidad, Prod_Denominacion, Prod_Descripcion, Prod_Precio, Prod_EstadoRegistro FROM tbl_productos WHERE Prod_Identificador=? ");
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

	$Prod_Identificador = $productosApi->Prod_Identificador;
    $SuCat_Identificador = $productosApi->SuCat_Identificador;
    $Prod_Cantidad = $productosApi->Prod_Cantidad;
    $Prod_Denominacion = $productosApi->Prod_Denominacion;
    $Prod_Descripcion = $productosApi->Prod_Descripcion;
	$Prod_Precio = $productosApi->Prod_Precio;	
	$Prod_EstadoRegistro = $productosApi->Prod_EstadoRegistro;	
    $accion = $productosApi->accion;
    try {
        $sql =""; 
        $connection = getConnection();
        if ($accion=="PUT") {
            $sql = " UPDATE tbl_productos SET SuCat_Identificador=?, Prod_Cantidad=?, Prod_Denominacion=?, Prod_Descripcion=?, Prod_Precio=?, Prod_EstadoRegistro=? WHERE Prod_Identificador=? ";
        }else if ($accion=="DELETE") {
            $sql = "DELETE FROM tbl_productos WHERE Prod_Identificador=? ";
        }else{
            $sql = "INSERT INTO tbl_productos ((SuCat_Identificador, Prod_Cantidad, Prod_Denominacion, Prod_Descripcion, Prod_Precio, Prod_EstadoRegistro)) VALUES(?,?,?,?,?,?)";
        }
        
        $dbh = $connection->prepare($sql);
        if ($accion=="DELETE") {
            $dbh->bindParam(1,$Usu_Identificador);           
        }else if ($accion=="PUT") {
            $dbh->bindParam(1,$SuCat_Identificador);
			$dbh->bindParam(2,$Prod_Cantidad);
			$dbh->bindParam(3,$Prod_Denominacion);
			$dbh->bindParam(4,$Prod_Descripcion);
			$dbh->bindParam(5,$Prod_Precio);
			$dbh->bindParam(6,$Prod_EstadoRegistro);
			$dbh->bindParam(7,$Prod_Identificador);
        }else {
            $dbh->bindParam(1,$SuCat_Identificador);
			$dbh->bindParam(2,$Prod_Cantidad);
			$dbh->bindParam(3,$Prod_Denominacion);
			$dbh->bindParam(4,$Prod_Descripcion);
			$dbh->bindParam(5,$Prod_Precio);
			$dbh->bindParam(6,$Prod_EstadoRegistro);			
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

$app->put("/productosApi/",function() use ($app)
{
    $request = $app->request();
    $productosApi = json_decode($request->getBody());

    $SuCat_Identificador = $productosApi->SuCat_Identificador;
    $Prod_Cantidad = $productosApi->Prod_Cantidad;
    $Prod_Denominacion = $productosApi->Prod_Denominacion;
    $Prod_Descripcion = $productosApi->Prod_Descripcion;
	$Prod_Precio = $productosApi->Prod_Precio;
	$Prod_EstadoRegistro = $productosApi->Prod_EstadoRegistro;
	$Prod_Identificador = $productosApi->Prod_Identificador;   
    try {

        $connection = getConnection();
        $dbh = $connection->prepare(" UPDATE tbl_productos SET SuCat_Identificador=?, Prod_Cantidad=?, Prod_Denominacion=?, Prod_Descripcion=?, Prod_Precio=?, Prod_EstadoRegistro=? WHERE Prod_Identificador=? ");
        $dbh->bindParam(1,$SuCat_Identificador);
        $dbh->bindParam(2,$Prod_Cantidad);
        $dbh->bindParam(3,$Prod_Denominacion);
        $dbh->bindParam(4,$Prod_Descripcion);
		$dbh->bindParam(5,$Prod_Precio);
		$dbh->bindParam(6,$Prod_EstadoRegistro);
		$dbh->bindParam(7,$Prod_Identificador);
        $dbh->execute();
        
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode(array("res" => 1)));
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
});

$app->delete("/productosApi/:id",function($id) use ($app)
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