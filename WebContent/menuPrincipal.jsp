<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Menu Principal</title>
</head>
<body>

	<div class="text-center p-5">
		<h2 class="fw-bold p-4"><i class="fas fa-bars"></i> Menu de Ociones</h2>
		<nav>
			 
 
			<br>
			<ul>
				<li ><a class="navbar-brand btn btn-dark" href="registrarInforme.jsp"
					class="btn btn-dark"><i class="far fa-save"></i> Registrar Informe</a>
				</li>
 <br>
 
				<li><a href="ServletInforme?tipo=listar"
					class="navbar-brand btn btn-dark"><i class="fas fa-search"></i> Consultar Informe</a></li>
  <br>
				<li ><a class="navbar-brand btn btn-dark" href="ServletUsuario?tipo=cerrarSesion">
					<i class="fas fa-sign-out"></i> Cerrar Sesión</a></li> 
			</ul>
		</nav>
	</div>
</body>
<script src="https://kit.fontawesome.com/f16b543c6e.js" crossorigin="anonymous"></script>

</html>