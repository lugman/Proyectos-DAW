<?php
session_start();
if (isset($_SESSION['login'])) {
    if (isset($_SESSION['Admin'])) {
      if ($_SESSION['Admin']==true) {
        echo  "trueAdmin";
      }else {
        echo "true";
        
      }
    }else {
      echo "true";
    }
  }else {
    echo "false";
}
 ?>
