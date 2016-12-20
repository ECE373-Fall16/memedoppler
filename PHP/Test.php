<?php
use 'androidServer.php';
 
class LocationTests extends PHPUnit_Framework_TestCase
{
        public function zip1()
        {
            $zip = "04101";
            $this->assertEquals("04101", $zip);
        }

}

