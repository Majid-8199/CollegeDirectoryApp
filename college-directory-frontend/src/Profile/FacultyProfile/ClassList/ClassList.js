import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './ClassList.css';

function ClassList() {
  const [classList, setClassList] = useState([]);
  const [username, setUsername] = useState('');

  useEffect(() => {
    fetchClassList();
  }, []);

  const fetchClassList = async () => {
    try {
      const response = await axios.get(`/class/${username}`);
      setClassList(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    fetchClassList();
  };

  return (
    <div className="container">
      <div className="head">
        <div className="actionbuttons">
          <button className="btn add-button">Add Skill</button>
        </div>
      </div>
      <div className="bottom">
        <table className="table table-striped">
          <thead>
            <tr>
              <th>Id</th>
              <th>Image</th>
              <th>Name</th>
              <th>Department</th>
              <th>Year</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {classList.map((studentProfile) => (
              <tr key={studentProfile.userId}>
                <td>{studentProfile.userId}</td>
                <td>
                  <div className="image">
                    <img src={`data:image/jpeg;base64,${studentProfile.photo}`} alt="Student Profile" />
                  </div>
                </td>
                <td>{studentProfile.user.name}</td>
                <td>{studentProfile.department.name}</td>
                <td>{studentProfile.year}</td>
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

export default ClassList;