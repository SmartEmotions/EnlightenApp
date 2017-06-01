<?php
	session_start();
	include 'conexion.php';

	$username= addslashes($_POST["username"]);
	$contrasena= addslashes($_POST["password"]);

	$sql = "SELECT * FROM users WHERE (user = '$username') and (passw = '".md5($contrasena)."')";
	$result = mysqli_query($conn, $sql);

 	$row = $result->fetch_array(MYSQLI_ASSOC);

		 if (md5($contrasena) == $row['passw'] ){

		    $_SESSION['autenticado'] = 'SI';
		    $_SESSION['usuario'] = $username;
		    $_SESSION['start'] = time();
		    $_SESSION['expire'] = $_SESSION['start'] + (5 * 60);

		    echo true;

		 } else {

		 	echo false;
		 }


	 mysqli_close($conn);

?>
