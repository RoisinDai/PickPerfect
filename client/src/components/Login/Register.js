import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import broccoli from "../../Assets/fruits/broccoli.svg";

function Register() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [showSuccessPopup, setShowSuccessPopup] = useState(false);
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (password !== confirmPassword) {
      alert("Passwords do not match. Please try again.");
      return;
    }

    try {
      const response = await axios.post("http://localhost:8080/register", {
        username: username,
        password: password,
      });

      setShowSuccessPopup(true);
      setTimeout(() => {
        setShowSuccessPopup(false);
        navigate("/login");
      }, 3000);
    } catch (error) {
      alert("An error occurred during registration. Please try again later.");
      console.error("Error registering:", error);
    }
  };

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
        height: "100vh",
      }}
    >
      {showSuccessPopup && (
        <div
          style={{
            position: "fixed",
            top: "20px",
            left: "50%",
            transform: "translateX(-50%)",
            backgroundColor: "#FDF9DE",
            padding: "10px 20px",
            borderRadius: "5px",
            boxShadow: "0px 0px 10px rgba(0, 0, 0, 0.1)",
            zIndex: 1000,
          }}
        >
          <h4 style={{ color: "#657B3E", margin: 0 }}>
            Registration Successful! Redirecting...
          </h4>
        </div>
      )}
      <img
        src={broccoli}
        alt="Broccoli"
        style={{
          width: "90px",
          height: "90px",
          marginRight: "10px",
        }}
      />
      <h1
        style={{
          marginBottom: "20px",
          color: "#657B3E",
          fontFamily: "Ultra",
          fontSize: "2.5rem",
        }}
      >
        Create Your Account
      </h1>
      <form
        onSubmit={handleSubmit}
        style={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          width: "300px",
        }}
      >
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          style={{
            padding: "10px",
            marginBottom: "10px",
            width: "100%",
            borderRadius: "5px",
            border: "1px solid #ccc",
          }}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          style={{
            padding: "10px",
            marginBottom: "10px",
            width: "100%",
            borderRadius: "5px",
            border: "1px solid #ccc",
          }}
        />
        <input
          type="password"
          placeholder="Confirm Password"
          value={confirmPassword}
          onChange={(e) => setConfirmPassword(e.target.value)}
          style={{
            padding: "10px",
            marginBottom: "20px",
            width: "100%",
            borderRadius: "5px",
            border: "1px solid #ccc",
          }}
        />
        <button
          type="submit"
          style={{
            padding: "10px 20px",
            width: "100%",
            borderRadius: "5px",
            backgroundColor: "#657B3E",
            color: "#FDF9DE",
            fontSize: "16px",
            border: "none",
          }}
        >
          Register
        </button>
      </form>
      <div style={{ marginTop: "20px" }}>
        <span style={{ color: "#657B3E" }}>Return to </span>
        <button
          onClick={() => navigate("/login")}
          style={{
            background: "none",
            border: "none",
            color: "#657B3E",
            cursor: "pointer",
            textDecoration: "underline",
            fontSize: "16px",
            padding: "0",
          }}
        >
          Login
        </button>
      </div>
    </div>
  );
}

export default Register;
