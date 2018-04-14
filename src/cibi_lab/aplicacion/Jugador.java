package cibi_lab.aplicacion;

import cibi_lab.aplicacion.Mundo;

/**
 * @author: Sergio Pe�a-David Rodriguez
 * @version: 17/11/2017
 */
public class Jugador extends Pajaro{
	//Clase tipo de pajaro controlado por el jugador
	/**
	 * Constructor que inicializa al pajaro controlado
	 * @param mundo donde va a estar el pajaro
	 */
	public Jugador(Mundo mundo) {
		this.mundo=mundo;
		xPosition=mundo.getAnchura()/2;
		yPosition=mundo.getAltura()/2;
		tamanoX=mundo.getAnchura()/12;
		tamanoY=mundo.getAltura()/13;
	}
}
