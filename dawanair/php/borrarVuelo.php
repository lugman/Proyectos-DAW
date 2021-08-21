<?php
include("conexion.php");
  $consult = 'DELETE FROM `Vuelo` WHERE _Id='.$_POST["id"];
  echo $consult;
    if(mysqli_query($conexion,$consult)){
      echo "Ok";
    }else {
      // echo mysqli_connect_error($con);
    }
 ?>
