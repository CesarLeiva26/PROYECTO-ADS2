<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<div class="d-flex text-center p-5">
		<div>
			<h3 class="fw-bold  ">Login Usuario</h3>
			<br> <img class="imagen" src="img/logeo.jpg">
		</div>
		<div class="fw-bold">
			<div id="contador"></div>
			<br>
			<form action="ServletUsuario?tipo=iniciarSesion" name="frmsesion"
				method="post">
				<br>
				<br>
				<div class="p-3"></div>
				<div class="form-group d-flex">
					<label class="w-100 fw-bold d-flex">USUARIO</label> <input
						class="w-100 fw-bold" id="txtusuario" type="email"
						name="txtusuario" placeholder="Ingresar Usuario">
				</div>
				<br>
				<br>
				<br>
				<div class="form-group d-flex">
					<label class="w-100 fw-bold d-flex">CONTRASEÑA</label> <input
						class="w-100 fw-bold" id="txtcontra" type="password"
						name="txtcontra" placeholder="Ingresar Contraseña">
				</div>

				<br>
				<br>
				<div class="text-center">
					<button id="btn-reset" type="reset" class="btn btn-dark">
						<i class="fas fa-trash"></i> Resetear
					</button>
					<button id="btn-ingresar" type="submit" class="btn btn-dark">
						<i class="fas fa-sign-in-alt"></i> Ingresar
					</button>
				</div>
				<h4>${requestScope.msg}</h4>

			</form>
		</div>
	</div>
</body>
<script src="https://kit.fontawesome.com/f16b543c6e.js"
	crossorigin="anonymous"></script>

<script>
	var tiempoRestante = 25;
	var contadorElemento = document.getElementById("contador");
	var btnReset = document.getElementById("btn-reset");
	var btnIngresar = document.getElementById("btn-ingresar");

	function actualizarContador() {
		contadorElemento.innerText = "Este acceso caduca en " + tiempoRestante
				+ "s";

		if (tiempoRestante <= 0) {
			clearInterval(intervalo);
			btnReset.disabled = true;
			btnIngresar.disabled = true;
			window.close();
		}

		tiempoRestante--;
	}
	var intervalo = setInterval(actualizarContador, 1000);
</script>
</html>