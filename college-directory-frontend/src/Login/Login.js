import React, { useState } from 'react';
import { login } from './authService'; // Import the login function from the service
import { useNavigate } from 'react-router-dom';
import './Login.css';
import loginImage from './loginpage.jpg';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const data = await login(username, password);
      if (data) {
        navigate('/dashboard');
      }
    } catch (err) {
      setError('Invalid email or password');
    }
  };

  return (
    <div className='loginmaincontainer'>
      <div className='loginright'>
        <div className='loginheader'>
          <h1>College Directory Application</h1>
        </div>
        <div className="login-container">
          <h2>Login</h2>
          <form onSubmit={handleSubmit} className='loginform'>
            <div  className="login-form-group">
              <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} placeholder='Username' required />
            </div>
            <div   className="login-form-group">
              <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder='Password' required />
            </div>
            <button type="submit" className='login-button'>Login</button>
            {error && <div className="error">{error}</div>}
          </form>
        </div>
      </div>
      <div className='loginImgContainer'>
        <img src={loginImage} alt="Login page background" />
      </div>
    </div>
  );
};

export default Login;
