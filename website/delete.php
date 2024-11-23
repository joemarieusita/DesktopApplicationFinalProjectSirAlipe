<?php 
include ("dbConnection.php");

if(isset($_GET['email'])){
    $email = $_GET['email'];
    
    
     $query= "DELETE FROM users WHERE email = '$email'";

     $result= mysqli_query($connection, $query);
    
        if(!$result){
            die("query failed".mysqli_error());
        }
        else{
            echo"Delete Successfully!";
        }
}