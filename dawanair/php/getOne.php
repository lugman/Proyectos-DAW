<?php
include("conexion.php");
$id = $_GET["id"];
$consult =  'SELECT * FROM Vuelo WHERE _Id = '.$id;
$consulta = mysqli_query($conexion,$consult);


  //
  // print_r($consulta);
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
    public $Descripcion;

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
    $fo -> Descripcion = $fila["Descripcion"];
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
    echo json_encode($fo);
  }
mysqli_close($conexion);
?>
