<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title> Plataforma Registro Usuarios </title>
	 <link rel="stylesheet" type="text/css" href="style/style.css">
 	<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js">
    </script>
    <script type="text/javascript" src="js/funcion.js"></script>
</head>
<body background="img/fondo.png">
	<div class="row">
		<div class="col s4 offset-s4">
			<div class="card-panel cyan lighten-5 padding">
				<div class="row">
					<div class="card-title col s12 center">
						<img src="img/user.png" alt="image" height="20%" width="20%">
						<h4> Registro Usuarios </h4>
					</div>
				</div>
				<form action= "" method='post' id="form_registro">
					<div class="row margin">
						<div class="input-field col s12">
							<i class="fa fa-user  fa-2x prefix"></i>
							<input placeholder="Nombres" id="nombres" type="text" class="validate" name="nombres">
							<label for="nombres">Nombres</label>
						</div>
					</div>
					<div class="row margin">
						<div class="input-field col s12">
							<i class="fa fa-envelope  fa-2x prefix"></i>
							<input placeholder="Correo" id="mail" type="email" class="validate" name="mail">
							<label for="mail"> Correo</label>
						</div>
					</div>
					<div class="row margin">
						<div class="input-field col s12">
							<i class="fa fa-user  fa-2x prefix"></i>
							<input placeholder="Usuario" id="user" type="text" class="validate" name="user">
							<label for="nombres"> Usuario </label>
						</div>
					</div>
					<div class="row margin">
						<div class="input-field col s12">
							<i class="fa fa-unlock-alt fa-2x prefix"></i>
							<input id="password" type="password" class="validate" name="password">
							<label for="name">Contraseña</label>
						</div>
					</div>

					<div class="col s12" align="center">
						<input class="btn btn-lg indigo" type="button" value="Registrar" onclick="registrar()">  &nbsp; &nbsp;
						<a class="btn btn-lg indigo" href="login.php"  > Regresar </a>
					</div>
					<br>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
