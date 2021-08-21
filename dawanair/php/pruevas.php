<?php
$idaYvuelta = $_GET["idaYvuelta"];
$origen = $_GET["origen"];
$destino = $_GET["destino"];
$fecha1 = $_GET["fecha1"];
$fecha2 = $_GET["fecha2"];
$NumP = $_GET["NumP"];
if ($fecha1=="") {

  $fecha1=Date("Y/m/d",time());
}
if ($fecha2=="") {
  $fecha2="";
}else{
  $fecha2= ' AND Fecha_llegada <='.$fecha2;
}
if ($idaYvuelta=="") {}else{
  $idaYvuelta= ' AND Ida_y_vuelta='.$idaYvuelta;
}
if ($origen=="") {}else {
  $origen ='AND Origen='.$origen;
}
if ($destino=="") {}else {
  $destino =' AND Destino = '.$destino;
}
  $consult =  'SELECT _Id,Destino,Fecha_salida,Fecha_llegada,Ida_y_vuelta,Precio,Clase,Plazas_totales,Estrellas FROM Vuelo
WHERE Fecha_salida >= '.$fecha1.$fecha2.$idaYvuelta.' AND
Plazas_totales >= '.$NumP.$origen.$destino;
 echo $consult;
 ?>
