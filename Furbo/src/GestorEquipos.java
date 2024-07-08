import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GestorEquipos {
	private LinkedList<Equipo> equipos = new  LinkedList<Equipo> ();
	private LinkedList<Partido> partidos = new LinkedList<Partido> ();
	public GestorEquipos() {
		
	}

	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}
	public LinkedList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(LinkedList<Partido> partidos) {
		this.partidos = partidos;
	}

	public void RellenarTodosLosEquipos() {
		for (Equipo equipo : equipos) {
			equipo.agregarJugadoresFalso(11);
		}
	}
	
	public Partido JugarPartido(Equipo equipo1, Equipo equipo2) {
		if (equipo1==equipo2) {
			JOptionPane.showMessageDialog(null, "No se puede jugar entre el mismo equipo");
			return null;
		} else {
			if (equipo1.getJugadores().size()<7 || equipo2.getJugadores().size()<7) {
				JOptionPane.showMessageDialog(null, "No se puede jugar, faltan jugadores");
				return null;
			} else {

			JOptionPane.showMessageDialog(null, "Se enfrentan " + equipo1.getNombre() + " vs " + equipo2.getNombre());
			
			int goles1;
			int goles2;
			do {
				goles1 = (int)(Math.random()*5);
				goles2 = (int)(Math.random()*5);
				if (goles1==goles2) {
					JOptionPane.showMessageDialog(null, "Hay penales");
				}
			} while (goles1==goles2);

			return new Partido(equipo1,equipo2,goles1,goles2);
		}
		}
		
	}
	
}