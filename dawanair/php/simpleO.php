<?php
include("conexion.php");

  if(isset($_GET["cinco"])){
    $consult  =    'SELECT _Id,Destino,Precio,SUBSTRING(Descripcion, 1, 105) as Descripcion,Foto FROM Vuelo ORDER BY RAND() LIMIT 5';
  }
  else{
    $consult =  'SELECT _Id,Destino,Precio,SUBSTRING(Descripcion, 1, 105) as Descripcion,Foto FROM Vuelo ORDER BY Fecha_salida LIMIT 7';
  }
  $consulta = mysqli_query($conexion,$consult);
  $arr = [];

  class foo
  {
    public $id;
    public $destino;
    public $precio;
    public $descripcion;
    public $foto;

  }
  while ($fila = mysqli_fetch_assoc($consulta)) {
    $fo =  new foo();
    $fo -> id = $fila["_Id"];
    $fo -> descripcion = $fila["Descripcion"];
    $fo -> precio = $fila["Precio"];
    $fo -> foto = $fila["Foto"];
    $dest  =    'SELECT Nombre FROM `Ciudad` WHERE _Id='.$fila["Destino"];
    $consulta2 = mysqli_query($conexion,$dest);
    while ($fila2 = mysqli_fetch_assoc($consulta2)) {
    $fo -> destino = $fila2["Nombre"];
    }

    $arr[]=$fo;
  }
  echo json_encode($arr);

mysqli_close($conexion);
 ?>
