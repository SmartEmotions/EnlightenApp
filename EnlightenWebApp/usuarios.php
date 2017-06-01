<?php
include 'conexion.php';
	$contraseña = md5($_POST['password']);
	$sql = "INSERT INTO users (names,mail,user,passw)
	VALUES  ('".$_POST['nombres']."','".$_POST['mail']."','".$_POST['user']."', '".$contraseña."')";
	if (mysqli_query($conn, $sql))
	{
	    	echo 1;
	} else
	{
	       echo 0;
	}
	mysqli_close($conn);
?>
