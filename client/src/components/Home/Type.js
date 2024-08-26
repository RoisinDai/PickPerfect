import React from "react";
import { useNavigate } from "react-router-dom";
import Typewriter from "typewriter-effect";

function Type() {
  const navigate = useNavigate();

  return (
    <div
      style={{ cursor: "pointer", color: "#AEC7A0" }}
      onClick={() => navigate("/project")}
    >
      <Typewriter
        options={{
          strings: ["Let's Start Picking!"],
          autoStart: true,
          loop: true,
          deleteSpeed: 50,
        }}
      />
    </div>
  );
}

export default Type;
