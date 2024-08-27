import React from "react";
import { Container, Row, Col } from "react-bootstrap";
import myImg from "../../Assets/avatar.svg";
import Tilt from "react-parallax-tilt";

function Home2() {
  return (
    <Container fluid className="home-about-section" id="about">
      <Container>
        <Row>
          <Col md={8} className="home-about-description">
            <h1 style={{ fontSize: "2.6em" }}>
              WHY <span className="purple"> PICKPERFECT? </span>
            </h1>
            <p className="home-about-body">
              Ever found yourself puzzled by which fruit or veggie to choose at
              the grocery store?
              <br />
              <br />
              With
              <i>
                <b className="purple"> PickPerfect, </b>
                you won't have to guess anymore.
              </i>
              <br />
              <br />
              This tool helps you confidently pick the&nbsp;
              <i>
                <b className="purple">best produce,</b> ensuring every selection
                is &nbsp;
                <b className="purple">ripe and ready to enjoy! </b>
              </i>
              <br />
              <br />
            </p>
          </Col>
          <Col md={4} className="myAvtar">
            <Tilt>
              <img src={myImg} className="img-fluid" alt="avatar" />
            </Tilt>
          </Col>
        </Row>
      </Container>
    </Container>
  );
}
export default Home2;
