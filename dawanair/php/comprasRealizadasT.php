<?php
include("conexion.php");

session_start();
  // $consult  =  'SELECT `_id`, `Posicion`, `cod_usuario`, `cod_vuelo`, `fecha`,`Precio` FROM `Vuelo`';
  $consult =  'SELECT _Id,Origen,Destino,Precio,Fecha_salida,Fecha_llegada,SUBSTRING(Descripcion, 1, 105) as Descripcion,Foto FROM Vuelo ORDER BY Fecha_salida ';
  $consulta = mysqli_query($conexion,$consult);
  $arr = [];

  class foo {
    public $id_vuelo;
    public $fecha1;
    public $fecha2;
    public $precio;
    public $foto;
    public $nombre;
  }
  while ($fila = mysqli_fetch_assoc($consulta)) {
    $fo =  new foo();
    $fo -> id = $fila["_Id"];
    $fo -> fecha1 = $fila["Fecha_salida"];
    $fo -> fecha2 = $fila["Fecha_llegada"];
    $fo -> precio = $fila["Precio"];
    $fo -> foto = $fila["Foto"];


    $dest  =    'SELECT Nombre FROM `Ciudad` WHERE _Id='.$fila["Origen"];
    $consulta2 = mysqli_query($conexion,$dest);
    while ($fila2 = mysqli_fetch_assoc($consulta2)) {
      $fo -> nombre .= $fila2["Nombre"];
    }
    $dest  =    'SELECT Nombre FROM `Ciudad` WHERE _Id='.$fila["Destino"];
    $consulta2 = mysqli_query($conexion,$dest);
    while ($fila2 = mysqli_fetch_assoc($consulta2)) {
      $fo -> nombre .=" ---> ".$fila2["Nombre"];
    }
      // $dest2  =    'SELECT Nombre FROM `Ciudad` WHERE _Id='.$fo -> nombre;
      // $consulta3 = mysqli_query($conexion,$dest2);
      // while ($fila3 = mysqli_fetch_assoc($consulta3)) {
      //   $fo -> nombre = $fila3["Nombre"];
      // }

    $arr[]=$fo;
  }
  echo json_encode($arr);
mysqli_close($conexion);
 ?>
