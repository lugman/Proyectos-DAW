<?php
include("conexion.php");
$idaYvuelta = $_GET["idaYvuelta"];
$ida = $_GET["ida"];
$origen = $_GET["origen"];
$destino = $_GET["destino"];
$fecha1 = $_GET["fecha1"];
$fecha2 = $_GET["fecha2"];
$NumP = $_GET["NumP"];
if ($NumP=="") {
  $NumP=1;
}
if ($fecha1=="") {
  $fecha1="'".Date("Y/m/d",time())."'";
}else {
  $fecha1= '"'.$fecha1.'"';
}
if ($fecha2=="") {
  $fecha2="";
}else {
  $fecha2= ' AND Fecha_llegada <="'.$fecha2.' 24:00:00"';
}
if ($idaYvuelta=="" || $idaYvuelta=="false") {
  $idaYvuelta="";
  if ($ida=="" || $ida=="false") {
    $idaYvuelta="";
  }else {
    $idaYvuelta= ' AND Ida_y_vuelta=0';
  }
}else{
  if ($ida=="" || $ida=="false") {
    $idaYvuelta= ' AND Ida_y_vuelta='.$idaYvuelta;
  }else {
    $idaYvuelta= '';
  }
}
if ($origen=="") {}else {
  $sql = 'SELECT _Id FROM Ciudad WHERE Nombre="'.$origen.'"';
  $consultaO = mysqli_query($conexion,$sql);
  while ($fila3 = mysqli_fetch_assoc($consultaO)) {
    $origen  = $fila3["_Id"];
    }
  $origen =' AND origen = '.$origen;
}
if ($destino=="") {}else {
  $sql2 = 'SELECT _Id FROM Ciudad WHERE Nombre="'.$destino.'"';
  $consultaD = mysqli_query($conexion,$sql2);
  while ($fila3 = mysqli_fetch_assoc($consultaD)) {
    $destino  = $fila3["_Id"];
    }
  $destino =' AND Destino = '.$destino;
}

  $consult =  'SELECT _Id,Origen,Destino,Fecha_salida,Fecha_llegada,Ida_y_vuelta,Precio,Clase,Plazas_totales,Estrellas,Foto,Compania FROM Vuelo
WHERE Fecha_salida >= '.$fecha1.$fecha2.$idaYvuelta.' AND
Plazas_totales >= '.$NumP.$origen.$destino;

  $consulta = mysqli_query($conexion,$consult);
  // echo $consult;
  $arr = [];

  class foo
  {
    public $id;
    public $destino;
    public $cod_destino;
    public $cod_origen;
    public $origen;
    public $precio;
    public $fecha1;
    public $fecha2;
    public $idaYvuelta;
    public $clase;
    public $plazas;
    public $estrellas;
    public $compa;

  }
  while ($fila = mysqli_fetch_assoc($consulta)) {
    $fo =  new foo();
    $fo -> id = $fila["_Id"];
    $fo -> precio = $fila["Precio"];
    $fo -> foto = $fila["Foto"];
    $fo -> fecha1 = $fila["Fecha_salida"];
    $fo -> fecha2 = $fila["Fecha_llegada"];
    $fo -> idaYvuelta = $fila["Ida_y_vuelta"];
    $fo -> clase = $fila["Clase"];
    $fo -> plazas = $fila["Plazas_totales"];
    $fo -> estrellas = $fila["Estrellas"];
    $fo -> compa = $fila["Compania"];

    $fo -> cod_destino = $fila["Destino"];
    $fo -> cod_origen = $fila["Origen"];
    $org  = 'SELECT Nombre FROM `Ciudad` WHERE _Id='.$fila["Origen"];
    $consulta3 = mysqli_query($conexion,$org);
    while ($fila3 = mysqli_fetch_assoc($consulta3)) {
      $fo -> origen = $fila3["Nombre"];
      }
    $dest  = 'SELECT Nombre FROM `Ciudad` WHERE _Id='.$fila["Destino"];
    $consulta2 = mysqli_query($conexion,$dest);
    while ($fila2 = mysqli_fetch_assoc($consulta2)) {
    $fo -> destino = $fila2["Nombre"];
    }

    $arr[]=$fo;
  }
  echo json_encode($arr);



mysqli_close($conexion);
?>
