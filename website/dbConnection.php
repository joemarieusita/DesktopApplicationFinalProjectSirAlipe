<?php


   define("HOSTNAME", "127.0.0.1");
   define("USERNAME", "u804916832_api");
   define("PASSWORD", "s~2LCjfB3vAQ");
   define("DATABASE", "u804916832_api");

   $connection = mysqli_connect(HOSTNAME,USERNAME,PASSWORD,DATABASE);

   if(!$connection){
    echo "Connection failed";
   } 
   

?>