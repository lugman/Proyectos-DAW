<?php
  $conexion = mysqli_connect("localhost","lugman","molas121,","dawanair_lugman");
  mysqli_set_charset($conexion, "utf8");
  if (mysqli_connect_errno()){
    echo "Error al conectarse".mysqli_connect_error();
  }else {
    // Todo OK
  }

 ?>
