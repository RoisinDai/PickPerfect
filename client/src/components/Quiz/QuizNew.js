import React, { useState, useEffect } from "react";
import { Container, Row, Col, Button, Form } from "react-bootstrap";
import axios from "axios";
import Particle from "../Particle";
import { AiOutlineDownload } from "react-icons/ai";
import { Document, Page, pdfjs } from "react-pdf";
import "react-pdf/dist/esm/Page/AnnotationLayer.css";
import broccoliImage from "../../Assets/fruits/broccoli.png";
import pineappleImage from "../../Assets/fruits/pineapple.png";
pdfjs.GlobalWorkerOptions.workerSrc = `//cdnjs.cloudflare.com/ajax/libs/pdf.js/${pdfjs.version}/pdf.worker.min.js`;

function Quiz() {
  const [category, setCategory] = useState("");
  const [difficulty, setDifficulty] = useState("");
  const [questions, setQuestions] = useState([]);
  const [currentQuestion, setCurrentQuestion] = useState(0);
  const [quizStarted, setQuizStarted] = useState(false);
  const [userAnswers, setUserAnswers] = useState([]); // Track user answers!
  const [score, setScore] = useState(null); // Track the quiz score

  const startQuiz = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/quiz/get-questions?category=${category}&difficulty=${difficulty}`
      );
      setQuestions(response.data);
      setQuizStarted(true);
    } catch (error) {
      console.error("Error starting quiz!", error);
    }
  };

  const handleOptionChange = (e) => {
    const updatedAnswers = [...userAnswers];
    updatedAnswers[currentQuestion] = e.target.value;
    setUserAnswers(updatedAnswers);
  };

  const nextQuestion = () => {
    if (currentQuestion < questions.length - 1) {
      setCurrentQuestion(currentQuestion + 1);
    } else {
      submitQuiz();
    }
  };

  const submitQuiz = async () => {
    try {
      const response = await axios.post("http://localhost:8080/quiz/submit", {
        questionIds: questions.map((q) => q.id), // Pass the question IDs
        userResponses: userAnswers, // Pass the user responses
      });
      setScore(response.data); // Set the score
    } catch (error) {
      console.error("Error submitting quiz!", error);
    }
  };

  const optionTextColor = "#fefae0";

  return (
    <Container
      fluid
      className="d-flex align-items-center justify-content-center"
      style={{
        minHeight: "100vh",
        borderRadius: "15px",
        padding: "20px",
      }}
    >
      {!quizStarted ? (
        <Row className="justify-content-center w-100">
          <Col md={6}>
            <div className="d-flex align-items-center justify-content-center">
              <img
                src={broccoliImage}
                alt="Description"
                style={{ width: "100px", height: "100px", marginRight: "10px" }}
              />
              <h1
                style={{
                  fontFamily: "Ultra",
                  marginBottom: "20px",
                  color: "#657B3E",
                  marginTop: "30px",
                }}
              >
                Test Your Knowledge!
              </h1>
              <img
                src={pineappleImage}
                alt="Description"
                style={{ width: "80px", height: "80px", marginRight: "10px" }}
              />
            </div>
            <Form
              style={{
                borderRadius: "15px",
                padding: "20px",
                // boxShadow: "0px 4px 8px rgba(0, 0, 0, 0.1)",
                maxWidth: "700px",
                margin: "auto",
              }}
            >
              <Form.Group className="mb-4">
                <Form.Control
                  as="select"
                  value={category}
                  onChange={(e) => setCategory(e.target.value)}
                  style={{
                    borderRadius: "50px",
                    width: "80%",
                    margin: "auto",
                    padding: "10px",
                    fontSize: "1rem",
                  }}
                >
                  <option value="">Select Category</option>
                  <option value="fruit">Fruit</option>
                  <option value="vegetable">Vegetable</option>
                </Form.Control>
              </Form.Group>
              <Form.Group className="mb-4">
                <Form.Control
                  as="select"
                  value={difficulty}
                  onChange={(e) => setDifficulty(e.target.value)}
                  style={{
                    borderRadius: "50px",
                    width: "80%",
                    padding: "10px",
                    margin: "auto",
                    fontSize: "1rem",
                  }}
                >
                  <option value="">Select Difficulty</option>
                  <option value="Easy">Easy</option>
                  <option value="Medium">Medium</option>
                  <option value="Hard">Hard</option>
                </Form.Control>
              </Form.Group>
              <Button
                style={{
                  width: "40%",
                  borderRadius: "50px",
                  padding: "10px",
                  fontSize: "1rem",
                  margin: "auto",
                  display: "block",
                  fontWeight: "bold",
                }}
                onClick={startQuiz}
              >
                START
              </Button>
            </Form>
          </Col>
        </Row>
      ) : score === null ? (
        <Row className="justify-content-center w-100">
          <Col md={6}>
            <h3
              style={{
                marginBottom: "20px",
                fontWeight: "bold",
                color: "#657B3E",
              }}
            >
              {questions[currentQuestion].questionTitle}
            </h3>
            <Form>
              <Row>
                {[
                  questions[currentQuestion].option1,
                  questions[currentQuestion].option2,
                  questions[currentQuestion].option3,
                  questions[currentQuestion].option4,
                ].map((option, index) => (
                  <Col xs={12} md={6} key={index} className="mb-3">
                    <div
                      className={`quiz-option-box p-3 text-center border ${
                        userAnswers[currentQuestion] === option
                          ? "selected"
                          : ""
                      }`}
                      onClick={() =>
                        handleOptionChange({ target: { value: option } })
                      }
                      style={{
                        color: "#657B3E",
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "center",
                        height: "100px",
                      }}
                    >
                      {option}
                    </div>
                  </Col>
                ))}
              </Row>
            </Form>
            <Button
              className="mt-3 w-100"
              style={{
                width: "40%",
                borderRadius: "50px",
                padding: "10px",
                fontSize: "1rem",
                margin: "auto",
                display: "block",
              }}
              onClick={nextQuestion}
            >
              {currentQuestion < questions.length - 1 ? "NEXT" : "SUBMIT"}
            </Button>
          </Col>
        </Row>
      ) : (
        <Row className="justify-content-center w-100">
          <Col md={6}>
            <h3>
              Your score: {score} / {questions.length}
            </h3>
            <Button
              style={{
                marginTop: "20px",
                width: "100%",
                borderRadius: "50px",
                padding: "10px",
                fontSize: "1rem",
              }}
              onClick={() => {
                setCategory("");
                setDifficulty("");
                setQuestions([]);
                setCurrentQuestion(0);
                setQuizStarted(false);
                setUserAnswers([]);
                setScore(null);
              }}
            >
              RESTART
            </Button>
          </Col>
        </Row>
      )}
    </Container>
  );
}

export default Quiz;
