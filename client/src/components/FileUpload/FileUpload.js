import React, { useState } from "react";
import axios from "axios";
import { Container, Row, Col } from "react-bootstrap";
import ProjectCard from "./ProjectCards";
import Particle from "../Particle";

function FileUpload() {
  const [selectedFile, setSelectedFile] = useState(null);

  const handleFileChange = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const handleUpload = async () => {
    const formData = new FormData();
    formData.append("file", selectedFile);

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
    <div style={{ padding: "20px" }}>
      <input
        type="file"
        onChange={handleFileChange}
        style={{ display: "block", marginBottom: "10px" }}
      />
      <button
        onClick={handleUpload}
        style={{ padding: "10px 20px", fontSize: "16px" }}
      >
        Upload
      </button>
    </div>
  );
}

export default FileUpload;
