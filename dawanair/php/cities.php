<?php
include("conexion.php");
  if (isset($_GET["id"])) {
    $consult =  'SELECT _id,Nombre FROM Ciudad WHERE cod_pais='.$_GET["id"];
  }else {
    $consult =  'SELECT _id,Nombre FROM Ciudad ';
  }
  $consulta = mysqli_query($conexion,$consult);
  $arr = [];
  while ($fila = mysqli_fetch_assoc($consulta)) {
    $arr[]=$fila;
  }
  echo json_encode($arr);

mysqli_close($conexion);
 ?>
