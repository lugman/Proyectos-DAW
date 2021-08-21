<?php
include("conexion.php");

session_start();
  $consult  =    'SELECT `_id`, `Posicion`, `cod_usuario`, `cod_vuelo`, `fecha`,`Precio` FROM `Asientos` WHERE cod_usuario='.$_SESSION["_id"].' ORDER BY fecha DESC';
  $consulta = mysqli_query($conexion,$consult);
  $arr = [];

  class foo
  {
    public $id_vuelo;
    public $posicion;
    public $fecha;
    public $precio;
    public $foto;
    public $nombre;

  }
  while ($fila = mysqli_fetch_assoc($consulta)) {
    $fo =  new foo();
    $fo -> id_vuelo = $fila["_id"];
    $fo -> fecha = $fila["fecha"];
    $fo -> posicion = $fila["Posicion"];
    $fo -> precio = $fila["Precio"];


    $dest  =    'SELECT Foto,Destino FROM `Vuelo` WHERE _Id='.$fila["cod_vuelo"];
    $consulta2 = mysqli_query($conexion,$dest);
    while ($fila2 = mysqli_fetch_assoc($consulta2)) {
      $fo -> foto = $fila2["Foto"];
      $fo -> nombre = $fila2["Destino"];

      $dest2  =    'SELECT Nombre FROM `Ciudad` WHERE _Id='.$fo -> nombre;
      $consulta3 = mysqli_query($conexion,$dest2);
      while ($fila3 = mysqli_fetch_assoc($consulta3)) {
        $fo -> nombre = $fila3["Nombre"];
      }

    }

    $arr[]=$fo;
  }
  echo json_encode($arr);

mysqli_close($conexion);
 ?>
