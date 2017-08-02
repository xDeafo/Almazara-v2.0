package jdbc;

public class ConnectionException extends RuntimeException {

	public ConnectionException() {
		super();
	}

	public ConnectionException(String msg) {
		super(msg);
	}
 
	/*ConnectionException no deriva de Exception, sino de RuntimeException. Las 
	RuntimeException son excepciones no comprobadas (como la división por cero) y por tanto no es 
	obligatorio capturarlas con try-catch ni propagarlas con throws. Hacemos esto así para no tener que 
	poner un bloque try-catch cada vez que se puede producir este tipo de excepción.*/
}
