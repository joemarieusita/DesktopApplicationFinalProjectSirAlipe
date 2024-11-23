<?php 
include ("dbConnection.php");

if(isset($_GET['email'])){
    $email = $_GET['email'];
    $password = $_GET['password'];
    
    
     $query= "UPDATE users SET email = '$email', password='$password' WHERE email = '$email'";

     $result= mysqli_query($connection, $query);
    
        if(!$result){
            die("query failed".mysqli_error());
        }
        else{
            echo"Updated Successfully!";
        }
}