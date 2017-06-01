<?php
	$server = "fdb16.awardspace.net";
    $user = "2351808_universidad";
    $password = "CarlitosMC1158";
    $dataBase = "2351808_universidad";
    $port ="3306";
	$conn = mysqli_connect($server, $user, $password, $dataBase, $port);

	if (!$conn)
	{
	    die("Connection failed: " . mysqli_connect_error());
	}

?>
