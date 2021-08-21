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
// $sql = "INSERT INTO Vuelo (
//    `Origen`,
//    `Destino`,
//     `Plazas_totales`,
//     `Clase`,
//     `Fecha_salida`,
//     `Precio`,
//     `Estrellas`,
//     `Foto`,
//     `Descripcion`
//      ) VALUES (
//        ".$org.",
//        ".$dest.",
//        ".$_POST['plazas'].",
//        '".$_POST['clase']."',
//        '".$salida."',
//        ".$_POST['precio'].",
//        ".$_POST['estrellas'].",
//        '".$_POST['imagen']."',
//        '".$_POST['texto']."'
//      );";
     $consult =  'UPDATE `Vuelo` SET `Origen`='.$org.',`Destino`='.$dest.',
     `Plazas_totales`='.$_POST['plazas'].',`Clase`="'.$_POST['clase'].'"
     ,`Fecha_salida`="'.$salida.'",`Precio`='.$_POST['precio'].',`Foto`="'.$_POST['imagen'].'"
     ,`Descripcion`="'.$_POST['texto'].'",`Estrellas`="'.$_POST['estrellas'].'" WHERE _Id='.$_POST['id'].';';
     echo $consult;
     if(mysqli_query($conexion,$consult)){
       echo "Ok";

     }else {
       echo "No";
     }






 ?>
