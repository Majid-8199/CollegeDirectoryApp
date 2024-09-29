import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './ViewStudentDetails.css';

function ViewStudentDetails() {
  const [studentProfiles, setStudentProfiles] = useState([]);
  const [username, setUsername] = useState('');
  const [name, setName] = useState('');
  const [department, setDepartment] = useState('');
  const [year, setYear] = useState('');

  useEffect(() => {
    fetchStudentProfiles();
  }, []);

  const fetchStudentProfiles = async () => {
    try {
      const response = await axios.get('/search', {
        params: {
          name,
          department,
          year,
        },
      });
      setStudentProfiles(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handleNameChange = (event) => {
    setName(event.target.value);
  };

  const handleDepartmentChange = (event) => {
    setDepartment(event.target.value);
  };

  const handleYearChange = (event) => {
    setYear(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    fetchStudentProfiles();
  };

  return (
    <div className="container">
      <div className="head">
        <h1>Student Details</h1>
        <div>
          <form onSubmit={handleSubmit}>
            <input
              type="text"
              value={username}
              onChange={handleUsernameChange}
              placeholder="Enter Username"
            />
            <button type="submit">Search</button>
          </form>
          <form onSubmit={handleSubmit}>
            <input
              type="text"
              value={name}
              onChange={handleNameChange}
              placeholder="Enter Name"
            />
            <input
              type="text"
              value={department}
              onChange={handleDepartmentChange}
              placeholder="Enter Department"
            />
            <input
              type="text"
              value={year}
              onChange={handleYearChange}
              placeholder="Enter Year"
            />
            <button type="submit">Filter</button>
          </form>
        </div>
      </div>
      <div className="bottom">
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Department</th>
              <th>Year</th>
              <th>Attendance</th>
              <th>Grades</th>
            </tr>
          </thead>
          <tbody>
            {studentProfiles.map((studentProfile) => (
              <tr key={studentProfile.userId}>
                <td>{studentProfile.userId}</td>
                <td>{studentProfile.user.name}</td>
                <td>{studentProfile.department.name}</td>
                <td>{studentProfile.year}</td>
                <td>
                  {studentProfile.attendances.map((attendance) => (
                    <p key={attendance.id}>{attendance.date}</p>
                  ))}
                </td>
                <td>
                  {studentProfile.grades.map((grade) => (
                    <p key={grade.id}>{grade.grade}</p>
                  ))}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ViewStudentDetails;