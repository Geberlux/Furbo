import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		GestorEquipos nuevo = new GestorEquipos();
		nuevo.getEquipos().add(new Equipo("Argentinos Juniors","La Paternal"));
		nuevo.getEquipos().add(new Equipo("River","Nuñez"));
		nuevo.getEquipos().add(new Equipo("Boca","La boca"));
		nuevo.getEquipos().add(new Equipo("Atlanta","Villa Crespo"));
		nuevo.getEquipos().add(new Equipo("Huracán","Parque Patricios"));
		nuevo.getEquipos().add(new Equipo("Sacachispas","Villa Soldati"));
		nuevo.getEquipos().add(new Equipo("San Lorenzo","Boedo"));
		nuevo.getEquipos().add(new Equipo("Vélez","Liniers"));
		nuevo.RellenarTodosLosEquipos();
		
		LinkedList<Equipo> equiposGanadores = new LinkedList<Equipo>();
		LinkedList<Equipo> equiposFinalistas = new LinkedList<Equipo>();
		LinkedList<Equipo> equipoCampeon = new LinkedList<Equipo>();
		String[] Opciones = {
			
			"Empezar Torneo","Ver Partidos","Salir"
				
		};
		int opcion =0;
		do {
			opcion = JOptionPane.showOptionDialog(null,
					"Bienvenido",
					"Torneo de Futbol",
					(0),
					JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("img/copa.png")),
					Opciones,
					Opciones[0]);
			
			switch (opcion) {
			case 0:
				if(Partido.getCantPartidos()>=4){
					//Semis
					Partido jugado = nuevo.JugarPartido(seleccionarEquipo(equiposGanadores),seleccionarEquipo(equiposGanadores));
					nuevo.getPartidos().add(jugado);
					JOptionPane.showMessageDialog(null, "Se jugó el partido: "+jugado);
					JOptionPane.showMessageDialog(null, "Ganador: "+jugado.DeterminarGanador());
					equiposFinalistas.add(jugado.DeterminarGanador()); 
				}else {
					Partido jugado = nuevo.JugarPartido(seleccionarEquipo(nuevo.getEquipos()),seleccionarEquipo(nuevo.getEquipos()));
					nuevo.getPartidos().add(jugado);
					JOptionPane.showMessageDialog(null, "Se jugó el partido: "+jugado);
					JOptionPane.showMessageDialog(null, "Ganador: "+jugado.DeterminarGanador());
					equiposGanadores.add(jugado.DeterminarGanador()); 
				}
				if(Partido.getCantPartidos()>=6){
					Partido jugado = nuevo.JugarPartido(seleccionarEquipo(equiposFinalistas),seleccionarEquipo(equiposFinalistas));
					JOptionPane.showInternalMessageDialog(null, "El Ganador del torneo es"+jugado);
					equipoCampeon.add(jugado.DeterminarGanador());
				}
				break;
			case 1: 
				JOptionPane.showMessageDialog(null,"Lista de Partidos" + nuevo.getPartidos());
				JOptionPane.showMessageDialog(null,"Lista de Ganadores" + equiposGanadores);
				JOptionPane.showMessageDialog(null,"Lista de Ganadores" + equiposFinalistas);
				JOptionPane.showMessageDialog(null,"Lista de Ganadores" + equipoCampeon);
				break;

			case 2: 
				JOptionPane.showMessageDialog(null, "Salir menu principal");

				break;
			}
			
			
		} while (opcion!=2);
		
		
	
	}
	
	public static Equipo seleccionarEquipo(LinkedList<Equipo> equipos) {
		String[] equiposarray = new String[equipos.size()];
		for (int i = 0; i < equipos.size(); i++) {
			equiposarray[i] = equipos.get(i).getNombre();
		}
		
		int opcion = JOptionPane.showOptionDialog(null, 
				"Seleccione equipo", null, 0, 0, null, equiposarray, equiposarray[0]);
		Equipo selecionado = equipos.get(opcion);
		equipos.remove(opcion);
		return selecionado;
		

	}
	
		
	

}