import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './ViewStudentRecords.css'

function ViewStudentRecords() {
  const [students, setStudents] = useState([]);
  const [searchId, setSearchId] = useState('');

  useEffect(() => {
    axios.get('/api/students')
      .then(response => {
        setStudents(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  const handleSearch = (id) => {
    axios.get(`/api/students/${id}`)
      .then(response => {
        if (response.data) {
          window.location.href = `/search/${id}`;
        } else {
          alert("Student not found!");
        }
      })
      .catch(error => {
        console.error(error);
      });
  };

  const handleDeleteAll = () => {
    axios.delete('/api/students')
      .then(response => {
        window.location.reload();
      })
      .catch(error => {
        console.error(error);
      });
  };

  const handleDownloadReport = () => {
    axios.get('/api/students/report', { responseType: 'blob' })
      .then(response => {
        const url = window.URL.createObjectURL(new Blob([response.data]));
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', 'students_report.pdf');
        document.body.appendChild(link);
        link.click();
        link.parentNode.removeChild(link);
        alert('Download successful!');
      })
      .catch(error => {
        console.error(error);
        alert('Download failed!');
      });
  };

  return (
    <div>
        <div className='head'>
            <h1>Students List</h1>
            <div className='tbuttons'>
                <button className='deletebutton' onClick={handleDeleteAll}>Delete All Students</button>
                <button className='deletebutton' onClick={handleDownloadReport}>Download Report</button>
            </div>
            <div className='search'>
                <input type="number" value={searchId} onChange={(e) => setSearchId(e.target.value)} placeholder="Enter Student ID" />
                <button onClick={() => handleSearch(searchId)}>Search</button>
            </div>
        <div/>
        <div className='bottom'>
            <table className='table table-striped'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Department</th>
                        <th>Year</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {students.map((student) => (
                        <tr key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.user.name}</td>
                            <td>{student.user.email}</td>
                            <td>{student.department.name}</td>
                            <td>{student.year}</td>
                            <td>
                                <div>
                                    <button className='updateid' onClick={() => window.location.href = `/update/${student.id}`}>Update</button>
                                    <button className='deleteid' onClick={() => axios.delete(`/api/students/${student.id}`).then(() => window.location.reload())}>Delete</button>
                                </div>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    </div>
    </div>
  );
}

export default ViewStudentRecords;