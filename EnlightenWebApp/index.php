<?php
    session_start();
    if(isset($_SESSION['autenticado']) && $_SESSION['autenticado'] == 'SI')
    {
        include("conexion.php");

?>
	<!DOCTYPE html>
	<html>
	<head>
		<title> Enlighten</title>
		<meta charset="utf-8">
    	<title>Login</title>
        <link rel="stylesheet" type="text/css" href="style/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/funcion.js"></script>
	</head>
	<body>
		<div class="slider">
		    <ul class="slides">
		    	<li>
		    		<img src="img/img34.png">
		    	</li>
		    	<li>
		    		<img src="img/img15.png">
		    	</li>
		    	<li>
		    		<img src="img/img40.png">
		    	</li>
		    	<li>
		    		<img src="img/img45.png">
		    	</li>
		    </ul>
		</div>

		<nav>
            <div class="nav-wrapper teal">
                <a  class="brand-logo right">
                    <i class="fa fa-user right"></i>
                    Usuario : <?= $_SESSION['usuario'] ?>
                </a>
                <ul id="nav-mobile" class="left hide-on-med-and-down">
                    <li>
                        <a href="./index.php" class="active">
                            <i class="fa fa-home fa-2x left"></i>
                            Inicio
                        </a>
                    </li>

                    <li>
                        <a onclick="agregar_Place();" class="active">
                            <i class="fa fa-street-view fa-2x left"></i>
                            Agregar Sitio
                        </a>
                    </li>

                    <li>
                        <a onclick="confirmar();">
                            <i class="fa fa-sign-out fa-2x left"></i>
                            Salir
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="row" id="contenedor">
            <div class="col s12">

                <table>
                <br>
                    <thead>
                        <tr>
                            <th> <div align="center"> <i class="fa fa-bank  fa-2x center" ></i> <br>
                            	Nombre </div></th>
                            <th> <div align="center"> <i class="fa fa-location-arrow fa-2x center" ></i>
                            	Latitud </div></th>
                            <th> <div align="center"> <i class="fa fa-diamond fa-2x center" ></i>
                            	Longitud </div></th>
                            <th> <div align="center"> <i class="fa fa-book fa-2x center" ></i>
                            	Descripción </div></th>
                            <th> <div align="center"> <i class="fa fa-cogs fa-2x center" ></i>
                            	Historia </div></th>
                            <th> <div align="center"> <i class="fa fa-group fa-2x center" ></i>
                            	Actividades </div></th>
                            <th> <div align="center"> <i class="fa fa-pencil fa-2x center" ></i>
                            	Editar </div> </th>
                            <th> <div align="center"> <i class="fa fa-trash fa-2x center" ></i>
                            	Eliminar </div></th>
                        </tr>
                    </thead>

                    <tbody>
                        <?php
                            $usuario = $_SESSION['usuario'];
                            $sql = "SELECT id_place, name_place, latitude_place, longitude_place ,user, description,history, activities
                                    FROM places JOIN details on id_place = place
                                    WHERE user = '$usuario'
                                    ORDER BY name_place";

                            $result =  mysqli_query($conn, $sql);
                            foreach($result as $row)
                            {
                                ?>
                                    <tr id='<?php echo $row["id_place"]; ?>'>
                                        <td><div align="center"> <?php echo $row["name_place"]; ?> </div></td>
                                        <td><div align="center"> <?php echo $row["latitude_place"]; ?> </div> </td>
                                        <td><div align="center"> <?php echo $row["longitude_place"]; ?> </div> </td>
                                        <td><div align="center"> <?php echo $row["description"]; ?> </div> </td>
                                        <td><div align="center"> <?php echo $row["history"]; ?> </div></td>
                                        <td><div align="center"> <?php echo $row["activities"]; ?> </div></td>

                                        <td>
                                            <div align="center">
                                                <a class="btn btn-lg green"
                                                type="button" name="action" id="btn_Update"
                                                onclick='updatePl(<?php echo $row["id_place"]?>);'>
                                                    <i class="fa fa-pencil left"></i>
                                                </a>
                                            </div>
                                        </td>
                                        <td>
                                            <div align="center">
                                            	<a class="btn btn-lg orange"
    											type="button" name="action" id="btn_Elim"
    											onclick='confirmDelete(<?php echo $row["id_place"]?>);'>
                                                <i class="fa fa-trash left"></i>
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                <?php
                            }
                        ?>
                    </tbody>
                </table>
       	    </div>
       	</div>
        <input type="hidden" name="place_delete" id="place_delete">
        <input type="hidden" name="place_edit" id="place_edit" >
        <div id="modal2" class="modal">
            <div class="modal-content" align="center">
                <img src="img/salir.png" width="10%" height="10%">
                <h4> Confirmación de Salida </h4>
                <p> ¿Esta seguro que desea salir ?</p>
            </div>
            <div class="modal-footer">
                <a onclick='salir();' class="modal-close waves-effect waves-green btn-flat">Si</a>
            </div>
        </div>


        <div id="modal3" class="modal">
            <div class="modal-content" align="center">
                <img src="img/delete.png" width="10%" height="10%">
                <h4> Confirmación de Eliminacion </h4>
                <p> ¿Esta seguro que desea eliminar el lugar ?</p>
            </div>
            <div class="modal-footer">
                <a onclick='deletePlace();' class="modal-close waves-effect waves-green btn-flat">Si</a>
            </div>
        </div>
        <div id="modal4" class="modal">
            <div class="modal-content" align="center" id="contenedorEdit">
            </div>
        </div>
        <div id="modal5" class="modal">
            <div class="modal-content" align="center">
                <h4> Su sesion ha caducado </h4>
                <p> Necesita Ingresar nuevamente </p>
            </div>
            <div class="modal-footer">
                <a href='login.php;' class="modal-close waves-effect waves-green btn-flat">Aceptar</a>
            </div>
        </div>
	</body>
	</html>
<?php
	}
	else
        {
		  require('login.php');
	}

?>
