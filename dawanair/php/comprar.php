<?php
session_start();
include("conexion.php");
$vacio = 'SELECT * FROM `Asientos` WHERE Posicion="'.$_GET["pos"].'" AND cod_vuelo='.$_GET["vuelo"];
$traer = mysqli_query($conexion,$vacio);

 if ($traer){
   if($traer->num_rows > 0 ){
     echo "True";
   }else {
      $consult=  'INSERT INTO Asientos (Posicion,cod_usuario,cod_vuelo) VALUES ("'.$_GET["pos"].'",'.$_SESSION["_id"].','.$_GET["vuelo"].')';

     $consulta = mysqli_query($conexion,$consult);
        if($consulta){
          echo "Ok";
        }
   }
 }
mysqli_close($conexion);
//  ?>
