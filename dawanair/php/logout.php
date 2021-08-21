<?php
session_start();
$_SESSION["name"] = "name";
$_SESSION = array();
session_destroy();
 ?>
