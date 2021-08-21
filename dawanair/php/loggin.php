<?php
session_start();
  include("conexion.php");
  if ($_POST['Google']) {
    $id = $_POST['id'];
    $traerUsuario = 'SELECT _Id,Nombre,Apellidos,Telefono,Email,Sexo,Pais,Usuario,_cod_ciudad FROM `Usuarios` WHERE Email ="'.$id.'"';
    $traer = mysqli_query($conexion,$traerUsuario);

    if ($traer){
      if($traer->num_rows > 0 ){
        while ($a = mysqli_fetch_assoc($traer)) {
          $_SESSION['username'] = $a["Usuario"];
          $_SESSION['Name'] = $a["Nombre"];
          $_SESSION['_id'] = $a["_Id"];
          $_SESSION['login'] = true;
        }
        echo "True";
      }else {
       echo "No encontrado".$traerUsuario;
      }
    }elseif ($usuarios->num_rows == 0) {
      echo "001";
    }


  }
  // Fin Google
  if ($_POST['Email']) {
  $username = $_POST['username'];
  $password = $_POST['password'];
  if ($conexion->connect_error) {
   die('conexion');
  }

  $traerUsuario = 'SELECT _Id,Nombre,Apellidos,Telefono,Email,Sexo,Pais,Usuario,_cod_ciudad FROM `Usuarios` WHERE Usuario="'.$username.'" AND Contrasenia="'.$password.'"';

  $traer = mysqli_query($conexion,$traerUsuario);
  // print_r($traer);
   if ($traer){
     if($traer->num_rows > 0 ){
       $arr = [];
       while ($a = mysqli_fetch_array($traer)) {
         // Sessiones
         if ($a["Usuario"]==="Admin") {
           $_SESSION['Admin'] = true;
         }else{
           $_SESSION['Admin'] = false;
         }
         $_SESSION['username'] = $a["Usuario"];
         $_SESSION['Name'] = $a["Nombre"];
         $_SESSION['_id'] = $a["_Id"];

         $_SESSION['login'] = true;
        //  echo $_SESSION['username'] ,  $_SESSION['Name'] ,  $_SESSION['_id'], $_SESSION['login'];
       }
     }else {
      echo "No encontrado";
     }
   }elseif ($usuarios->num_rows == 0) {
     echo "001";
   }
 }
  mysqli_close($conexion);
  // $crearUsuario = 'INSERT INTO Usuarios (Nombre,Apellidos,Email,Telefono,_cod_ciudad,Sexo,Usuario,Contrasenia) VALUES ("Admin","" ,"" ,"" ,13 ,"" , "","" )';
 ?>
