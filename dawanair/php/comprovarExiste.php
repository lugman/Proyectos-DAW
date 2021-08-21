<?php
  include("conexion.php");
  $username = $_GET['username'];

  if ($conexion->connect_error) {
   die('conexion');
  }

  $traerUsuario = 'SELECT Nombre FROM `Usuarios` WHERE Usuario="'.$username.'"';
  $traer = mysqli_query($conexion,$traerUsuario);
   if ($traer){

     if($traer->num_rows > 0 ){
       echo "True";
     }else {
      echo "False";
     }
   }else{
     echo "001";
   }
  mysqli_close($conexion);
  // $crearUsuario = 'INSERT INTO Usuarios (Nombre,Apellidos,Email,Telefono,_cod_ciudad,Sexo,Usuario,Contrasenia) VALUES ("Admin","" ,"" ,"" ,13 ,"" , "","" )';
 ?>
