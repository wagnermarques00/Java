package br.com.alura.tdd.model;

import java.math.BigDecimal;

public enum Performance {
	LACKING {
		@Override
		public BigDecimal readjustmentPercentage() {
			return new BigDecimal("0.03");
		}
	}, GOOD {
		@Override
		public BigDecimal readjustmentPercentage() {
			return new BigDecimal("0.15");
		}
	}, EXCELLENT {
		@Override
		public BigDecimal readjustmentPercentage() {
			return new BigDecimal("0.20");
		}
	};

	public abstract BigDecimal readjustmentPercentage();

}
