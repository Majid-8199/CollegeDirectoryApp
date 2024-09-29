import React from 'react';
import { useNavigate } from 'react-router-dom';
import './AdministratorHeader.css'

const AdministratorHeader = () => {
  const navigate = useNavigate();

  const handleLinkClick = (route) => {
    navigate(route);
  };

  return (
    <div className="sidebar">
      <div className="sidebar-header">
        <h2>Administrator Profile</h2>
        <ul>
          <li><button onClick={() => handleLinkClick('/administratorDashboard')}>Dashboard</button></li>
          <li><button onClick={() => handleLinkClick('/viewAllFaculty')}>Faculty Records</button></li>
          <li><button onClick={() => handleLinkClick('/viewAllStudent')}>Student Records</button></li>
        </ul>
      </div>
      <div  className="sidebar-footer">
      <button onClick={() => handleLinkClick('/administratorProfile/administratorDashboard')}>LogOut</button>
      </div>
    </div>
  );
};

export default AdministratorHeader;