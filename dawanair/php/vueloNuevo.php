<?php
include("conexion.php");

$salida =  $_POST["salidaD"]." ".$_POST["salidaT"];
$llegada = $_POST["llegadaD"]." ".$_POST["llegadaT"];
$vuelta = $_POST["fechaVuelta"]." ".$_POST["HoraVuelta"];
$org  = $_POST['origen'];
$dest = $_POST['destino'];
if ($_POST['hotel']!="1") {
  $hot=0;
}else {
  $hot=1;
}
//
// // $consult =  'SELECT _Id FROM `Ciudad` WHERE Nombre="'.$org.'"';
// // $consulta = mysqli_query($conexion,$consult);
// // while ($fila = mysqli_fetch_assoc($consulta)) {
// //   $org=$fila["_Id"];
// //   echo "string".$fila["_Id"];
// // }
// // $consult =  'SELECT _Id FROM `Ciudad` WHERE Nombre="'.$dest.'"';
// // $consulta = mysqli_query($conexion,$consult);
// // while ($fila = mysqli_fetch_assoc($consulta)) {
// //   $dest=$fila["_Id"];
// }
$sql = "INSERT INTO Vuelo (
   `Origen`,
   `Destino`,
    `Plazas_totales`,
    `Con_hoteol`,
    `Hotel`,
    `Clase`,
    `Fecha_salida`,
    `Fecha_llegada`,
    `Ida_y_vuelta`,
    `Compania`,
    `Precio`,
    `Fecha_regreso`,
     `Foto`,
     `Descripcion`,
     `Estrellas`) VALUES (
       ".$org.",
       ".$dest.",
       ".$_POST['plazas'].",
       ".$hot.",
       '".$_POST['hotelN']."',
       '".$_POST['clase']."',
       '".$salida."',
       '".$llegada."',
       '".$_POST['IdaYvuelta']."',
       '".$vuelta."',
       ".$_POST['precio'].",
       ".$_POST['estrellas'].",
       '".$_POST['imagen']."',
       '".$_POST['compania']."',
       '".$_POST['texto']."'
     );";
     // echo $sql;
     $consult =  'SELECT _Id FROM `Ciudad` WHERE Nombre="'.$dest.'"';
     if(mysqli_query($conexion,$sql)){
       echo "Ok";

     }else {
       echo "No";
     }






 ?>
