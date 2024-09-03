import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { GoogleLogin } from "@react-oauth/google";
import { gapi } from "gapi-script";
import tomato from "../../Assets/fruits/tomato.svg";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const clientId = process.env.REACT_APP_GOOGLE_CLIENT_ID;

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/login", {
        username: username,
        password: password,
      });
      localStorage.setItem("token", response.data.token);
      navigate("/");
      console.log("Response:", response.data);
    } catch (error) {
      alert("An error occurred. Please try again later.");
      console.error("Error logging in:", error);
    }
  };

  const onSuccess = (res) => {
    const token = res.credential;
    localStorage.setItem("googleToken", token);
    navigate("/");
  };

  const onFailure = (res) => {
    console.log("LOGIN FAILED! res: ", res);
    alert("Google login failed. Please try again later.");
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
            marginBottom: "20px",
          }}
        >
          Submit
        </button>
        <GoogleLogin
          clientId={clientId}
          buttonText="Login with Google"
          onSuccess={onSuccess}
          onFailure={onFailure}
          cookiePolicy={"single_host_origin"}
          isSignedIn={false}
        />
      </form>
      <div style={{ marginTop: "20px" }}>
        <span style={{ color: "#657B3E" }}>Don't have an account? </span>
        <button
          onClick={() => navigate("/register")}
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
          Sign up
        </button>
      </div>
    </div>
  );
}

export default Login;
