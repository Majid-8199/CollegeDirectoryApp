import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './Login/Login';
import AdministratorDashboard from './Profile/AdministratorProfile/AdministatorDashboard/AdministratorDashboard';
import ViewAllFaculty from './Profile/AdministratorProfile/FacultyRecords/ViewFacultyRecords/ViewFacultyRecords';
import AddFaculty from './Profile/AdministratorProfile/FacultyRecords/AddFaculty/AddFaculty';
import UpdateFaculty from './Profile/AdministratorProfile/FacultyRecords/UpdateFaculty/UpdateFaculty';
import ViewAllStudent from './Profile/AdministratorProfile/StudentRecords/ViewStudentRecords/ViewStudentRecords';
import AddStudent from './Profile/AdministratorProfile/StudentRecords/AddStudent/AddStudent';
import UpdateStudent from './Profile/AdministratorProfile/StudentRecords/UpdateStudent/UpdateStudent';
import ClassList from './Profile/FacultyProfile/ClassList/ClassList';
import FacultyDetails from './Profile/FacultyProfile/UpdateFacultyDetails/UpdateFacultyDetails';
import StudentDetails from './Profile/StudentProfile/ViewStudentDetails/ViewStudentDetails';
import FacultyAdvisors from './Profile/StudentProfile/ViewFacultyAdvisors/ViewFacultyAdvisors';

const AppRoutes = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/administratorDashboard" element={<AdministratorDashboard />}/>
        <Route path="/viewAllFaculty" element={<ViewAllFaculty />}/>
        <Route path="/addFaculty" element={<AddFaculty />}/>
        <Route path="/updateFaculty" element={<UpdateFaculty />}/>
        <Route path="/viewAllStudent" element={<ViewAllStudent />}/>
        <Route path="/addStudent" element={<AddStudent />}/>
        <Route path="/updateStudent" element={<UpdateStudent />}/>
        
        <Route path="/classList" element={<ClassList />}/>
        <Route path="/facultyDetails" element={<FacultyDetails />}/>
        
        <Route path="/studentDetails" element={<StudentDetails />}/>
        <Route path="/facultyAdvisors" element={<FacultyAdvisors />}/>
      </Routes>
    </BrowserRouter>
  );
};

export default AppRoutes;