<?php
 if (!defined("SPECIALCONSTANT")) die("Acceso Denegado");

$app->get("/categoriasApi/",function() use ($app)
{
    try {
        $connection = getConnection();
        $dbh = $connection->prepare
			("	SELECT 
					Cate_Identificador, 
					Cate_Denominacion, 
					Cate_Descripcion, 
					Cate_UImagen,
					Cate_EstadoRegistro,
					Cate_UsuarioCreacion,
					Cate_FechaCreacion,
					Cate_UsuarioActualizacion,
					Cate_FechaActualizacion					
				FROM tbl_categorias WHERE 1"
			);

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

$app->get("/categoriasApi/:id",function($id) use ($app)
{
    try {
        $connection = getConnection();
        $dbh = $connection->prepare
			(" 
			SELECT 
				Cate_Identificador, 
				Cate_Denominacion, 
				Cate_Descripcion, 
				Cate_UImagen,
				Cate_EstadoRegistro,
				Cate_UsuarioCreacion,
				Cate_FechaCreacion,
				Cate_UsuarioActualizacion,
				Cate_FechaActualizacion	
			WHERE Cate_Identificador=? "
			);
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

$app->post("/categoriasApi/",function() use ($app)
{
    $request = $app->request();
    $categoriasApi = json_decode($request->getBody());
	
    $Cate_Denominacion = $categoriasApi->Cate_Denominacion;
    $Cate_Descripcion = $categoriasApi->Cate_Descripcion;
	$Cate_UImagen = $categoriasApi->Cate_UImagen;
    $Cate_EstadoRegistro = $categoriasApi->Cate_EstadoRegistro;    
	$Cate_UsuarioCreacion = $categoriasApi->Cate_UsuarioCreacion;
	$Cate_FechaCreacion = $categoriasApi->Cate_FechaCreacion;
    try {
        $sql =""; 
        $connection = getConnection();        
        $sql = "INSERT INTO tbl_categorias 
			( 	Cate_Denominacion, 
				Cate_Descripcion,
				Cate_UImagen,
				Cate_EstadoRegistro,
				Cate_UsuarioCreacion,
				Cate_FechaCreacion						
			) VALUES(?,?,?,?,?,?)";
                
        $dbh = $connection->prepare($sql);
        
        $dbh->bindParam(1,$Cate_Denominacion);
		$dbh->bindParam(2,$Cate_Descripcion);
		$dbh->bindParam(3,$Cate_UImagen);
		$dbh->bindParam(4,$Cate_EstadoRegistro);
		$dbh->bindParam(5,$Cate_UsuarioCreacion);	
		$dbh->bindParam(6,$Cate_FechaCreacion);			
        	
        $dbh->execute();
        $Cate_Identificador = $connection->lastInsertId();
        
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode($Cate_Identificador));
    } catch (PDOException $e) {
        echo "Error:2 " . $e->getMessage();
    }
});

$app->put("/categoriasApi/",function() use ($app)
{
    $request = $app->request();
    $categoriasApi = json_decode($request->getBody());

	$Cate_Identificador = $categoriasApi->Cate_Identificador;
    $Cate_Denominacion = $categoriasApi->Cate_Denominacion;
    $Cate_Descripcion = $categoriasApi->Cate_Descripcion;
	$Cate_UImagen = $categoriasApi->Cate_UImagen;
    $Cate_EstadoRegistro = $categoriasApi->Cate_EstadoRegistro;
	$Cate_UsuarioActualizacion = $categoriasApi->Cate_UsuarioActualizacion;
	$Cate_FechaActualizacion = $categoriasApi->Cate_FechaActualizacion;
    	
    try {

        $connection = getConnection();
        $dbh = $connection->prepare
				(" 
					UPDATE tbl_categorias SET
						Cate_Denominacion=?, 
						Cate_Descripcion=?, 
						Cate_UImagen=?, 
						Cate_EstadoRegistro=?,
						Cate_UsuarioActualizacion=?,
						Cate_FechaActualizacion=?
					WHERE Cate_Identificador=? 
				");				
        $dbh->bindParam(1,$Cate_Denominacion);
        $dbh->bindParam(2,$Cate_Descripcion);
		$dbh->bindParam(3,$Cate_UImagen);
        $dbh->bindParam(4,$Cate_EstadoRegistro);
		$dbh->bindParam(5,$Cate_UsuarioActualizacion);
		$dbh->bindParam(6,$Cate_FechaActualizacion);
		$dbh->bindParam(7,$Cate_Identificador);  		
        $dbh->execute();
        
        $connection=null;

        $app->response->headers->set("Content-type","application/json");
        $app->response->status(200);
        $app->response->body(json_encode(array("res" => 1)));
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
});

$app->delete("/categoriasApi/", function() use ($app)
{
    $request = $app->request();
    $categoriasApi = json_decode($request->getBody());

    $Cate_Identificador = $categoriasApi->Cate_Identificador;
    try {
        $connection = getConnection();
        $dbh = $connection->prepare("DELETE FROM tbl_categorias WHERE Cate_Identificador=?");
        $dbh->bindParam(1,$Cate_Identificador);        
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