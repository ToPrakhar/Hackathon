<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html lang="en">
	
	<head>
		<title>Car Pool</title>
		
		<link rel="shortcut icon" href="./images/images.ico" type="image/ico" />
		
		<link rel="stylesheet" type="text/css" href="libraries/smoothness/jquery-ui.css" />
		<link rel="stylesheet" href="libraries/jquery.mobile-1.3.2.css" />
		<link rel="stylesheet" href="css/home.css">
		
		<script type="text/javascript" src="libraries/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="libraries/jquery-ui.js"></script>
		<script type="text/javascript" src="libraries/jquery.mobile-1.3.2.js"></script>
		<script type="text/javascript" src="libraries/jquery.blockUI.js"></script>
		<script type="text/javascript" src="js/home.js"></script>
	</head>

<body>

	<div data-role="page" id="home-page" data-theme="d" style="min-height: 245px;">
		
		<!-- header -->
		<div data-role="header" data-theme="b" class="ui-header ui-bar-b" role="banner">
			<h1>Car Pool Status</h1>
			<a href="#left-panel" data-theme="d" data-icon="arrow-r" data-iconpos="notext" data-shadow="false" data-iconshadow="false"></a>
		</div>
	
		<!-- content -->
		<div data-role="content" class="ui-content" role="main">

		</div>
		
		<!-- left panel -->	
		<div data-role="panel" id="left-panel" data-theme="b">
		
			<div data-role="header" data-theme="b" class="ui-header ui-bar-b" role="banner">
				<h1>User Role</h1>
			</div>
			
			<ul data-role="listview">
				<li><a href="#">Driver</a></li>
				<li><a href="#">Rider</a></li>
				<li><a href="#">Help</a></li>
				<li><a href="#">Profile</a></li>
			</ul>
		
		</div>
	
	</div>
	
</body>
</html>