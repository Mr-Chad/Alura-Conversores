package clases;

public class Divisas {
		private double valorUsd = 0;
		private String simbolo;
		private String nombre;
		
		public Divisas(String n, String s, double v) {
			valorUsd = v;
			simbolo = s;
			nombre = n;
		}
		
		public double getValorUsd() {
			return valorUsd;
		}
		public void setValorUsd(double valorUsd) {
			this.valorUsd = valorUsd;
		}
		public String getSimbolo() {
			return simbolo;
		}
		public void setSimbolo(String simbolo) {
			this.simbolo = simbolo;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		@Override
		public String toString() {
			return this.nombre;
		}
				
}
