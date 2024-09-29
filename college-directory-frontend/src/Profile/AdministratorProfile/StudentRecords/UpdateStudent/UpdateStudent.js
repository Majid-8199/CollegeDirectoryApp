import React, { useState, useEffect } from 'react';
import axios from 'axios';
import  './UpdateStudent.css';


function UpdateStudent() {
  const [student, setStudent] = useState({
    userId: '',
    user: {
      name: '',
      email: '',
      phone: ''
    },
    department: {
      name: ''
    },
    year: '',
    photo: ''
  });
  const [id, setId] = useState('');

  useEffect(() => {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    setId(id);
    axios.get(`/api/faculties/${id}`)
      .then(response => {
        setStudent(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  const handleUpdateStudent = (e) => {
    e.preventDefault();
    axios.put(`/api/faculties/${id}`, student)
      .then(response => {
        alert('Student updated successfully!');
        window.location.href = '/';
      })
      .catch(error => {
        console.error(error);
      });
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setStudent({ ...student, [name]: value });
  };

  return (
    <div class="container">
      <div>
        <h3>Student Id: {id}</h3>
      </div>
      <form class="form" onSubmit={handleUpdateStudent}>
        <div>
          <label for="firstname">First Name:</label>
          <input type="text" id="firstname" name="user.name" value={student.user.name} onChange={handleChange} required />
        </div>
        <div>
          <label for="lastname">Last Name:</label>
          <input type="text" id="lastname" name="user.lastname" value={student.user.lastname} onChange={handleChange} required />
        </div>
        <div>
          <label for="email">Email:</label>
          <input type="text" id="email" name="user.email" value={student.user.email} onChange={handleChange} required />
        </div>
        <div>
          <label for="ph">Mobile:</label>
          <input type="text" id="ph" name="user.phone" value={student.user.phone} onChange={handleChange} required />
        </div>
        <div>
          <label for="jobrole">Department:</label>
          <input type="text" id="jobrole" name="department.name" value={student.department.name} onChange={handleChange} required />
        </div>
        <div>
          <label for="salary">Office Hours:</label>
          <input type="text" id="salary" name="officeHours" value={student.officeHours} onChange={handleChange} required />
        </div>
        <div>
          <label for="photo">Photo:</label>
          <input type="file" id="photo" name="photo" onChange={(e) => setStudent({ ...student, photo: e.target.files[0] })} required />
        </div>
        <div>
          <input type="submit" value="Update Student" />
          <button type="button" onClick={() => window.location.href = '/'}>Back</button>
        </div>
      </form>
    </div>
  );
}

export default UpdateStudent;