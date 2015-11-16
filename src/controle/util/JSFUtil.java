package controle.util;

import java.util.Map;

import javax.faces.context.FacesContext;

public class JSFUtil {

	/**
	 * M�todo que l� um par�metro de um link ou bot�o passado atrav�s da TAG
	 * <code>&lt;f:param&gt;</code>.
	 * 
	 * @param nomeDoParametro
	 *            valor usado no atributo name da TAG "param"
	 * @return o valor passado no envio da requisi��o como uma String
	 */
	public static String getParametro(String nomeDoParametro) {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> map = context.getExternalContext()
				.getRequestParameterMap();
		String valor = map.get(nomeDoParametro);

		return valor;
	}

	/**
	 * Método que lê um parâmetro de um link ou botão passado através da TAG
	 * <f:param>, convertendo o valor para Long.
	 * 
	 * @param nomeDoParametro
	 *            valor usado no atributo name da TAG "param"
	 * @return o valor passado no envio da requisi��o como um Long
	 */
	public static Long getParametroLong(String nomeDoParametro) {
		String valor = getParametro(nomeDoParametro);
		Long valorLong;
		try {
			valorLong = new Long(valor);
		} catch (Exception e) {
			valorLong = null;
		}

		return valorLong;
	}
}
