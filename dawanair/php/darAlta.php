<?php
  include("conexion.php");
$cod_google="";
  if (isset($_POST["Name"])) {
    $name = $_POST["Name"];
    $apellidos = $_POST["Surnames"];
    $email = $_POST["Email"];
    $movil = $_POST["Phone"];
    $sexo = $_POST["Sex"];
    $usuario = $_POST["User"];
    $contraseña = $_POST["Pass"];
    $cod_ciudad = $_POST["cod_ciudad"];
    $cod_google = $_POST["cod_google"];

    if ($cod_ciudad=="") {
      $cod_ciudad="NULL";
    }else {
      $cod_ciudad=  "'".$cod_ciudad."'";
    }

  $orden = 'INSERT INTO `Usuarios`(`Nombre`, `Apellidos`, `Email`, `Telefono`, `Sexo`, `Usuario`, `Contrasenia`,`_cod_ciudad`,`id_google`) VALUES
  ("'.$name.'","'.$apellidos.'","'.$email.'","'.$movil.'","'.$sexo.'","'.$usuario.'","'.$contraseña.'",'.$cod_ciudad.',"'.$cod_google.'")';



   if (mysqli_query($conexion,$orden)) {
     echo "Insertado";
   }elseif ($usuarios->num_rows == 0) {
     // echo "Error".mysqli_error($conexion);
     echo $orden;
   }


 }else {
   echo "error";
 }
  mysqli_close($conexion);





 ?>
