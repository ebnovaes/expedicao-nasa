package expedicao.comum;

public class TratamentoComum {
	
	public static Integer tryParse(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
}
