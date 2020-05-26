package com.reserva.horario.eleicoes.validator;

public class ValidarTituloEleitor {

	public static boolean ValidarTitulo(String strTitulo) {
		if (strTitulo.length() < 12) {
			return false;
		} else {

			int dig9, dig10, dig11, dig12;
			int dv1 = 0, dv2 = 0, qntdDig;

			qntdDig = strTitulo.length(); // Total de caracteres

			// este laco pega do primeiro ate o oitavo digito e calcula o primeiro div
			int multiplicador = 2;
			for (int i = 11; i > 3; i--) {
				dv1 += Integer.parseInt(Mid(strTitulo, qntdDig - i, 1)) * multiplicador;
				multiplicador++;
			}

			dv1 = dv1 % 11;

			dig9 = Integer.parseInt(Mid(strTitulo, qntdDig - 3, 1));
			dig10 = Integer.parseInt(Mid(strTitulo, qntdDig - 2, 1));
			dig11 = Integer.parseInt(Mid(strTitulo, qntdDig - 1, 1));
			dig12 = Integer.parseInt(Mid(strTitulo, qntdDig, 1));

			if (dv1 == 10) {
				dv1 = 0; // Se o resto for igual a 10, dv1 igual a zero
			}

			// Cálculo para o segundo dígito validador
			dv2 = (dig9 * 7) + (dig10 * 8) + (dv1 * 9);
			dv2 = dv2 % 11;

			if (dv2 == 10) {
				dv2 = 0; // Se o resto for igual a 10, dv1 igual a zero
			}

			// Validação dos dígitos validadores, após o cálculo realizado
			if (dig11 == dv1 && dig12 == dv2) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static String Mid(String texto, int inicio, int tamanho) {
		String strMid = texto.substring(inicio - 1, inicio + (tamanho - 1));
		return strMid;
	}
}
