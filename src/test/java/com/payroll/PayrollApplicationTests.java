package com.payroll;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@Slf4j
class PayrollApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void connectToLocalDbTest() throws SQLException {
		assertThat(dataSource).isNotNull();

		try(Connection connection = dataSource.getConnection()){
			assertThat(connection).isNotNull();
			assertThat(connection.getCatalog()).isEqualTo("payrolldb");
		}catch (SQLException ex){
			log.info("Error occurred --> {}", ex.getMessage());
		}
	}

}
