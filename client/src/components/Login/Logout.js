import React from "react";
import Button from "react-bootstrap/Button";
import { useNavigate } from "react-router-dom";

function LogoutButton() {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("googleToken");
    navigate("/login");
  };

  return (
    <Button
      variant="outline-danger"
      onClick={handleLogout}
      style={{
        position: "absolute",
        left: "200px",
        top: "50%",
        transform: "translateY(-50%)",
        color: "#657B3E", // Set text color to #657b3e
        borderColor: "#657B3E", // Set border color to #657b3e
        backgroundColor: "transparent", // Make background transparent
        fontWeight: "bold", // Optional: Make the text bold
      }}
    >
      Logout
    </Button>
  );
}

export default LogoutButton;
