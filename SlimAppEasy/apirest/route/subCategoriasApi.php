<?php
 if (!defined("SPECIALCONSTANT")) die("Accedo Denegado");

$app->get("/subCategoriasApi/",function() use ($app)
{
    try {
        $connection = getConnection();
        $dbh = $connection->prepare("
				SELECT 
					SuCat_Identificador, 
					Cate_Identificador, 
					SuCat_Denominacion, 
					SuCat_Descripcion, 
					SuCat_EstadoRegistro 
				FROM tbl_subcategorias WHERE 1");
        $dbh->execute();
        $tbl_subcategorias = $dbh->fetchAll(PDO::FETCH_ASSOC);;
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode($tbl_subcategorias));
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
});

$app->get("/subCategoriasApi/:id",function($id) use ($app)
{
    try {
        $connection = getConnection();
        $dbh = $connection->prepare(" 
							SELECT 
								SuCat_Identificador, 
								Cate_Identificador, 
								SuCat_Denominacion, 
								SuCat_Descripcion, 
								SuCat_EstadoRegistro 
							FROM tbl_subcategorias 
							WHERE SuCat_Identificador=? ");
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

$app->post("/subCategoriasApi/",function() use ($app)
{
    $request = $app->request();
    $subCategoriasApi = json_decode($request->getBody());

	$SuCat_Identificador = $subCategoriasApi->SuCat_Identificador;
    $Cate_Identificador = $subCategoriasApi->Cate_Identificador;
    $SuCat_Denominacion = $subCategoriasApi->SuCat_Denominacion;
    $SuCat_Descripcion = $subCategoriasApi->SuCat_Descripcion;
    $SuCat_EstadoRegistro = $subCategoriasApi->SuCat_EstadoRegistro;	
    $accion = $subCategoriasApi->accion;
    try {
        $sql =""; 
        $connection = getConnection();
        if ($accion=="PUT") {
            $sql = " UPDATE tbl_subcategorias SET 
						Cate_Identificador=?, 
						SuCat_Denominacion=?, 
						SuCat_Descripcion=?, 
						SuCat_EstadoRegistro=? 
					WHERE SuCat_Identificador=? ";
        }else if ($accion=="DELETE") {
            $sql = "DELETE FROM tbl_subcategorias WHERE SuCat_Identificador=? ";
        }else{
            $sql = "INSERT INTO tbl_subcategorias 
						(
							Cate_Identificador, 
							SuCat_Denominacion, 
							SuCat_Descripcion, 
							SuCat_EstadoRegistro
						) 
							VALUES(?,?,?,?)";
        }
        
        $dbh = $connection->prepare($sql);
        if ($accion=="DELETE") {
            $dbh->bindParam(1,$SuCat_Identificador);           
        }else if ($accion=="PUT") {
            $dbh->bindParam(1,$Cate_Identificador);
			$dbh->bindParam(2,$SuCat_Denominacion);
			$dbh->bindParam(3,$SuCat_Descripcion);
			$dbh->bindParam(4,$SuCat_EstadoRegistro);
			$dbh->bindParam(5,$SuCat_Identificador);			
        }else {
            $dbh->bindParam(1,$Cate_Identificador);
			$dbh->bindParam(2,$SuCat_Denominacion);
			$dbh->bindParam(3,$SuCat_Descripcion);
			$dbh->bindParam(4,$SuCat_EstadoRegistro);			
        }	
        $dbh->execute();
        $SuCat_Identificador = $connection->lastInsertId();
        
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode($SuCat_Identificador));
    } catch (PDOException $e) {
        echo "Error:2 " . $e->getMessage();
    }
});

$app->put("/subCategoriasApi/",function() use ($app)
{
    $request = $app->request();
    $subCategoriasApi = json_decode($request->getBody());
	
	$Cate_Identificador = $subCategoriasApi->Cate_Identificador;
    $SuCat_Denominacion = $subCategoriasApi->SuCat_Denominacion;
    $SuCat_Descripcion = $subCategoriasApi->SuCat_Descripcion;
    $SuCat_EstadoRegistro = $subCategoriasApi->SuCat_EstadoRegistro;
	$SuCat_Identificador = $subCategoriasApi->SuCat_Identificador;		
    try {

        $connection = getConnection();
        $dbh = $connection->prepare(" 
							UPDATE tbl_subcategorias 
								SET Cate_Identificador=?, 
								SuCat_Denominacion=?, 
								SuCat_Descripcion=?, 
								SuCat_EstadoRegistro=? 
							WHERE SuCat_Identificador=? ");
        $dbh->bindParam(1,$Cate_Identificador);
        $dbh->bindParam(2,$SuCat_Denominacion);
        $dbh->bindParam(3,$SuCat_Descripcion);
        $dbh->bindParam(4,$SuCat_EstadoRegistro);
		$dbh->bindParam(5,$SuCat_Identificador);		
        $dbh->execute();
        
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode(array("res" => 1)));
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
});

$app->delete("/subCategoriasApi/", function() use ($app)
{
    $request = $app->request();
    $subCategoriasApi = json_decode($request->getBody());

    $SuCat_Identificador = $subCategoriasApi->SuCat_Identificador;
    try {
        $connection = getConnection();
        $dbh = $connection->prepare("DELETE FROM tbl_subcategorias WHERE SuCat_Identificador=?");
        $dbh->bindParam(1,$SuCat_Identificador);        
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
