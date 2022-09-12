public interface Authenticable {

	boolean authenticate(int password);

	void setPassword(int password);

}

/*
 * Interface is a contract.
 * Whoever signs this contract needs to implement the methods contained in the interface
 * In this case, the class that implements this interface needs to implement the methods "authenticate" and "setPassword"
 */