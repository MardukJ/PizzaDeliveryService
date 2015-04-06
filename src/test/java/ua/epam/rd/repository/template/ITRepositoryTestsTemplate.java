/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.rd.repository.template;

import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = {"classpath:/springConfig.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Ignore
public class ITRepositoryTestsTemplate extends RepositoryTestsTemplate {

}
