import React, { useState } from "react";
import axios from "axios";

function Login() {

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = () => {
    axios.post("http://localhost:8080/api/users/login", {
      email,
      password
    })
    .then(res => {
      alert("Login Successful ✅");
      window.location.href = "/jobs";
    })
    .catch(err => {
      alert("Invalid Credentials ❌");
    });
  };
return (
  <div style={{
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    height: "100vh",
    background: "#f5f5f5"
  }}>
    <div style={{
      background: "white",
      padding: "30px",
      borderRadius: "10px",
      boxShadow: "0 0 10px gray"
    }}>
      <h2>Login</h2>

      <input placeholder="Email" onChange={(e)=>setEmail(e.target.value)} /><br/><br/>
      <input type="password" placeholder="Password" onChange={(e)=>setPassword(e.target.value)} /><br/><br/>

      <button style={{ width: "100%" }} onClick={handleLogin}>
        Login
      </button>
    </div>
  </div>
);
}

export default Login;