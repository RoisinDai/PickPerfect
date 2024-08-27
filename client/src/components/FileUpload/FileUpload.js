import React, { useState } from "react";
import axios from "axios";

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
        justifyContent: "center",
        height: "100vh",
      }}
    >
      <textarea
        value={question}
        onChange={(e) => setQuestion(e.target.value)}
        placeholder="Your question here..."
        style={{ width: "300px", height: "100px", marginBottom: "20px" }}
      />
      <input
        id="file-upload"
        type="file"
        onChange={handleFileChange}
        style={{ display: "none" }}
      />
      <button
        onClick={() => document.getElementById("file-upload").click()}
        style={{ padding: "10px 20px", fontSize: "16px", marginTop: "10px" }}
      >
        Select File
      </button>
      <button
        onClick={handleUpload}
        style={{ padding: "10px 20px", fontSize: "16px", marginTop: "10px" }}
      >
        Upload
      </button>
    </div>
  );
}

export default FileUpload;
