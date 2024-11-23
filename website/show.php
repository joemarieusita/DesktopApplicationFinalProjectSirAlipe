<?php
include("dbConnection.php");

$response = [];

$query = "SELECT * FROM `users`";

$result = mysqli_query($connection, $query);

if (!$result) {
    $response = [
        "status" => "error",
        "message" => "Query Failed: " . mysqli_error($connection)
    ];
} else {
    while ($row = mysqli_fetch_assoc($result)) {
        $response[] = [
            "email" => $row["email"],
            "password" => $row["password"]
        ];
    }
}

header("Content-Type: application/json");
echo json_encode($response);

