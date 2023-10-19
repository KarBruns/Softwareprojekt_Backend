package awk.softwareprojekt.jwt;

import jakarta.enterprise.context.RequestScoped;

import java.io.Serializable;

@RequestScoped
public class SimpleKeyGenerator implements Serializable, KeyGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6709786221442670165L;

	@Override
	public byte[] generateKey() {
		String keyString = "MyPrivateKeyIsHopefullyLongEnough";
//	    Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
	    return keyString.getBytes();
		
	}

}
