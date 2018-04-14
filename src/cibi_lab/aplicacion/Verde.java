package cibi_lab.aplicacion;

import cibi_lab.aplicacion.Mundo;

/**
 * @author: Sergio Pe�a-David Rodriguez
 * @version: 17/11/2017
 */
public class Verde extends Tubo{
	//Esta clase es el tubo verde con el que se puede chocar el pajaro
	/**
	 * Constructor del tubo verde
	 * @param mundo donde van a aparecer los tubos
	 * @param inicioTuboAbajo en el punto donde van a aparecer los tubos
	 */
	public Verde(Mundo mundo,int inicioTuboAbajo) {
		this.mundo=mundo;
		xPositionPrimerTubo=mundo.getAnchura();
		xPositionSegundoTubo=mundo.getAnchura();
		yPositionPrimerTubo=inicioTuboAbajo;
		yPositionSegundoTubo=inicioTuboAbajo-mundo.getBrecha();
		tamanoYPrimerTubo=mundo.getAltura();
		tamanoYSegundoTubo=mundo.getAltura();
		tamanoXPrimerTubo=mundo.getAnchura()/8;
		tamanoXSegundoTubo=mundo.getAnchura()/8;
	}
}
