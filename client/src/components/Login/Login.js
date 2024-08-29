import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import tomato from "../../Assets/fruits/tomato.svg";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/login", {
        username: username,
        password: password,
      });

      navigate("/");
      console.log("Response:", response.data);
    } catch (error) {
      alert("An error occurred. Please try again later.");
      console.error("Error logging in:", error);
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
      <img
        src={tomato}
        alt="Tomato"
        style={{
          width: "70px",
          height: "70px",
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
        PickPerfect
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
          Submit
        </button>
      </form>
    </div>
  );
}

export default Login;
