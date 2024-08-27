import React, { useState } from "react";
import axios from "axios";
import tomato from "../../Assets/fruits/tomato.svg";

function FileUpload() {
  const [selectedFile, setSelectedFile] = useState(null);
  const [question, setQuestion] = useState("");
  const [preview, setPreview] = useState("");
  const [tomatoMessage, setTomatoMessage] = useState(
    "Ask a question in the box below and/or upload an image to begin!"
  );
  const [parsedMsg, setParsedMsg] = useState(null);

  const handleFileChange = (event) => {
    const file = event.target.files[0];
    setSelectedFile(file);

    const reader = new FileReader();
    reader.onloadend = () => {
      setPreview(reader.result);
    };
    reader.readAsDataURL(file);
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

      const data = response.data;
      const msg = data.choices[0].message.content;

      let parsedMsg;
      try {
        parsedMsg = JSON.parse(msg);
      } catch (error) {
        console.error("Error parsing message content:", error);
        parsedMsg = { error: "Failed to parse content" };
      }

      setParsedMsg(parsedMsg);

      // Update the tomato's message based on the response
      if (parsedMsg.valid) {
        setTomatoMessage(
          `Wow! A <span style="color: #97B984; font-weight: bold;">${parsedMsg.name}</span>`
        );
      } else {
        setTomatoMessage("Hey! That's not a fruit or vegetable!");
      }
    } catch (error) {
      setTomatoMessage("Hey! That's not a fruit or vegetable!");
      console.error("Error uploading file:", error);
    }
  };

  const handleTryAgain = () => {
    setSelectedFile(null);
    setQuestion("");
    setPreview("");
    setParsedMsg(null);
    setTomatoMessage(
      "Ask a question in the box below and/or upload an image to begin!"
    );
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
          display: "flex",
          alignItems: "center",
          marginBottom: "20px",
          width: "100%",
          paddingLeft: "20%",
        }}
      >
        <img
          src={tomato}
          alt="Tomato"
          style={{
            width: "200px",
            height: "200px",
            marginRight: "10px",
          }}
        />
        <div
          style={{
            background: "#f8f9fa",
            borderRadius: "15px",
            padding: "30px",
            maxWidth: "800px",
            boxShadow: "0px 4px 12px rgba(0, 0, 0, 0.1)",
            whiteSpace: "normal",
            position: "relative",
          }}
        >
          <p
            style={{
              margin: 0,
              fontSize: "18px",
              color: "#657B3E",
            }}
            dangerouslySetInnerHTML={{ __html: tomatoMessage }}
          ></p>

          <div
            style={{
              position: "absolute",
              top: "50%",
              left: "-15px",
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

      {!parsedMsg && (
        <>
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
                  fontSize: "18px",
                  color: "#657B3E",
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

          {/* Image Preview */}
          {preview && (
            <div
              style={{
                marginTop: "20px",
                display: "flex",
                flexDirection: "column",
                alignItems: "center",
              }}
            >
              <img
                src={preview}
                alt="Image Preview"
                style={{
                  border: "2px solid #657B3E",
                  borderRadius: "15px",
                  padding: "10px",
                  maxWidth: "100%",
                  maxHeight: "400px",
                  boxShadow: "0px 4px 12px rgba(0, 0, 0, 0.1)",
                }}
              />
              {/* uploaded file info */}
              {selectedFile && (
                <div
                  style={{
                    marginTop: "10px",
                    textAlign: "center",
                    color: "#657B3E",
                  }}
                >
                  <p>
                    <strong>File:</strong> {selectedFile.name}
                  </p>
                  <p>
                    <strong>Type:</strong> {selectedFile.type}
                  </p>
                </div>
              )}
            </div>
          )}
        </>
      )}

      {/* Display the openAPI returned response */}
      {parsedMsg && parsedMsg.valid && (
        <>
          <div
            style={{
              marginTop: "20px",
              padding: "20px",
              border: "2px solid #657B3E",
              borderRadius: "15px",
              backgroundColor: "#f8f9fa",
              boxShadow: "0px 4px 12px rgba(0, 0, 0, 0.1)",
              width: "60%",
              textAlign: "left",
            }}
          >
            <h3 style={{ color: "#657B3E" }}>
              How to Pick a {parsedMsg.name}:
            </h3>
            <ul style={{ paddingLeft: "20px", color: "#657B3E" }}>
              {parsedMsg.how_to_pick.map((instruction, index) => (
                <li key={index}>{instruction}</li>
              ))}
            </ul>
            <h4 style={{ color: "#657B3E" }}>Best Pick:</h4>
            <p style={{ color: "#657B3E" }}>{parsedMsg.best_pick}</p>
          </div>

          <div
            style={{
              display: "flex",
              justifyContent: "center",
              marginTop: "20px",
            }}
          >
            <button
              onClick={handleTryAgain}
              style={{
                padding: "10px 20px",
                fontSize: "16px",
                borderRadius: "50px",
                backgroundColor: "#657B3E",
                color: "#FDF9DE",
              }}
            >
              Try Again
            </button>
          </div>
        </>
      )}

      {parsedMsg && !parsedMsg.valid && (
        <button
          onClick={handleTryAgain}
          style={{
            marginTop: "20px",
            padding: "10px 20px",
            fontSize: "16px",
            borderRadius: "50px",
            backgroundColor: "#657B3E",
            color: "#FDF9DE",
          }}
        >
          Try Again
        </button>
      )}
    </div>
  );
}

export default FileUpload;
