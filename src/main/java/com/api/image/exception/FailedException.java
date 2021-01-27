package com.api.image.exception;

import org.springframework.http.HttpStatus;


//execption personnale;on peut utiliser lors résultat attendu est échoué
public class FailedException  extends GlobalException{
		
		
		private static final long serialVersionUID = 1L;//est obligier par RuntimeException(super)

		public FailedException(String msg) {
			super(msg);
		}

		@Override
		public HttpStatus getCodeStatus() {
			return HttpStatus.EXPECTATION_FAILED;//417
		}
		
}
