<?php

include("Slim/Slim.php");

\Slim\Slim::registerAutoloader();
$app = new \Slim\Slim();

define("SPECIALCONSTANT", TRUE);
header("Access-Control-Allow-Origin: *");
require 'libs/connect.php';
require 'route/usuariosApi.php';
require 'route/categoriasApi.php';
require 'route/subCategoriasApi.php';
require 'route/productosApi.php';

$app->get(
    '/',function() use ($app){    	
    	$datos = array(
    					"Empresa" => "GMD S.A.", 
    					"Aplicacion" => "EasyShopping"
    					);
        echo json_encode($datos);
    }
)->setParams(array($app));

$app->run();

