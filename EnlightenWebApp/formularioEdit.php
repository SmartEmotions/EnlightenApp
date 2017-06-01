<?php
    session_start();
    if(isset($_SESSION['autenticado']) && $_SESSION['autenticado'] == 'SI')
    {
        include("conexion.php");
        $place = $_GET['lugar'];

        $sql = "SELECT * FROM PLACES JOIN DETAILS on id_place= place WHERE id_place ='$place'";
		$result = mysqli_query($conn,$sql);
		$row = mysqli_fetch_assoc($result);

        //$result = mysqli_query($conn,$sql);
		//$row = mysqli_fetch_assoc($result);
        
?>

<h2> EDICION DE REGISTRO </h2>
<form class="col s12" action="" method="POST" id="form_lugares" >
	<div  class="row"  id="formu">
		<div class="col s12" >
			<h1 > <?php echo $place ?> </h1>
			<input id="idPlace" name="idPlace" type="hidden" class="validate" value="<?php echo $row['id_place'] ?>">			 
			<div class="input-field col s12">
			    <i class="fa fa-bank  fa-2x prefix"></i>
			    <input id="nomPlace" name="nomPlace" type="text" class="validate" 
			    value="" >
			    <label for="nomPlace"> Nombre </label>
			</div>

			<div class="input-field col s6">
			    <i class="fa fa-location-arrow  fa-2x prefix"></i>
				<input type="number"  id= "latitude"  name="latitude" type="text" class="validate">
				<label for="latitude"> Latitud </label>
			</div>

			<div class="input-field col s6">
			    <i class="fa fa-diamond  fa-2x prefix"></i>
				<input type="number"  id= "longitude"  name="longitude" type="text" class="validate"> 
				<label for="longitude"> Longitud </label>
			</div>

			<div class="input-field col s12">
			    <i class="fa fa-book  fa-2x prefix"></i>
				<textarea id="textarea1" name="description" class="materialize-textarea" > </textarea><br>
				<label for="description"> Descripcion </label>
			</div>

			<div class="input-field col s12">
			    <i class="fa fa-cogs  fa-2x prefix"></i>
				<textarea id="textarea1" name="history" class="materialize-textarea"> </textarea><br>
				<label for="history"> Reseña Historica </label>
			</div>

			<div class="input-field col s12">
			    <i class="fa fa-group fa-2x prefix"></i>
				<textarea id="textarea1" name="activities" class="materialize-textarea"> </textarea><br>
				<label for="activities"> Actividades por realizar </label>
			</div>

			<div align="center" class="input-field col s12"> <br>

				<button class="btn waves-effect waves-light" id="enviar" type="button" name="" 
				onclick="updatePlace()"> Actualizar		
				</button> 
			</div> 

		</div>
	</div>
</form>

<?php
	}
	else{
		  require('login.php');
	}

?>