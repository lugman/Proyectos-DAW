<?php
include("conexion.php");

  $consult =  'SELECT Posicion FROM `Asientos` WHERE cod_vuelo='.$_GET["id"];

  $consulta = mysqli_query($conexion,$consult);
  $arr = [];
  while ($fila = mysqli_fetch_assoc($consulta)) {
    $arr[]=$fila["Posicion"];
  }
  echo json_encode($arr);

mysqli_close($conexion);
 ?>
