package br.com.bicicleta.test.peca;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		glue = "br.com.bicicleta.test.peca"

		)
public class ListaPecaFeature {

}