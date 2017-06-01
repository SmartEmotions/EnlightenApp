<?php
session_start();
if(isset($_SESSION['autenticado']) && $_SESSION['autenticado'] == 'SI')
{
    include("conexion.php");
    $place = $_POST['lugar'];
    $sql = "DELETE FROM details WHERE place = '$place'";
    if (mysqli_query($conn, $sql))
    {
	  $sql1 = "DELETE FROM places WHERE id_place = '$place'";
	    if (mysqli_query($conn, $sql1))
        {
		  echo 1;
		}
        else
        {
		  echo 0;
		}
	}
    else
    {
	  echo 0;
	}
	mysqli_close($conn);
}
?>
