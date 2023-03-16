package com.bankingapp.bankingapp;

import com.bankingapp.bankingapp.adapters.inbound.CuentaRestControllerTest;
import com.bankingapp.bankingapp.adapters.inbound.TransferenciaRestControllerTest;
import com.bankingapp.bankingapp.adapters.inbound.UsuarioRestControllerTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Suite.SuiteClasses(value = {UsuarioRestControllerTest.class, CuentaRestControllerTest.class, TransferenciaRestControllerTest.class})
@SpringBootTest(classes = BankingAppApplication.class)
class BankingAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
