<?php 
include ("dbConnection.php");

if(isset($_GET['email'])){
    $email = $_GET['email'];
    $password = $_GET['password'];
    
    
     $query= "INSERT INTO users (email,password) values('$email','$password')";

     $result= mysqli_query($connection, $query);
    
        if(!$result){
            die("query failed".mysqli_error());
        }
        else{
            echo"Add Successfully!";
        }
    
    echo "Email Address: $email, Password: $password";
}
?>