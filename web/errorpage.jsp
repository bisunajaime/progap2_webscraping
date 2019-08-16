<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1" />
	<title>Error Page</title>
	<%@ include file="style/style.html" %>
	<style>
		* {
			margin: 0;
			padding: 0;
		}

		h4 {
			font-family: "Courier New", Courier, monospace;
		}

		img {
			height: 100vh;
			width: 100vw;
			max-width: 100%;
			object-fit: cover;
		}

		.carousel-caption h1 {
			font-size: 4rem;
		}

		.carousel-caption p {
			font-size: 2rem;
		}

		.btn {
			border: 3px solid white;
			border-radius: 2px;
		}
	</style>
</head>

<body>
	<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" src="style/errpage.jpg" alt="First slide" />
				<div class="carousel-caption">
					<h1><i style="color: #9A031E"><%= exception.getMessage() %></i></h1>
					<h3></h3>
					<p>
						Click the Try Again to continue...
					</p>
					<form action="index.jsp">
						<button class="btn btn-outline-light btn-lg" type="submit">
							Try Again
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="style/footer.html" %>
</body>

</html>