import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './ViewFacultyAdvisors.css';

function ViewFacultyAdvisor() {
  const [facultyAdvisors, setFacultyAdvisors] = useState([]);
  const [username, setUsername] = useState('');

  useEffect(() => {
    fetchFacultyAdvisors();
  }, []);

  const fetchFacultyAdvisors = async () => {
    try {
      const response = await axios.get(`/facultyAdvisors/${username}`);
      setFacultyAdvisors(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    fetchFacultyAdvisors();
  };

  return (
    <div className="container">
      <div className="head">
        <div className="actionbuttons">
          <button className="btn add-button">Add Skill</button>
        </div>
      </div>
      <div className="bottom">
        <form onSubmit={handleSubmit}>
          <label>Enter Username:</label>
          <input type="text" value={username} onChange={handleUsernameChange} />
          <button type="submit">Get Faculty Advisors</button>
        </form>
        <table className="table table-striped">
          <thead>
            <tr>
              <th>Id</th>
              <th>Image</th>
              <th>Name</th>
              <th>Department</th>
              <th>Office Hours</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {facultyAdvisors.map((facultyAdvisor) => (
              <tr key={facultyAdvisor.userId}>
                <td>{facultyAdvisor.userId}</td>
                <td>
                  <div className="image">
                    <img src={`data:image/jpeg;base64,${facultyAdvisor.photo}`} alt="Faculty Advisor" />
                  </div>
                </td>
                <td>{facultyAdvisor.user.name}</td>
                <td>{facultyAdvisor.department.name}</td>
                <td>{facultyAdvisor.officeHours}</td>
                <td>
                  <div className="actionbuttons">
                    <button className="btn update-button">Update</button>
                    <button className="btn delete-button">Delete</button>
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ViewFacultyAdvisor;