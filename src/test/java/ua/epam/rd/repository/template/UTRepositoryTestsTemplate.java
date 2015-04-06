/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.rd.repository.template;

import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = {"classpath:/springConfigXMLTest.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Ignore
public class UTRepositoryTestsTemplate extends RepositoryTestsTemplate {

}
