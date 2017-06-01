<?php
session_start();
if(isset($_SESSION['autenticado']) && $_SESSION['autenticado'] == 'SI')
{
    include("conexion.php");
    $usuario = $_SESSION['usuario'];
	$sql = "INSERT INTO places (name_place, latitude_place, longitude_place, user)
	        VALUES ('".$_POST['nomPlace']."','".$_POST['latitude']."',
	        '".$_POST['longitude']."','$usuario')";

	if (mysqli_query($conn, $sql))
    {
		$sql1 = "INSERT INTO details (description, history, activities)
	        VALUES ('".$_POST['description']."','".$_POST['history']."',
	        '".$_POST['activities']."')";

	    if (mysqli_query($conn, $sql1))
        {
	    	echo 1;
	    } else
        {
	       echo 0;
		}
	}
    else
    {
	    echo 0;
	}
}
?>
