package cibi_lab.aplicacion;

import cibi_lab.aplicacion.Jugador;
import cibi_lab.aplicacion.Pajaro;
import cibi_lab.aplicacion.Tubo;
import cibi_lab.aplicacion.Verde;
import java.util.*;
/**
 * @author: Sergio Pe�a-David Rodriguez
 * @version: 17/11/2017
 */

public class Mundo {
	//Clase del entorno y que pone a funcionar todo
	private int distanciaTubos;
	private ArrayList<Tubo> tubos;
	private Pajaro pajaro;
	private int altura;
	private int anchura;
	private int brecha;
	private boolean parar=false;
	private boolean empezar=false;
	/**
	 * Constructor que inicializa al mundo
	 * @param anchura del mundo
	 * @param altura del mundo
	 */
	public Mundo(int anchura,int altura) {
		brecha = altura/3;    
		this.altura=altura;
		this.anchura=anchura;
		tubos = new ArrayList<Tubo>();
		distanciaTubos = anchura/2;
		pajaro=new Jugador(this);
		pajaro.setPositionX(anchura);
		pajaro.setTamanoX(anchura);
		pajaro.setTamanoY(altura);
		new java.util.Timer().schedule(new TimerTask(){
	        @Override
	        public void run() {
	            correr();
	        }
	    },0,20);

	}
	/**
	 * Da la posicion del pajaro en ambas dimensiones
	 * @return lista de posicion en X y Y
	 */
	public int[] getPosPajaro() {
		int[] posi= {pajaro.getPosX(),pajaro.getPosY()};
		return posi;
	}
	/**
	 * Da el tama�o del pajaro en amabas dimensiones
	 * @return lista del tama�o en X y Y
	 */
	public int[] getTamPajaro(){
		int[] tami= {pajaro.getTamanoX(),pajaro.getTamanoY()};
		return tami;
	}
	/**
	 * Pone a saltar al pajaro en el mundo
	 */
	public void saltarPajaro() {
		empezar=true;
		if(!pajaro.estaMuerto()) {
			pajaro.saltar();
		}
	}
	/**
	 * Genera un tipo de pajaro especifico
	 * @param i
	 */
	public void generarPajaro(int i) {
		
	}
	/**
	 * Genera los tubos del mundo
	 */
	public void generarTubo() {
		if(empezar) {
			int numero = (int)Math.floor(Math.random()*((altura/5+(altura/5))-(altura-altura/5)+1)+(altura-altura/5));
			if(tubos.size()==0) {
				tubos.add(new Verde(this,numero));
			}
			if(tubos.get(tubos.size()-1).getXPositionPrimerTubo()<altura-distanciaTubos) {
				tubos.add(new Verde(this,numero));                   
			}
			ArrayList<Tubo> tubinos=new ArrayList<Tubo>();
			for(Tubo t:tubos) {
				if(t.getXPositionPrimerTubo()+t.getTamanoXPrimerTubo()<0) {
					tubinos.add(t);
				}
			}
			for(Tubo t:tubinos) {
				tubos.remove(t);
			}
		}
	}
	/**
	 * Da la altura del mundo
	 * @return altura del mundo
	 */
	public int getAltura() {
		return altura;
	}
	/**
	 * Da la anchura del mundo
	 * @return anchura del mundo
	 */
	public int getAnchura() {
		return anchura;
	}
	/**
	 * Para todo en el mundo
	 * @return si se para o no
	 */
	public boolean isParar() {
		return parar;
	}
	/**
	 * Pone a correr todo el mundo y mira sus respectivas colisiones
	 */
	public void correr() {
		pajaro.caer();
		if(!parar) {	
			generarTubo();
			for(Tubo t:tubos) {
				t.avanzar();
			}
			colision();    
		}
		
	}
	/**
	 * Da la posicion de los tubos de abajo y de arriba
	 * @return lista de las posiciones de los tubos
	 */
	public ArrayList<int[]> getPosicionTubo(){
		ArrayList<int[]> posTub=new ArrayList<int[]>();
		for(Tubo t:tubos) {
			int[] pos= {t.getXPositionPrimerTubo(),t.getYPositionPrimerTubo(),t.getXPositionSegundoTubo(),t.getYPositionSegundoTubo(),t.getTamanoXPrimerTubo(),t.getTamanoYPrimerTubo(),t.getTamanoXSegundoTubo(),t.getTamanoYSegundoTubo()};
			posTub.add(pos);
		}
		return posTub;
	}
	/**
	 * Da la distancia de separacion entre los dos tubos
	 * @return tama�o de la brecha
	 */
	public int getBrecha() {
		return brecha;
	}
	/**
	 * Mira contra que se choca el pajaro
	 */
	public void colision() {
		if(pajaro.getPosY()+pajaro.getTamanoY()>=(altura-altura/6)) {
			parar=true;
			pajaro.morir();
		}
		for(Tubo t:tubos) {
			if(t.chocaPajaro(pajaro)) {
				parar=true;
				pajaro.morir();
			}
		}
	}
}
