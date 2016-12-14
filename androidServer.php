<html>
	<head>
		<title>
			Meme Doppler Android Server
		</title>
	</head>
	<body>
		<?php
		function getURL($parameters,$hr)
		{	$numOfMemes=1;	

			$url="memedoppler.com/memes/";	// basic url for database
			$urlExt;			// url extension for specific image
			
			$maxTemp=$parameters["temperature"][0]["value"][$hr];
			$minTemp=$parameters["temperature"][1]["value"][$hr];
			$temperature=($maxTemp+$minTemp)/2;

			do
			{	$conditions=$parameters["weather"]["weather-conditions"][$hr]["value"]["weather-type"];
				$hr--;
			}while($conditions==""&&$hr>0);
			if($conditions=="")
				$conditions="clear";

			if(preg_match("/.*(ice|hail|freezing)+.*/",$conditions))
				$urlExt.="i";
			if(preg_match("/.*(snow)+.*/",$conditions))
				$urlExt.="s";
			if(preg_match("/.*(thunderstorm)+.*/",$conditions))
				$urlExt.="t";
			if(preg_match("/.*(rain|showers)+.*/",$conditions)&&(strlen($urlExt)==0))
				$urlExt.="r";
			if(strlen($urlExt)==0)
			{	if(preg_match("/.*(cloudy|overcast)+.*/",$conditions))
					$urlExt.="c";
				if(preg_match("/.*(haze|fog)+.*/",$conditions))
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
			
			/*-----Randomization-----*/
			/*
			srand(time(NULL));		// seeds rand()
			$vary=rand(0,($numOfMemes-1));	// variable for variation of memes
			$urlExt.=(string)$vary;		// concatenates variable
			*/
			$url.=$urlExt.".jpg";
			return($url);
		}
		function getWeatherData($zip)
		{	/*-----Eventual Implementation-----*/
			/*
			$client=new SoapClient("http://graphical.weather.gov/xml/DWMLgen/wsdl/ndfdXML.wsdl",array("trace"=>1,"exceptions"=>0));
			$LatLon=$client->LatLonListZipCode($zip);
			*/

			/*-----Temporary-----*/
			$filename="http://memedoppler.com/WeatherData/".$zip.".txt";
			$weatherJSON=file_get_contents($filename);
			$weatherXML=json_decode($weatherJSON,TRUE);
			
			return($weatherXML);
		}
		function getMemes($zip)
		{	$weatherXML=getWeatherData($zip);
			$parameters=$weatherXML["dwml"]["data"]["parameters"];
			$urls[7];
			for($hr=0;$hr<7;$hr++)
				$urls[$hr]=getURL($parameters,$hr);
			return($urls);
		}
		$zip=$_GET['zip'];	// gets the zip code from the url
		echo json_encode(getMemes($zip));
		?>
	</body>
</html>