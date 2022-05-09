package com.serole.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.serole.demo.entity.User;
@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private static final String INSERT_USER_QUERY1="INSERT INTO  user(id,firstname,lastname,email)  values(?,?,?,?)";
	private static final String UPDATE_USER_BY_ID_QUERY="UPDATE USER SET firstname=? WHERE ID=?";
	private static final String GET_USER_BY_ID_QUERY="SELECT* FROM USER WHERE ID=?";
	private static final String DELETE_USER_BY_ID="DELETE  FROM USER WHERE ID=?";
	private static final String GET_USER_QUERY="SELECT *FROM USER";
	@Autowired
	private JdbcTemplate jdbctemplate;
	//@Autowired
	//private NamedParameterJdbcTemplate namedparametertemplate;
	
	
	
	@Override
	public User saveUser(User user) {
	jdbctemplate.update(INSERT_USER_QUERY1,user.getId(),user.getFirstname(),user.getLastname(),user.getEmail());
		
		//SqlParameterSource parameter = new MapSqlParameterSource("id",user.getId())
				                          //  .addValue("firstname", user.getFirstname())
				                         //   .addValue("lastname", user.getLastname())
				                         //   .addValue("email", user.getEmail());
		//namedparametertemplate.update(INSERT_USER_QUERY1, parameter);
		return user;
	}

	@Override
	public User updateUser(User user) {
		jdbctemplate.update(UPDATE_USER_BY_ID_QUERY,user.getFirstname(),user.getId());
		return user;
	}

	@Override
	public User getUserById(int id) {
		return jdbctemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) -> {

			return new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"),rs.getString("email"));
		}, id);
	}

	@Override
	public String deleteById(int id) {
		jdbctemplate.update(DELETE_USER_BY_ID, id);
		return "Employee Deleted with id" + id;
	}

	@Override
	public List<User> allUsers() {
		// TODO Auto-generated method stub
		return jdbctemplate.query(GET_USER_QUERY, (rs, rowNum) -> {
			return new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"),rs.getString("email"));
		});
	}

}


