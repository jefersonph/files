<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Teste - Abas</title>
        
		<link type="text/css" href="css/smoothness/jquery-ui-1.8.2.custom.css" rel="stylesheet" />	
        <link type="text/css" href="css/main.css" rel="stylesheet" />
		<script type="text/javascript" src="js/lib/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/lib/jquery-ui-1.8.2.custom.min.js"></script>
        <script type="text/javascript" src="js/tabs.js"></script>	
		
	</head>
	<body>		

		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">Aba 1</a></li>
				<li><a href="#tabs-2">Aba 2</a></li>
			</ul>
			<div id="tabs-1">Aba 1.</div>
			<div id="tabs-2">
				<?php
					if (file_exists('terra.xml')) 
					{
						$xml = simplexml_load_file('terra.xml');
						foreach($xml->children() as $child)
						{
							echo $child->getName() . "<br />";
						}
					} else {
								exit('Failed to open terra.xml.');
						   }
				?>
			</div>
		</div>	  
        
	</body>
</html>


