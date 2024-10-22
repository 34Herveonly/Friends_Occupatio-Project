package com.Herve01.App.Restful.API.Repository;

import com.Herve01.App.Restful.API.Model.User;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
