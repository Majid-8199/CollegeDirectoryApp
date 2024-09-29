import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './ViewFacultyRecords.css'

function ViewFacultyRecords() {
  const [faculties, setFaculties] = useState([]);
  const [searchId, setSearchId] = useState('');

  useEffect(() => {
    axios.get('/api/faculties')
      .then(response => {
        setFaculties(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  const handleSearch = (id) => {
    axios.get(`/api/faculties/${id}`)
      .then(response => {
        if (response.data) {
          window.location.href = `/search/${id}`;
        } else {
          alert("Faculty not found!");
        }
      })
      .catch(error => {
        console.error(error);
      });
  };

  const handleDeleteAll = () => {
    axios.delete('/api/faculties')
      .then(response => {
        window.location.reload();
      })
      .catch(error => {
        console.error(error);
      });
  };

  const handleDownloadReport = () => {
    axios.get('/api/faculties/report', { responseType: 'blob' })
      .then(response => {
        const url = window.URL.createObjectURL(new Blob([response.data]));
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', 'faculty_report.pdf');
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
            <h1>Faculties List</h1>
            <div className='tbuttons'>
                <button className='deletebutton' onClick={handleDeleteAll}>Delete All Faculties</button>
                <button className='deletebutton' onClick={handleDownloadReport}>Download Report</button>
            </div>
            <div className='search'>
                <input type="number" value={searchId} onChange={(e) => setSearchId(e.target.value)} placeholder="Enter Faculty ID" />
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
                        <th>Office Hours</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {faculties.map((faculty) => (
                        <tr key={faculty.id}>
                            <td>{faculty.id}</td>
                            <td>{faculty.user.name}</td>
                            <td>{faculty.user.email}</td>
                            <td>{faculty.department.name}</td>
                            <td>{faculty.officeHours}</td>
                            <td>
                                <div>
                                    <button className='updateid' onClick={() => window.location.href = `/update/${faculty.id}`}>Update</button>
                                    <button className='deleteid' onClick={() => axios.delete(`/api/faculties/${faculty.id}`).then(() => window.location.reload())}>Delete</button>
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

export default ViewFacultyRecords;