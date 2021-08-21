<?php
include("conexion.php");

  $consult =  'SELECT _id,Name FROM Pais WHERE _id IN (SELECT DISTINCT cod_pais FROM `Ciudad`)';
  $consulta = mysqli_query($conexion,$consult);
  $arr = [];
  while ($fila = mysqli_fetch_assoc($consulta)) {
    $arr[]=$fila;
  }
  echo json_encode($arr);

mysqli_close($conexion);
 ?>
