import React, { useState, useEffect } from 'react';
import axios from 'axios';
import  './UpdateFacultyDetails.css';


function UpdateFacultyDetails() {
  const [faculty, setFaculty] = useState({
    userId: '',
    user: {
      name: '',
      email: '',
      phone: ''
    },
    department: {
      name: ''
    },
    officeHours: '',
    photo: ''
  });
  const [id, setId] = useState('');

  useEffect(() => {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    setId(id);
    axios.get(`/api/faculties/${id}`)
      .then(response => {
        setFaculty(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  const handleUpdateFaculty = (e) => {
    e.preventDefault();
    axios.put(`/api/faculties/${id}`, faculty)
      .then(response => {
        alert('Faculty updated successfully!');
        window.location.href = '/';
      })
      .catch(error => {
        console.error(error);
      });
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFaculty({ ...faculty, [name]: value });
  };

  return (
    <div class="container">
      <div>
        <h3>Faculty Id: {id}</h3>
      </div>
      <form class="form" onSubmit={handleUpdateFaculty}>
        <div>
          <label for="firstname">First Name:</label>
          <input type="text" id="firstname" name="user.name" value={faculty.user.name} onChange={handleChange} required />
        </div>
        <div>
          <label for="lastname">Last Name:</label>
          <input type="text" id="lastname" name="user.lastname" value={faculty.user.lastname} onChange={handleChange} required />
        </div>
        <div>
          <label for="email">Email:</label>
          <input type="text" id="email" name="user.email" value={faculty.user.email} onChange={handleChange} required />
        </div>
        <div>
          <label for="ph">Mobile:</label>
          <input type="text" id="ph" name="user.phone" value={faculty.user.phone} onChange={handleChange} required />
        </div>
        <div>
          <label for="jobrole">Department:</label>
          <input type="text" id="jobrole" name="department.name" value={faculty.department.name} onChange={handleChange} required />
        </div>
        <div>
          <label for="salary">Office Hours:</label>
          <input type="text" id="salary" name="officeHours" value={faculty.officeHours} onChange={handleChange} required />
        </div>
        <div>
          <label for="photo">Photo:</label>
          <input type="file" id="photo" name="photo" onChange={(e) => setFaculty({ ...faculty, photo: e.target.files[0] })} required />
        </div>
        <div>
          <input type="submit" value="Update Faculty" />
          <button type="button" onClick={() => window.location.href = '/'}>Back</button>
        </div>
      </form>
    </div>
  );
}

export default UpdateFacultyDetails;