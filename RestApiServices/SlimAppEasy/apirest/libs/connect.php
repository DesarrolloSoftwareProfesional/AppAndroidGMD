<?php
 if (!defined("SPECIALCONSTANT")) die("Accedo Denegado");

 function getConnection( ){
 	try {
 		$db_username = "root";
 		$db_password = "";
 		$connection = new PDO("mysql:host=localhost;dbname=easyshopping",$db_username,$db_password);
 		$connection->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
 		return $connection;
 	} catch (Exception $e) {
 		echo "Error" . $e->getMessage();
 	}
}
?>