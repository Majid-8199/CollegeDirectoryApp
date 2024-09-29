import React from 'react';
import { useNavigate } from 'react-router-dom';
import './FacultyHeader.css'

const FacultyHeader = () => {
  const navigate = useNavigate();

  const handleLinkClick = (route) => {
    navigate(route);
  };

  return (
    <div className="sidebar">
      <div className="sidebar-header">
        <h2>Faculty Profile</h2>
        <ul>
          <li><button onClick={() => handleLinkClick('/classList')}>Class List</button></li>
          <li><button onClick={() => handleLinkClick('/facultyDetails')}>Faculty Details</button></li>
        </ul>
      </div>
      <div  className="sidebar-footer">
      <button onClick={() => handleLinkClick('/administratorProfile/administratorDashboard')}>LogOut</button>
      </div>
    </div>
  );
};

export default FacultyHeader;