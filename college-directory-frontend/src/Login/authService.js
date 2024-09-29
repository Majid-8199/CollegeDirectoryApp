import axios from 'axios';

const API_URL = 'http://localhost:8080/api/all'; // Your backend URL

// Login function to authenticate user
const login = async (username, password) => {
  try {
    const response = await axios.post(`${API_URL}/login`, { username, password });
    if (response.data.token) {
      localStorage.setItem('jwt', response.data.token); // Store JWT token
      localStorage.setItem('refreshToken', response.data.refreshToken); // Store Refresh token
      return response.data;
    }
  } catch (error) {
    console.error("Error during login:", error);
    throw error;
  }
};

// Refresh token function
const refreshToken = async () => {
  const refreshToken = localStorage.getItem('refreshToken');
  try {
    const response = await axios.post(`${API_URL}/refresh`, { token: refreshToken });
    localStorage.setItem('jwt', response.data.token); // Update JWT token
    return response.data.token;
  } catch (error) {
    console.error("Error during token refresh:", error);
    throw error;
  }
};

// Logout function to clear tokens
const logout = () => {
  localStorage.removeItem('jwt');
  localStorage.removeItem('refreshToken');
};

// Get JWT token from localStorage
const getToken = () => {
  return localStorage.getItem('jwt');
};

export { login, refreshToken, logout, getToken };
