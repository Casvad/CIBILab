package cibi_lab.aplicacion;

import cibi_lab.aplicacion.Mundo;

/**
 * @author: Sergio Pe�a-David Rodriguez
 * @version: 17/11/2017
 */
public abstract class Pajaro {
	//Esta clase crea el pajaro del mundo
	public static final double GRAVEDAD = 1;
	protected int efectividad;
	protected int fotaleza;
	protected boolean poder;
	protected boolean estaMuerto=false;
	protected int xPosition;
	protected int yPosition;
	protected int yVel=0;
	protected Mundo mundo;
	protected int tamanoX;
	protected int tamanoY;
	protected int velLim=20;
	protected int salto=0;
	
	/**
	 * Pone a moverse o saltar al pajaro
	 */
	public void saltar() {
		salto=13;
		yVel=-salto;	
	}
	/**
	 * Hace morir al pajaro
	 */
	public void morir() {
		estaMuerto=true;
		/*while((yPosition+tamanoY)<=(mundo.getAltura()-mundo.getAltura()/6)){
			caer();
		}
		yPosition=(mundo.getAltura()-mundo.getAltura()/6)-tamanoY; */      
	}
	/**
	 * Mira si el pajaro esta muerto
	 * @return boleano si esta muerto
	 */
	public boolean estaMuerto() {
		return estaMuerto;
	}
	/**
	 * Da la posicion del pajaro en X
	 * @return entero de la posicion
	 */
	public int getPosX() {
		return xPosition;
	}
	/**
	 * Da la posicion del pajaro en Y
	 * @return entero de la posicion
	 */
	public int getPosY() {
		return yPosition;
	}
	/**
	 * Cambia la posicion X del pajaro
	 * @param x entero de la posicion
	 */
	public void setPositionX(int x) {
		xPosition=x/2-(2*x/5-x/8);
	}
	/**
	 * Cambia la posicion Y del pajaro
	 * @param y entero de la posicion
	 */
	public void setPositionY(int y) {
		yPosition=y/2;
	}
	/**
	 * Cambia el tama�o del pajaro en X
	 * @param tam entero del tama�o deseado
	 */
	public void setTamanoX(int tam) {
		tamanoX=tam/14;
	}
	/**
	 * Cambia el tama�o del pajaro en Y
	 * @param tam entero del tama�o deseado
	 */
	public void setTamanoY(int tam) {
		tamanoY=tam/14;
	}
	/**
	 * Da el tama�o del pajaro en X
	 * @return entero del tama�o
	 */
	public int getTamanoX() {
		return tamanoX;
	}
	/**
	 * Da el tama�o del pajaro en Y
	 * @return entero del tama�o
	 */
	public int getTamanoY() {
		return tamanoY;
	}
	/**
	 * Da la velocidad a la que cae el pajaro
	 */
	public void caer() {
		if(yPosition<(mundo.getAltura()-mundo.getAltura()/6)-tamanoY && estaMuerto) {
			if(salto!=0) {
				yPosition+=yVel;
				}
				if(yVel+GRAVEDAD<velLim){
					yVel+=GRAVEDAD;
				}
		}else if(yPosition>(mundo.getAltura()-mundo.getAltura()/6)-tamanoY && estaMuerto){
			yPosition=(mundo.getAltura()-mundo.getAltura()/6)-tamanoY;
			}
		else if(!estaMuerto){
			if(salto!=0) {
			yPosition+=yVel;
			}
			if(yVel+GRAVEDAD<velLim){
				yVel+=GRAVEDAD;
				}
			}
		else {
			
		}
	}
		/*if(yVel+GRAVEDAD<velLim) {
			yVel+=GRAVEDAD;
		}   
		try {
			Thread.sleep(20);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}

