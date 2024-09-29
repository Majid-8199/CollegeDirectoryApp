import React from 'react';
import { useNavigate } from 'react-router-dom';
import './StudentHeader.css'

const StudentHeader = () => {
  const navigate = useNavigate();

  const handleLinkClick = (route) => {
    navigate(route);
  };

  return (
    <div className="sidebar">
      <div className="sidebar-header">
        <h2>Student Profile</h2>
        <ul>
          <li><button onClick={() => handleLinkClick('/studentDetails')}>Student Details</button></li>
          <li><button onClick={() => handleLinkClick('/facultyAdvisors')}>Faculty Advisors</button></li>
        </ul>
      </div>
      <div  className="sidebar-footer">
      <button onClick={() => handleLinkClick('/administratorProfile/administratorDashboard')}>LogOut</button>
      </div>
    </div>
  );
};

export default StudentHeader;