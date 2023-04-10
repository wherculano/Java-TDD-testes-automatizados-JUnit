package main.java.br.com.alura.tdd.service;

import main.java.br.com.alura.tdd.modelo.Desempenho;
import main.java.br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal salario = funcionario.getSalario();
        if (desempenho == Desempenho.A_DESEJAR) {
            BigDecimal reajuste = salario.multiply(new BigDecimal("0.03"));
            funcionario.reajustarSalario(reajuste);
        }
        if (desempenho == Desempenho.BOM) {
            BigDecimal reajuste = salario.multiply(new BigDecimal("0.15"));
            funcionario.reajustarSalario(reajuste);
        }
        if (desempenho == Desempenho.OTIMO) {
            BigDecimal reajuste = salario.multiply(new BigDecimal("0.20"));
            funcionario.reajustarSalario(reajuste);
        }
    }
}
