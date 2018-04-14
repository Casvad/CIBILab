package cibi_lab.aplicacion;

import cibi_lab.aplicacion.Mundo;

/**
 * @author: Sergio Pe�a-David Rodriguez
 * @version: 17/11/2017
 */
public abstract class Tubo {
	//Clase donde se inicializa todo lo referente al tubo
	protected int xPositionPrimerTubo;
	protected int yPositionPrimerTubo;
	protected int xPositionSegundoTubo;
	protected int yPositionSegundoTubo;
	protected int tamanoXPrimerTubo;
	protected int tamanoYPrimerTubo;
	protected int tamanoXSegundoTubo;
	protected int tamanoYSegundoTubo;
	protected Mundo mundo;
	
	/**
	 * Pone en movimiento los tubos
	 */
	public void avanzar() {
		xPositionPrimerTubo-=5;
		xPositionSegundoTubo-=5;
	}
	/**
	 * Da la posicion en X del tubo uno
	 * @return entero posicion del tubo uno
	 */
	public int getXPositionPrimerTubo() {
		return xPositionPrimerTubo;
	}
	/**
	 * Da la posicion en Y del tubo uno
	 * @return entero posicion del tubo uno
	 */
	public int getYPositionPrimerTubo() {
		return yPositionPrimerTubo;
	}
	/**
	 * Da la posicion en X del tubo dos
	 * @return entero posicion del tubo dos
	 */
	public int getXPositionSegundoTubo() {
		return xPositionSegundoTubo;
	}
	/**
	 * Da la posicion en Y del tubo dos
	 * @return entero posicion del tubo dos
	 */
	public int getYPositionSegundoTubo() {
		return yPositionSegundoTubo;
	}
	/**
	 * Da el tama�o en X del tubo uno
	 * @return entero tama�o del tubo uno
	 */
	public int getTamanoXPrimerTubo() {
		return tamanoXPrimerTubo;
	}
	/**
	 * Da el tama�o en Y del tubo uno
	 * @return entero tama�o del tubo uno
	 */
	public int getTamanoYPrimerTubo() {
		return tamanoYPrimerTubo;
	}
	/**
	 * Da el tama�o en X del tubo dos
	 * @return entero tama�o del tubo dos
	 */
	public int getTamanoXSegundoTubo() {
		return tamanoXSegundoTubo;
	}
	/**
	 * Da el tama�o en Y del tubo dos
	 * @return entero tama�o del tubo dos
	 */
	public int getTamanoYSegundoTubo() {
		return tamanoYSegundoTubo;
	}
	/**
	 * Mira si el pajaro se choca con el tubo
	 * @param p el pajaro del mundo
	 * @return boleano si se choca
	 */
	public boolean chocaPajaro(Pajaro p) {
		boolean choca=false;
		if(p.getPosX()+p.getTamanoX()>xPositionPrimerTubo && p.getPosX()+p.getTamanoX()<xPositionPrimerTubo+tamanoXPrimerTubo && p.getPosY()+p.getTamanoY()>yPositionPrimerTubo && p.getPosY()+p.getTamanoY()<yPositionPrimerTubo+tamanoYPrimerTubo) {
			choca=true;
		}
		if(p.getPosX()>xPositionPrimerTubo && p.getPosX()<xPositionPrimerTubo+tamanoXPrimerTubo && p.getPosY()+p.getTamanoY()>yPositionPrimerTubo && p.getPosY()+p.getTamanoY()<yPositionPrimerTubo+tamanoYPrimerTubo) {
			choca=true;
		}
		if(p.getPosY()<yPositionSegundoTubo && p.getPosX()+p.getTamanoX()>xPositionSegundoTubo && p.getPosX()+p.getTamanoX()<xPositionSegundoTubo+tamanoXSegundoTubo) {
			choca=true;
		}
		if(p.getPosY()<yPositionSegundoTubo && p.getPosX()>xPositionSegundoTubo && p.getPosX()<xPositionSegundoTubo+tamanoXSegundoTubo) {
			choca=true;
		}
		return choca;
	}
}
