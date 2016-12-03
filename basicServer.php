<?php
$weatherData=;

$data=json_decode($weatherData);

$snow=$data[];
$precip=$data[];
$cloud=$data[];
$temp=$data[];

$url;		// basic url for database
$urlExt;	// url extension for image

if($snow)
{	$urlExt="s";
	if($temp>20)
	{	$urlExt.="2";
	}
	else if($temp>0)
	{	$urlExt.="0";
	}
	else
	{	$urlExt.="-";
	}
}
else if($precip)
{	$urlExt="p";
}
else if($cloud)
{	$urlExt="c";
}
else
{	$urlExt="0";
}
if(!$snow)
{	if($temp>90)
	{	$urlExt.="9";
	}
	else if($temp>60)
	{	$urlExt.="6";
	}
	else if($temp>30)
	{	$urlExt.="3";
	}
	else if($temp>0)
	{	$urlExt.="0";
	}
	else
	{	$urlExt.="-";	// negative temperature conditions
	}
}

srand(time(NULL));		// seeds rand()
$vary=rand(0,($numOfMemes-1));	// variable for variation of memes
$urlExt.=(string)$vary;		// concatenates variable

?>
