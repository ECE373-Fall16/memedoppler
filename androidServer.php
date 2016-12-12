<html>
	<head>
		<title>
			Meme Doppler Android Server
		</title>
	</head>
	<body>
		<?php
		function getURL($weather)
		{	$numOfMemes=4;	

			$url="memedoppler.com/memes/";	// basic url for database
			$urlExt;			// url extension for specific image
			
			$conditions=getConditions($weather);
			$temperature=getTemperature($weather);
	
			if(preg_match("/.*(Ice|Hail|Freezing)+.*/",$conditions))
				$urlExt.="i";
			if(preg_match("/.*(Snow)+.*/",$conditions))
				$urlExt.="s";
			if(preg_match("/.*(Thunderstorm)+.*/",$conditions))
				$urlExt.="t";
			if(preg_match("/.*(Rain|Showers)+.*/",$conditions)&&(strlen($urlExt)==0))
				$urlExt.="r";
			if(strlen($urlExt)==0)
			{	if(preg_match("/.*(Cloudy|Overcast)+.*/",$conditions))
					$urlExt.="c";
				if(preg_match("/.*(Haze|Fog)+.*/",$conditions))
					$urlExt.="h";
			}
			
			if($temperature>90)
				$urlExt.="9";
			else if($temperature>60)
				$urlExt.="6";
			else if($temperature>30)
				$urlExt.="3";
			else if($temperature>0)
				$urlExt.="0";
			else
				$urlExt.="-";	// negative temperatures

			srand(time(NULL));		// seeds rand()
			$vary=rand(0,($numOfMemes-1));	// variable for variation of memes
			$urlExt.=(string)$vary;		// concatenates variable

			$url.=$urlExt.".jpg";
			return($url);
		}

		$zip=$_GET['zip'];	// gets the zip code from the url
		$file="http://memedoppler.com/WeatherData/".$zip.".txt";	// name of the file is simply the zip code
		$weatherJSON=file_get_contents($file);		// gets the contents of the file in JSON format
		$weatherXML=json_decode($weatherJSON,TRUE);	// decodes the JSON format to get the XML format
		$weather=simplexml_load_string($weatherXML);	// decodes the XML format to an object

		$urls[7];

		for($i=0;$i<7;$i++)
			$urls[$i]=getURL($weather);

		echo json_encode($urls);
		?>
	</body>
</html>
