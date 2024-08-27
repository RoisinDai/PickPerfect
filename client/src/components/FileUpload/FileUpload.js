import React, { useState } from "react";
import axios from "axios";
import tomato from "../../Assets/fruits/tomato.svg";

function FileUpload() {
  const [selectedFile, setSelectedFile] = useState(null);
  const [question, setQuestion] = useState("");

  const handleFileChange = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const handleUpload = async () => {
    if (!question && !selectedFile) {
      alert("Please ask a question or upload an image!");
      return;
    }

    const formData = new FormData();
    if (selectedFile) {
      formData.append("file", selectedFile);
    }
    if (question) {
      formData.append("question", question);
    }

    try {
      const response = await axios.post(
        "http://localhost:8080/api/files/upload",
        formData,
        {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        }
      );
      console.log("Response:", response.data);
    } catch (error) {
      console.error("Error uploading file:", error);
    }
  };

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "flex-start",
        height: "100vh",
        paddingTop: "90px",
      }}
    >
      {/* Tomato and Chat Bubble */}
      <div
        style={{
          left: "20%", // Move the tomato to the left
          transform: "translateX(-85%)",
          display: "flex",
          alignItems: "center",
          marginBottom: "20px",
        }}
      >
        <img
          src={tomato}
          alt="Tomato"
          style={{ width: "200px", height: "200px", marginRight: "10px" }}
        />
        <div
          style={{
            position: "relative",
            background: "#f8f9fa",
            borderRadius: "15px",
            padding: "30px",
            maxWidth: "400px",
            boxShadow: "0px 4px 12px rgba(0, 0, 0, 0.1)",
          }}
        >
          <p
            style={{
              margin: 0,
              fontSize: "18px",
              color: "#657B3E",
            }}
          >
            "I'm a juicy tomato!"
          </p>
          <div
            style={{
              position: "absolute",
              top: "50%",
              left: "-10px",
              transform: "translateY(-50%)",
              width: "0",
              height: "0",
              borderTop: "15px solid transparent",
              borderBottom: "15px solid transparent",
              borderRight: "15px solid #f8f9fa",
            }}
          />
        </div>
      </div>

      {/* Dialogue Box and Buttons */}
      <div
        style={{
          display: "flex",
          alignItems: "center",
          justifyContent: "space-between",
          width: "60%",
          gap: "20px",
        }}
      >
        <div
          style={{
            flex: 1,
            border: "2px solid #657B3E",
            borderRadius: "15px",
            padding: "10px",
            boxShadow: "0px 4px 12px rgba(0, 0, 0, 0.1)",
            backgroundColor: "#f8f9fa",
          }}
        >
          <textarea
            value={question}
            onChange={(e) => setQuestion(e.target.value)}
            placeholder="Your question here..."
            style={{
              width: "100%",
              height: "100px",
              border: "none",
              outline: "none",
              resize: "none",
              padding: "10px",
              borderRadius: "10px",
              fontSize: "16px",
              backgroundColor: "#f0f0f0",
            }}
          />
        </div>
        <div
          style={{
            display: "flex",
            flexDirection: "row",
            gap: "10px",
          }}
        >
          <input
            id="file-upload"
            type="file"
            onChange={handleFileChange}
            style={{ display: "none" }}
          />
          <button
            onClick={() => document.getElementById("file-upload").click()}
            style={{
              padding: "10px 20px",
              fontSize: "16px",
              borderRadius: "50px",
              backgroundColor: "#CCD5AE",
              color: "#657B3E",
            }}
          >
            Select File
          </button>
          <button
            onClick={handleUpload}
            style={{
              padding: "10px 20px",
              fontSize: "16px",
              borderRadius: "50px",
              backgroundColor: "#657B3E",
              color: "#FDF9DE",
            }}
          >
            Enter
          </button>
        </div>
      </div>
    </div>
  );
}

export default FileUpload;
