package courseManagement;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	public boolean isUserExist(String userName){
		boolean isExist = false;
        db_connect conn = new db_connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
      try{
    	  ps = conn.c.prepareStatement("SELECT * FROM `accounts` WHERE `username` = ?");
    	  ps.setString(1,userName);
    	  rs =ps.executeQuery();
    	  if(rs.next()){
    		  isExist= true;
    		  }
    	  } catch (SQLException ex) {

       }
        return isExist;
    }
	public boolean isCourseExist(String courseName){
		boolean isExist = false;
        db_connect conn = new db_connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
      try{
    	  ps = conn.c.prepareStatement("SELECT * FROM `courses` WHERE `course_name` = ?");
    	  ps.setString(1,courseName);
    	  rs =ps.executeQuery();
    	  if(rs.next()){
    		  isExist= true;
    		  }
    	  } catch (SQLException ex) {

       }
        return isExist;
    }
	public boolean isModuleExist(String ModuleId){
		boolean isExist = false;
        db_connect conn = new db_connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
      try{
    	  ps = conn.c.prepareStatement("SELECT * FROM `modules` WHERE `module_id` = ?");
    	  ps.setString(1,ModuleId);
    	  rs =ps.executeQuery();
    	  if(rs.next()){
    		  isExist= true;
    		  }
    	  } catch (SQLException ex) {

       }
        return isExist;
    }
	public boolean isStudentExist(String StudentId){
		boolean isExist = false;
        db_connect conn = new db_connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
      try{
    	  ps = conn.c.prepareStatement("SELECT * FROM `student` WHERE `student_id` = ?");
    	  ps.setString(1,StudentId);
    	  rs =ps.executeQuery();
    	  if(rs.next()){
    		  isExist= true;
    		  }
    	  } catch (SQLException ex) {

       }
        return isExist;
    }
	public boolean isInstructorExist(String InstName){
		boolean isExist = false;
        db_connect conn = new db_connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
      try{
    	  ps = conn.c.prepareStatement("SELECT * FROM `instructor` WHERE `instructor_id` = ?");
    	  ps.setString(1,InstName);
    	  rs =ps.executeQuery();
    	  if(rs.next()){
    		  isExist= true;
    		  }
    	  } catch (SQLException ex) {

       }
        return isExist;
    }
}
